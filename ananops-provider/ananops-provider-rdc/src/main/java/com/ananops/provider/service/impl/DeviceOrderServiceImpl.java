package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.DeviceOrderMapper;
import com.ananops.provider.model.domain.Approve;
import com.ananops.provider.model.domain.DeviceOrder;
import com.ananops.provider.model.dto.CreateNewOrderDto;
import com.ananops.provider.model.dto.ProcessOrderDto;
import com.ananops.provider.model.enums.DeviceOrderStatusEnum;
import com.ananops.provider.model.vo.ProcessOrderResultVo;
import com.ananops.provider.service.ApproveService;
import com.ananops.provider.service.DeviceOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DeviceOrderServiceImpl extends BaseService<DeviceOrder> implements DeviceOrderService {
    
    @Autowired
    ApproveService approveService;
    
    @Autowired
    DeviceOrderMapper deviceOrderMapper;
    
    public DeviceOrder createNewOrder(LoginAuthDto loginAuthDto, CreateNewOrderDto createNewOrderDto) {
        logger.info("创建备品备件订单... CreateNewOrderDto = {}", createNewOrderDto);
        
        DeviceOrder deviceOrder = new DeviceOrder();
        BeanUtils.copyProperties(createNewOrderDto, deviceOrder);
        deviceOrder.setStatus(DeviceOrderStatusEnum.ShenHeZhong.getCode());
        deviceOrder.setStatusMsg(DeviceOrderStatusEnum.ShenHeZhong.getMsg());
        deviceOrder.setUpdateInfo(loginAuthDto);
        deviceOrder.setVersion(1);
        if (save(deviceOrder) == 1) {
            throw new BusinessException(ErrorCodeEnum.RDC100000000);
        }
        
        logger.info("备品备件订单创建成功[OK], DeviceOrder = {}", deviceOrder);
        return deviceOrder;
    }
    
    public ProcessOrderResultVo processOrder(LoginAuthDto loginAuthDto, ProcessOrderDto processOrderDto) {
        logger.info("处理备品备件订单中... ProcessOrderDto = {}", processOrderDto);
        
        ProcessOrderResultVo ret = new ProcessOrderResultVo();
        
        // 检查备品备件订单
        DeviceOrder order = selectByKey(processOrderDto.getId());
        if (order == null) {
            throw new BusinessException(ErrorCodeEnum.RDC100000002);
        }
    
        // 获取当前审核记录
        Approve approve = approveService.getOnProcessingApprove(loginAuthDto.getUserId(),
                processOrderDto.getObjectType(), processOrderDto.getObjectId());
    
        // 声明一条新审核记录
        Approve newApprover = new Approve();
        
        String result = processOrderDto.getResult();
        String suggestion = processOrderDto.getSuggestion();
        Long nextApproverId = processOrderDto.getNextApproverId();
        String nextApprover = processOrderDto.getNextApprover();
    
        Example example = new Example(Approve.class);
        Example.Criteria criteria= example.createCriteria();
        
        if (nextApproverId!= null) {  // 有下一级审核人，更新信息，新建审核
            
            // todo boolean validate(Long userId, String roleCode) 判断用户是否存在
            
            // 更新下一级审核人
            criteria.andEqualTo("nextApproverId", nextApproverId)
                    .andEqualTo("nextApprover", nextApprover);
            
            // 初始化下一级审核记录
            BeanUtils.copyProperties(approve, newApprover,
                    "id", "version","current_approver_id",
                    "current_approver","previous_approver_id","previous_approver");
            newApprover.setVersion(1);
            newApprover.setPreviousApproverId(approve.getCurrentApproverId());
            newApprover.setPreviousApprover(approve.getPreviousApprover());
            newApprover.setCurrentApproverId(nextApproverId);
            newApprover.setCurrentApprover(nextApprover);
            
        } else {
            
            // 没有下一级审核人，将订单改为已完成
            order.setStatus(DeviceOrderStatusEnum.ShenHeWanCheng.getCode());
            order.setStatusMsg(DeviceOrderStatusEnum.ShenHeWanCheng.getMsg());
            order.setUpdateInfo(loginAuthDto);
            order.setVersion(0);
            update(order);
        }
    
        // 更新审核结果和审核意见
        criteria.andEqualTo("version", 0)
                .andEqualTo("result",result)
                .andEqualTo("suggestion",suggestion);
        
        approveService.updateByExample(approve, example);
        
        // 新增一条审核
        if (nextApproverId!= null) {
            approveService.save(newApprover);
            logger.info("新增一条审核记录， Approve = {}", newApprover);
        }
        
        ret.setDeviceOrderInfo(order);
        approve = approveService.selectOne(approve);
        ret.setApproveInfo(approve);
        
        logger.info("处理备品备件成功[OK]，ProcessOrderResult = {}", ret);
        return ret;
    }
    
    public List<DeviceOrder> getOrderByApproverIdAndVersion(Long approverId, Integer version) {
        return deviceOrderMapper.selectByApproverIdAndVersion(approverId, version);
    }
    
    public int getOrderCountByApproverIdAndVersion(Long approverId, Integer version){
        return deviceOrderMapper.selectCountByApproverIdAndVersion(approverId, version);
    }
    
    public List<DeviceOrder> getOrderByObjectIdAndObjectType(Long objectId,Integer objectType) {
        Example example = new Example(DeviceOrder.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("object_id", objectId).andEqualTo("object_type", objectType);
        return selectByExample(example);
    }
    
}
