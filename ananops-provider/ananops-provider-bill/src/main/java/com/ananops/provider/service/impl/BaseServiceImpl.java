package com.ananops.provider.service.impl;

import com.ananops.provider.mapper.BasebillMapper;
import com.ananops.provider.model.domain.Basebill;
import com.ananops.provider.model.dto.BillCreateDto;
import com.ananops.provider.model.dto.BillDisplayDto;
import com.ananops.provider.model.dto.user.UserInfoDto;
import com.ananops.provider.model.service.UacUserFeignApi;
import com.ananops.provider.model.vo.CompanyVo;
import com.ananops.provider.service.BaseService;
import com.ananops.provider.service.SpcCompanyFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    BasebillMapper basebillMapper;

    @Resource
    private UacUserFeignApi uacUserFeignApi;

    @Resource
    private SpcCompanyFeignApi spcCompanyFeignApi;

    @Override
    public void insert(BillCreateDto billCreateDto, Float devicePrice, Float servicePrice, String transactionMethod) {
//        JSONObject jsonObject=JSONObject.parseObject(billCreateDto.toString());
//        String paymentMethod=jsonObject.get("paymentMethod").toString();
//        String userid=jsonObject.get("userid").toString();
//        String workorderid=jsonObject.get("workorderid").toString();
//        String supplier=jsonObject.get("supplier").toString();
        //TODO
//        Float amount=Float.valueOf(jsonObject.get("amount").toString());
//        String transactionMethod=jsonObject.get("transactionMethod").toString();
//        String payDto = jsonObject.get("payDto").toString();
//        JsonObject jsonObject1 = new JsonParser().parse(payDto).getAsJsonObject();
        Date date=new Date();
        Long time=date.getTime();
        Basebill bill = new Basebill();
        Long timestamp = System.currentTimeMillis();
        String id = String.valueOf(timestamp)+billCreateDto.getUserid();
        bill.setId(id);
        bill.setPaymentMethod(billCreateDto.getPaymentMethod());
        bill.setTransactionMethod(transactionMethod);
        bill.setUserid(billCreateDto.getUserid());
        bill.setTime(time);
        bill.setSupplier(billCreateDto.getSupplier());
        bill.setWorkorderid(billCreateDto.getWorkorderid());
        bill.setDeviceAmount(devicePrice);
        bill.setServiceAmount(servicePrice);
        bill.setAmount(bill.getDeviceAmount() + bill.getServiceAmount());
        basebillMapper.insertSelective(bill);
    }

    @Override
    public List<BillDisplayDto> getAllBillByUserId(String userid) {
        //使用模板example获取BaseBill类
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(userid);

        //将获取到的BaseBill类添加到basebills列表中去
//        List<TaskDto> imcTaskDtos = imcTaskFeignApi.getByFacilitatorId(taskQueryDto).getResult();
        List<Basebill> basebills = basebillMapper.selectByExample(example);

        //创建待返回的账单展示传输对象
        List<BillDisplayDto> billDisplayDtoList = new ArrayList<>();
        if(basebills != null){
            for(Basebill OneBaseBill : basebills){
                BillDisplayDto billDisplayDto = new BillDisplayDto();
                UserInfoDto uacUserInfo = uacUserFeignApi.getUacUserById(Long.valueOf(OneBaseBill.getUserid())).getResult();
                if(uacUserInfo != null){
                    billDisplayDto.setUserName(uacUserInfo.getUserName());
                }
                CompanyVo companyVo = spcCompanyFeignApi.getCompanyDetailsById(Long.valueOf(OneBaseBill.getSupplier())).getResult();
                if(companyVo != null){
                    billDisplayDto.setSupplierName(companyVo.getGroupName());
                }
                try{
                    BeanUtils.copyProperties(OneBaseBill,billDisplayDto);
                }catch (Exception e){
                    log.error("账单BaseBill与账单展示billDisplayDto属性拷贝异常");
                    e.printStackTrace();
                }

                //没问题就添加到待返回列表中
                billDisplayDtoList.add(billDisplayDto);

            }
        }
        return billDisplayDtoList;
    }

    public BillDisplayDto getOneBillById(String id) {
        Basebill baseBill = getBillById(id);

        //创建待返回的账单展示传输对象
        BillDisplayDto billDisplayDto = new BillDisplayDto();
        UserInfoDto uacUserInfo = uacUserFeignApi.getUacUserById(Long.valueOf(baseBill.getUserid())).getResult();
        if(uacUserInfo != null){
            billDisplayDto.setUserName(uacUserInfo.getUserName());
        }
        CompanyVo companyVo = spcCompanyFeignApi.getCompanyDetailsById(Long.valueOf(baseBill.getSupplier())).getResult();
        if(companyVo != null){
            billDisplayDto.setSupplierName(companyVo.getGroupName());
        }
        try{
            BeanUtils.copyProperties(baseBill,billDisplayDto);
        }catch (Exception e){
            log.error("账单BaseBill与账单展示billDisplayDto属性拷贝异常");
            e.printStackTrace();
        }

        return billDisplayDto;
    }

    @Override
    public Float getAmountByworkorderid(String workorderid) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(workorderid);
        List<Basebill> list = basebillMapper.selectByExample(example);
        Basebill basebill = list.get(0);
        return basebill.getAmount();
    }

    @Override
    public Basebill getBillById(String id) {
        return basebillMapper.selectByPrimaryKey(id);
    }

    @Override
    public void modifyAmount(Basebill basebill, Float modifyAmount) {
        basebill.setAmount(modifyAmount);
        basebillMapper.updateByPrimaryKey(basebill);

    }

    @Override
    public List<Basebill> getAllUBillBystate(String userid, String state) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(userid);
        List<Basebill> list = basebillMapper.selectByExample(example);
        List<Basebill> listnew = new ArrayList<>();
        if(list != null && list.size()>0){
            for(Basebill basebill:list){
                if(basebill.getState().equals(state)){
                    listnew.add(basebill);
                }
            }
        }
        return listnew;
    }

    @Override
    public List<Basebill> getBillByWorkOrderId(String workOrderId) {
        Example example = new Example(Basebill.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(workOrderId);
        return basebillMapper.selectByExample(example);
    }
}
