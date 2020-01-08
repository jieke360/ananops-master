package com.ananops.provider.service.impl;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.DeviceOrderMapper;
import com.ananops.provider.model.domain.Approve;
import com.ananops.provider.model.domain.Device;
import com.ananops.provider.model.domain.DeviceOrder;
import com.ananops.provider.model.dto.CreateNewOrderDto;
import com.ananops.provider.model.dto.DeviceOrderItemInfoDto;
import com.ananops.provider.model.dto.ProcessOrderDto;
import com.ananops.provider.model.enums.DeviceOrderStatusEnum;
import com.ananops.provider.model.vo.ProcessOrderResultVo;
import com.ananops.provider.service.ApproveService;
import com.ananops.provider.service.DeviceOrderService;
import com.ananops.provider.service.DeviceService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DeviceOrderServiceImpl extends BaseService<DeviceOrder> implements DeviceOrderService {
    
    @Autowired
    ApproveService approveService;
    
    @Autowired
    DeviceOrderMapper deviceOrderMapper;
    
    @Autowired
    DeviceService deviceService;


    public ProcessOrderResultVo createNewOrder(LoginAuthDto loginAuthDto, CreateNewOrderDto createNewOrderDto) {
        logger.info("创建备品备件订单... CreateNewOrderDto = {}", createNewOrderDto);
        
        ProcessOrderResultVo ret = new ProcessOrderResultVo();
        
        DeviceOrder deviceOrder = new DeviceOrder();
        BeanUtils.copyProperties(createNewOrderDto, deviceOrder, "items");
        List<DeviceOrderItemInfoDto> items = createNewOrderDto.getItems();
        JSONArray itemArray = new JSONArray();
        for (DeviceOrderItemInfoDto item: items){
            Device device = new Device();
            BeanUtils.copyProperties(item, device);
            itemArray.add(device);
        }
        deviceOrder.setItems(itemArray.toJSONString());
        deviceOrder.setStatus(DeviceOrderStatusEnum.ShenHeZhong.getCode());
        deviceOrder.setStatusMsg(DeviceOrderStatusEnum.ShenHeZhong.getMsg());
        deviceOrder.setUpdateInfo(loginAuthDto);
        deviceOrder.setVersion(1);
        save(deviceOrder);
        if(deviceOrder.isNew()){
            throw new BusinessException(ErrorCodeEnum.RDC100000004);
        }
        ret.setDeviceOrderInfo(deviceOrder);
        
        logger.info("备品备件订单创建成功[OK], DeviceOrder = {}", deviceOrder);
        
        logger.info("创建备品备件订单审核记录...");
        
        Approve approve = new Approve();
        approve.setVersion(1);
        approve.setApplicantId(loginAuthDto.getUserId());
        approve.setApplicant(loginAuthDto.getUserName());
        BeanUtils.copyProperties(createNewOrderDto, approve,"objectType", "objectId");
        approve.setObjectType(1); // 1.表示备品备件订单
        approve.setObjectId(deviceOrder.getId());
        approveService.save(approve);
        if(approve.getId() == null) {
            throw new BusinessException(ErrorCodeEnum.RDC100000000);
        }

        List<Approve> approves = Lists.newArrayList(approve);
        ret.setApproveInfo(approves);
        
        logger.info("创建审批记录成功[OK], Approves = {}", approve);
        
        return ret;
    }

    @Transactional
    public ProcessOrderResultVo processOrder(LoginAuthDto loginAuthDto, ProcessOrderDto processOrderDto) {
        logger.info("处理备品备件订单中... ProcessOrderDto = {}", processOrderDto);
        
        ProcessOrderResultVo ret = new ProcessOrderResultVo();
        
        // 检查备品备件订单
        Long orderId = processOrderDto.getId();
        DeviceOrder order = selectByKey(orderId);
        logger.info("获取当前订单详情， DeviceOrder = {}", order);
        if (order == null) {
            throw new BusinessException(ErrorCodeEnum.RDC100000002);
        }

        // 获取当前审核记录
        Long objectId = processOrderDto.getObjectId();
        List<Approve> approveList = approveService.selectByObject(1, objectId);
        logger.info("获取当前订单审核记录，Approve = {}", approveList);
        if(approveList.size() == 0) {
            throw new BusinessException(ErrorCodeEnum.RDC100000002);
        }
        Approve approve = approveList.get(0);
        approve.setVersion(0);
        String suggestion = processOrderDto.getSuggestion();
        approve.setSuggestion(suggestion);
        String result = processOrderDto.getResult();
        approve.setResult(result);
        // todo 校验下一级审核人的身份
        Long nextApproverId = processOrderDto.getNextApproverId();
        approve.setNextApproverId(nextApproverId);
        String nextApprover = processOrderDto.getNextApprover();
        approve.setNextApprover(nextApprover);
        int update =approveService.update(approve);
        if(update != 1) {
            throw new BusinessException(ErrorCodeEnum.RDC100000004);
        }

        if (nextApproverId!= null) {  // 有下一级审核人，更新信息，新建审核
            // 创建一条新审核记录
            Approve newApprover = new Approve();

            // 检索是否已创建相同审核记录
            if(approveService.isExist(approve)){
                throw new BusinessException(ErrorCodeEnum.RDC100000003);
            }
            
            // 初始化下一级审核记录
            newApprover.setVersion(1);
            newApprover.setObjectType(approve.getObjectType());
            newApprover.setObjectId(approve.getObjectId());
            newApprover.setPreviousApproverId(approve.getCurrentApproverId());
            newApprover.setPreviousApprover(approve.getPreviousApprover());
            newApprover.setCurrentApproverId(nextApproverId);
            newApprover.setCurrentApprover(nextApprover);
            newApprover.setApplicantId(approve.getApplicantId());
            newApprover.setApplicant(approve.getApplicant());
            approveService.save(approve);

            logger.info("新增一条审核记录， Approve = {}", newApprover);
            
        } else {

            // 没有下一级审核人，将订单改为已完成
            order.setVersion(0);
            order.setStatus(DeviceOrderStatusEnum.ShenHeWanCheng.getCode());
            order.setStatusMsg(DeviceOrderStatusEnum.ShenHeWanCheng.getMsg());
            Float discount = processOrderDto.getDiscount();
            if (discount == null) {
                discount = 10.0f;
            }
            BigDecimal totalPrice = processOrderDto.getTotalPrice().multiply(new BigDecimal(discount*0.1));
            order.setTotalPrice(totalPrice);
            order.setProcessResult(result);
            order.setProcessMsg(suggestion);
            // todo 添加报价单
            order.setUpdateInfo(loginAuthDto);
            update(order);
        }
        
        ret.setDeviceOrderInfo(order);
        List<Approve> approves = approveService.selectByObject(1, objectId);
        ret.setApproveInfo(approves);

        logger.info("处理备品备件成功[OK]，ProcessOrderResult = {}", ret);
        return ret;
    }
    
    public List<DeviceOrder> getOrderByApproverIdAndVersion(Long approverId, Integer version) {
        return deviceOrderMapper.selectByApproverIdAndVersion(approverId, version);
    }
    
    public int getOrderCountByApproverIdAndVersion(Long approverId, Integer version){
        return deviceOrderMapper.selectCountByApproverIdAndVersion(approverId, version);
    }
    
    public DeviceOrder getOrderByObjectIdAndObjectType(Long objectId,Integer objectType) {
        try {
            return deviceOrderMapper.selectByObject(objectType, objectId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    
}
