package com.ananops.provider.web.frontend;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.annotation.LogAnnotation;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.dto.WorkOrderDto;
import com.ananops.provider.model.dto.WorkOrderQueryDto;
import com.ananops.provider.model.vo.WorkOrderDetailVo;
import com.ananops.provider.model.vo.WorkOrderVo;
import com.ananops.provider.service.SpcWorkOrderService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务商模块对外提供操作WorkOrder(工单)的Restful接口
 *
 * Created by bingyueduan on 2020/1/3.
 */
@RestController
@RequestMapping(value = "/workorder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - SpcWorkOrderController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SpcWorkOrderController extends BaseController {

    @Resource
    private SpcWorkOrderService spcWorkOrderService;

    /**
     * 分页查询服务商下待处理工单.
     *
     * @param workOrderDto 传入的查询参数
     *
     * @return the wrapper
     */
    @PostMapping(value = "/queryAllWorkOrders")
    @LogAnnotation
    @ApiOperation(httpMethod = "POST", value = "分页查询服务商下工程师")
    public Wrapper<PageInfo<WorkOrderVo>> queryAllWorkOrders(@ApiParam(name = "workOrderDto", value = "工单查询参数") @RequestBody WorkOrderDto workOrderDto) {
        logger.info(" 分页查询参数 workOrderDto={}", workOrderDto);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        PageHelper.startPage(workOrderDto.getPageNum(), workOrderDto.getPageSize());
        workOrderDto.setOrderBy("update_time desc");
        List<WorkOrderVo> workOrderVoVoList = spcWorkOrderService.queryAllWorkOrders(workOrderDto, loginAuthDto);
        return WrapMapper.ok(new PageInfo<>(workOrderVoVoList));
    }

    /**
     * 通过工单Id查询工单信息
     *
     * @param workOrderQueryDto 工单查询参数
     *
     * @return 返回工单信息
     */
    @PostMapping(value = "/getSpcWorkOrderById")
    @LogAnnotation
    @ApiOperation(httpMethod = "POST", value = "工程师Id查询工程师信息")
    public Wrapper<WorkOrderDetailVo> getSpcWorkOrderById(@ApiParam(name = "workOrderQueryDto", value = "工单ID") @RequestBody WorkOrderQueryDto workOrderQueryDto) {
        logger.info("getSpcWorkOrderById - 根据工单Id查询工单信息. workOrderQueryDto={}", workOrderQueryDto);
        WorkOrderDetailVo workOrderDetailVo = spcWorkOrderService.queryByWorkOrderId(workOrderQueryDto);
        logger.info("getSpcWorkOrderById - 根据工单Id查询工单信息. [OK] workOrderDetailVo={}", workOrderDetailVo);
        return WrapMapper.ok(workOrderDetailVo);
    }
}
