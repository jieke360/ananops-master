package com.ananops.provider.web;

import com.ananops.provider.model.domain.Basebill;
import com.ananops.provider.service.impl.BaseServiceImpl;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BaseBillController {
    @Resource
    BaseServiceImpl baseServiceImpl;

    @GetMapping(value = "/create")
    @ApiOperation(httpMethod = "POST",value = "创建账单")
    public Wrapper<String> createNew(@ApiParam(name = "body",value="账单信息") @RequestBody String body){
        baseServiceImpl.insert(body);
        return  WrapMapper.ok("success");
    }

    @GetMapping(value = "/getallbyuser")
    @ApiOperation(httpMethod = "GET",value = "根据用户id获取所有账单")
    public  Wrapper<List<Basebill>> getAllBillByUserId(@ApiParam(name = "userid",value = "用户id") String userid){
        return WrapMapper.ok(baseServiceImpl.getAllBillByUserId(userid));
    }

    @GetMapping(value = "/getamountbyworkorder")
    @ApiOperation(httpMethod = "GET",value = "根据工单id获取金额")
    public Wrapper<Float> getAmountByworkorderid(@ApiParam(name = "workorderid",value = "工单id") String workorderid){
        return WrapMapper.ok(baseServiceImpl.getAmountByworkorderid(workorderid));
    }

    @GetMapping(value = "/modifyamount")
    @ApiOperation(httpMethod = "PUT",value = "修改金额")
    public void modifyAmount(@ApiParam(name = "id",value = "账单id") String id,
                             @ApiParam(name = "modifyAmount",value = "修改金额") Float modifyAmount){
        Basebill basebill = baseServiceImpl.getBillById(id);
        baseServiceImpl.modifyAmount(basebill, modifyAmount);
    }

    @GetMapping(value = "/getubill")
    @ApiOperation(httpMethod = "GET",value = "根据状态及用户id获取账单")
    public Wrapper<List<Basebill>> getAllUBillBystate(@ApiParam(name = "userid",value = "用户id") String userid,
                                             @ApiParam(name = "state",value = "状态") String state){
        return WrapMapper.ok(baseServiceImpl.getAllUBillBystate(userid, state));
    }
}
