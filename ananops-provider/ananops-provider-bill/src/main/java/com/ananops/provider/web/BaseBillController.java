package com.ananops.provider.web;

import com.alibaba.fastjson.JSONObject;
import com.ananops.provider.model.domain.BmcBill;
import com.ananops.provider.model.dto.*;
import com.ananops.provider.model.dto.PmcPayDto;
import com.ananops.provider.model.dto.group.CompanyDto;
import com.ananops.provider.model.dto.group.GroupSaveDto;
import com.ananops.provider.model.service.UacGroupBindUserFeignApi;
import com.ananops.provider.model.service.UacGroupFeignApi;
import com.ananops.provider.model.service.UacUserFeignApi;
import com.ananops.provider.service.PmcContractFeignApi;
import com.ananops.provider.service.impl.BaseServiceImpl;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.*;
import service.RdcDeviceOrderFeignApi;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
@Slf4j
public class BaseBillController {

//    @Resource
//    RdcDeviceOrderFeignApi rdcDeviceOrderFeignApi;
    @Resource
    PmcContractFeignApi pmcContractFeignApi;
    @Resource
    BaseServiceImpl baseServiceImpl;
    @Resource
    UacGroupBindUserFeignApi uacGroupBindUserFeignApi;
    @Resource
    UacGroupFeignApi uacGroupFeignApi;

