package com.ananops.provider.web.fronted;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.dto.CreateNewOrderDto;
import com.ananops.provider.model.dto.ProcessOrderDto;
import com.ananops.provider.model.enums.DeviceOrderStatusEnum;
import com.ananops.provider.service.DeviceOrderService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import org.apache.zookeeper.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 备品备件订单
 * author: zhs
 */

@RestController
@RequestMapping("/deviceOrder")
public class DeviceOrderController extends BaseController {
    
    @Autowired
    DeviceOrderService orderService;
    
    /**
     * 备品备件需求申请处理
     * 1.
     */
    @PostMapping(value = "/operation")
    public Wrapper<Object> operation(@RequestBody ProcessOrderDto processOrderDto) {
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return WrapMapper.ok(orderService.processOrder(loginAuthDto, processOrderDto));
    }
    
    @PostMapping(value = "/create")
    public Wrapper<Object> createOrder(@RequestBody CreateNewOrderDto createNewOrderDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return WrapMapper.ok(orderService.createNewOrder(loginAuthDto, createNewOrderDto));
    }
    
    @GetMapping(value = "/todo/{userId}")
    public Wrapper<Object> getTodoDeviceOrderByUserId(@PathVariable("userId")Long userId){
        return WrapMapper.ok(orderService.getOrderByApproverIdAndVersion(userId, 1));
    }
    
    @GetMapping(value = "/done/{userId}")
    public Wrapper<Object> getDoneDeviceOrderByUserId(@PathVariable("userId")Long userId){
        return WrapMapper.ok(orderService.getOrderByApproverIdAndVersion(userId, 0));
    }
    
    @GetMapping(value = "/all/{userId}")
    public Wrapper<Object> getDeviceOrderByUserId(@PathVariable("userId")Long userId){
        return WrapMapper.ok(orderService.getOrderByApproverIdAndVersion(userId, null));
    }
    
    @GetMapping(value = "/object/{objectId}/{objectType}")
    public Wrapper<Object> getDeviceOrderByObject(@PathVariable("objectId")Long objectId,
                                                  @PathVariable("objectType")Integer objectType){
        return WrapMapper.ok(orderService.getOrderByObjectIdAndObjectType(objectId, objectType));
    }
}