    @PostMapping(value = "/create")
    @ApiOperation(httpMethod = "POST",value = "创建账单")
    public Wrapper<String> createNew(@ApiParam(name = "body",value="账单信息") @RequestBody BillCreateDto billCreateDto){
        PmcPayDto pmcPayDto = new PmcPayDto();
        if (billCreateDto.getUserId()!=null && billCreateDto.getSupplier()!=null){
            Long partyAIdResult = uacGroupBindUserFeignApi.getGroupIdByUserId(billCreateDto.getUserId()).getResult();
            String partyAType = uacGroupFeignApi.getUacGroupById(partyAIdResult).getResult().getType();
            if (partyAType.equals("company")){
            }else if (partyAType.equals("department")){
                partyAIdResult = uacGroupFeignApi.getCompanyInfoById(partyAIdResult).getResult().getId();
            }else {
                return WrapMapper.error("未知的组织类型！组织ID："+partyAIdResult+"组织类型："+partyAType+"请至数据库查看详情或与开发人员联系");
            }
            Long partyBIdResult = uacGroupBindUserFeignApi.getGroupIdByUserId(billCreateDto.getSupplier()).getResult();
            String partyBType = uacGroupFeignApi.getUacGroupById(partyBIdResult).getResult().getType();
            if (partyAType.equals("company")){
            }else if (partyBType.equals("department")){
                partyBIdResult = uacGroupFeignApi.getCompanyInfoById(partyBIdResult).getResult().getId();
            }else {
                return WrapMapper.error("未知的组织类型！组织ID："+partyAIdResult+"组织类型："+partyAType+"请至数据库查看详情或与开发人员联系");
            }
            billCreateDto.setSupplier(partyBIdResult);
            com.ananops.wrapper.Wrapper<List<PmcPayDto>> list = pmcContractFeignApi.getContactByAB(partyAIdResult,partyBIdResult);
            if (list.getResult() == null) {
                log.info("该用户与该服务商没有合同");
                return WrapMapper.error("该用户与该服务商没有合同"+"partyAID:"+partyAIdResult+"partyBID:"+partyBIdResult);
            }
            List<PmcPayDto> payDtoList = new ArrayList<>(list.getResult());
            for (PmcPayDto payDto : payDtoList) {
                try {
                    BeanUtils.copyProperties(pmcPayDto, payDto);
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        Float servicePrice = null;
        String transactionMethod = null;
        if (pmcPayDto.getPaymentMoney() != null){
            servicePrice = pmcPayDto.getPaymentMoney().floatValue();
        }
        if (pmcPayDto.getPaymentType() != null){
            transactionMethod = pmcPayDto.getPaymentType().toString();
        }
        if (billCreateDto.getDeviceDtos() != null){
            List<DeviceDto> deviceDtoList = billCreateDto.getDeviceDtos();
            List<Long> deviceIds = new ArrayList<>();
            for (DeviceDto deviceDto : deviceDtoList) {
                deviceIds.add(deviceDto.getDeviceId());
            }
        }
//        com.ananops.wrapper.Wrapper<Object> objects = rdcDeviceOrderFeignApi.getPriceOfDevices(deviceIds);
//        List<JSONObject> jsonObjects = (List<JSONObject>)objects.getResult();
        Float devicePrice = 0.0F;
//        for (JSONObject object : jsonObjects) {
//            devicePrice += object.getBigDecimal("price").floatValue();
//        }

        baseServiceImpl.insert(billCreateDto, devicePrice, servicePrice, transactionMethod);
        return  WrapMapper.ok("success");
    }

    @PostMapping(value = "/createFakeOrder")
    @ApiOperation(httpMethod = "POST",value = "创建账单")
    public Wrapper<Float> createFakeNew(@ApiParam(name = "body",value="账单信息") @RequestBody BillCreateDto billCreateDto){
        PmcPayDto pmcPayDto = new PmcPayDto();
        Long partyAIdResult = uacGroupBindUserFeignApi.getGroupIdByUserId(billCreateDto.getUserId()).getResult();
        String partyAType = uacGroupFeignApi.getUacGroupById(partyAIdResult).getResult().getType();
        if (partyAType.equals("company")){
        }else if (partyAType.equals("department")){
            partyAIdResult = uacGroupFeignApi.getCompanyInfoById(partyAIdResult).getResult().getId();
        }else {
            return WrapMapper.error("未知的组织类型！组织ID："+partyAIdResult+"组织类型："+partyAType+"请至数据库查看详情或与开发人员联系");
        }
        Long partyBIdResult = uacGroupBindUserFeignApi.getGroupIdByUserId(billCreateDto.getSupplier()).getResult();
        com.ananops.wrapper.Wrapper<GroupSaveDto> partyBGroupSaveDto = uacGroupFeignApi.getUacGroupById(partyBIdResult);
        String partyBType = partyBGroupSaveDto.getResult().getType();
        if (partyAType.equals("company")){
        }else if (partyBType.equals("department")){
            partyBIdResult = uacGroupFeignApi.getCompanyInfoById(partyBIdResult).getResult().getId();
        }else {
            return WrapMapper.error("未知的组织类型！组织ID："+partyAIdResult+"组织类型："+partyAType+"请至数据库查看详情或与开发人员联系");
        }
        com.ananops.wrapper.Wrapper<List<PmcPayDto>> list = pmcContractFeignApi.getContactByAB(partyAIdResult,partyBIdResult);
        if (list.getResult() == null) {
            log.info("该用户与该服务商没有合同");
            return WrapMapper.error("该用户与该服务商没有合同"+"partyAID:"+partyAIdResult+"partyBID:"+partyBIdResult);
        }
        List<PmcPayDto> payDtoList = new ArrayList<>(list.getResult());
        for (PmcPayDto payDto : payDtoList) {
            try {
                BeanUtils.copyProperties(pmcPayDto, payDto);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (pmcPayDto.getPaymentMoney() == null){
            return WrapMapper.error("交易金额为空！请仔细查看合同！合同双方："+"partyAID:"+partyAIdResult+"partyBID:"+partyBIdResult);
        }
        Float servicePrice = pmcPayDto.getPaymentMoney().floatValue();
//        List<DeviceDto> deviceDtoList = billCreateDto.getDeviceDtos();
//        List<Long> deviceIds = new ArrayList<>();
//        for (DeviceDto deviceDto : deviceDtoList) {
//            deviceIds.add(deviceDto.getDeviceId());
//        }
//        com.ananops.wrapper.Wrapper<Object> objects = rdcDeviceOrderFeignApi.getPriceOfDevices(deviceIds);
//        List<JSONObject> jsonObjects = (List<JSONObject>)objects.getResult();
        Float devicePrice = 0.0F;
//        for (JSONObject object : jsonObjects) {
//            devicePrice += object.getBigDecimal("price").floatValue();
//        }

        return  WrapMapper.ok(servicePrice + devicePrice);
    }

    @GetMapping(value = "/getAllByUser/{userId}")
    @ApiOperation(httpMethod = "GET",value = "根据用户id获取所有账单")
    public  Wrapper<List<BillDisplayDto>> getAllBillByUserId(@ApiParam(name = "userId",value = "用户id") @RequestParam Long userId){
        return WrapMapper.ok(baseServiceImpl.getAllBillByUserId(userId));
    }

    @PostMapping(value = "/getBillById/{id}")
    @ApiOperation(httpMethod = "POST",value = "根据账单id获取账单")
    public  Wrapper<BillDisplayDto> getBillById(@PathVariable Long id){
        return WrapMapper.ok(baseServiceImpl.getOneBillById(id));
    }

    @GetMapping(value = "/getAmountByWorkOrder/{workOrderId}")
    @ApiOperation(httpMethod = "GET",value = "根据工单id获取金额")
    public Wrapper<Float> getAmountByWorkOrderId(@ApiParam(name = "workOrderId",value = "工单id") @RequestParam Long workOrderId){
        return WrapMapper.ok(baseServiceImpl.getAmountByWorkOrderId(workOrderId));
    }

    @PutMapping(value = "/modifyAmount")
    @ApiOperation(httpMethod = "PUT",value = "修改金额")
    public void modifyAmount(@ApiParam(name = "modifyAmount",value = "修改金额") @RequestBody BillModifyAmountDto billModifyAmountDto){
        BmcBill bmcBill = baseServiceImpl.getBillById(billModifyAmountDto.getId());
        baseServiceImpl.modifyAmount(bmcBill, billModifyAmountDto.getModifyAmount());
    }

    @GetMapping(value = "/getUBill/{userId}/{state}")
    @ApiOperation(httpMethod = "GET",value = "根据状态及用户id获取账单")
    public Wrapper<List<BmcBill>> getAllUBillByState(@ApiParam(name = "userId",value = "用户id") @RequestParam Long userId,
                                                      @ApiParam(name = "state",value = "状态") @RequestParam String state){
        return WrapMapper.ok(baseServiceImpl.getAllUBillByState(userId, state));
    }

    @GetMapping(value = "/getBillByWorkOrderId/{workOrderId}")
    @ApiOperation(httpMethod = "GET",value = "根据状态及用户id获取账单")
    public Wrapper<List<BmcBill>> getBillByWorkOrderId(@ApiParam(name = "workOrderId",value = "工单id") @RequestParam Long workOrderId){
        return WrapMapper.ok(baseServiceImpl.getBillByWorkOrderId(workOrderId));
    }
}
