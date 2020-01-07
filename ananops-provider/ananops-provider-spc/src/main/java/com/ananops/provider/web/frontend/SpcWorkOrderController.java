package com.ananops.provider.web.frontend;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.annotation.LogAnnotation;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.dto.EngineerDto;
import com.ananops.provider.model.dto.WorkOrderDto;
import com.ananops.provider.model.dto.WorkOrderQueryDto;
import com.ananops.provider.model.vo.WorkOrderDetailVo;
import com.ananops.provider.model.vo.WorkOrderVo;
import com.ananops.provider.service.ImcTaskFeignApi;
import com.ananops.provider.service.MdmcTaskFeignApi;
import com.ananops.provider.service.SpcWorkOrderService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.codemodel.internal.fmt.JStaticFile;
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

    @Resource
    private ImcTaskFeignApi imcTaskFeignApi;

    @Resource
    private MdmcTaskFeignApi mdmcTaskFeignApi;
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

    /**
     * 通过工单ID查询对应项目ID
     * 通过项目ID查询对应项目下的工程师列表
     *
     * @param workOrderDto 工程师查询参数
     *
     * @return 返回工程师信息
     */
//    @PostMapping(value = "/getEngineerListByWorkOrderId")
////    @LogAnnotation
////    @ApiOperation(httpMethod = "GET", value = "通过工单ID查询工程师信息列表")
////    public Wrapper<List<EngineerDto>> getEngineerListByWorkOrderId(@ApiParam(name = "workOrderDto", value = "工单ID,") @RequestBody WorkOrderDto workOrderDto) {
////        logger.info("getSpcWorkOrderById - 根据工单Id查询工单信息. workOrderDto={}", workOrderDto);
////        List<EngineerDto> engineerDtoList = spcWorkOrderService.engineersDtoList(workOrderDto);
////        logger.info("getEngineerListByWorkOrderId - 通过工单ID查询工程师信息列表. [OK] workOrderDetailVo={}", engineerDtoList);
////        return WrapMapper.ok(engineerDtoList);
////    }

    /**
     * 分配工单信息中的工程师信息
     * 修改工单信息中的状态
     *
     * @param workOrderDto engineerDto 工单查询参数
     *
     * @return  是否成功
     */
//    @PostMapping(value = "/distributeEngineerWithWorkOrder")
//    @LogAnnotation
//    @ApiOperation(httpMethod = "POST", value = "分配工单信息中的工程师信息,状态")
//    public Wrapper<Integer> distributeEngineerWithWorkOrder(@ApiParam(name = "workOrderDto ,engineerDto", value = "工单ID,工程师ID") @RequestBody WorkOrderDto workOrderDto, EngineerDto engineerDto) {
//        logger.info("getSpcWorkOrderById - 根据工单Id查询工单信息. workOrderDto={}", workOrderDto);
//        LoginAuthDto loginAuthDto = getLoginAuthDto();
//        spcWorkOrderService.distributeEngineer(workOrderDto,loginAuthDto,engineerDto.getId());
//        return WrapMapper.ok();
//    }

    /**
     *转单
     *
     * @param workOrderDto engineerDto 工单查询参数
     *
     * @return  是否成功
     */
//    @PostMapping(value = "/transferWorkOrder")
////    @LogAnnotation
////    @ApiOperation(httpMethod = "POST", value = "转单,将工单信息中工程师置空")
////    public Wrapper<Integer> transferWorkOrder(@ApiParam(name = "workOrderDto", value = "工单ID") @RequestBody WorkOrderDto workOrderDto) {
////        logger.info("getSpcWorkOrderById - 根据工单Id查询工单信息. workOrderQueryDto={}", workOrderDto);
////        ///LoginAuthDto loginAuthDto = getLoginAuthDto();
////        spcWorkOrderService.transferWorkOrder(workOrderDto);
////        return WrapMapper.ok();
////    }


    //---------------------------审批--------------------------------------------------
    /**
     * 分页查询待审批的全部工单
     * @param workOrderDto
     * @return
     */
    @PostMapping(value = "/getAllUnConfirmedWorkOrders")
    @ApiOperation(httpMethod = "POST",value = "获取全部等待被审批的工单")
    public Wrapper<PageInfo<WorkOrderVo>> getAllUnConfirmedWorkOrders(@ApiParam(name = "WorkOrderDto",value = "工单查询参数")@RequestBody WorkOrderDto workOrderDto){
        logger.info("getAllUnConfirmedWorkOrders - 获取全部等待被审批的工单. workOrderDto={}", workOrderDto);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        PageHelper.startPage(workOrderDto.getPageNum(), workOrderDto.getPageSize());
        workOrderDto.setOrderBy("update_time desc");
        List<WorkOrderVo> workOrderVoVoList = spcWorkOrderService.queryAllWorkOrders(workOrderDto, loginAuthDto);
        workOrderVoVoList.forEach(workOrderVo -> {
            Long taskId = workOrderVo.getId();//工单Id（维修维护or巡检的）
            String type = workOrderVo.getType();//工单类型，巡检(inspection)和维修维护(maintain)
            if("inspection".equals(type)){//如果当前工单类型是巡检工单
                int status = imcTaskFeignApi.getTaskByTaskId(taskId).getResult().getStatus();
                if(status != 4){
                    //如果巡检任务不是处于“巡检结果待确认”的阶段
                    workOrderVoVoList.remove(workOrderVo);//将次任务从列表中移除掉
                }
            }else if("maintain".equals(type)){//如果当前工单类型是维修维护工单
                int status = mdmcTaskFeignApi.getTaskByTaskId(taskId).getResult().getStatus();
                if(status != 8){
                    //如果维修维护任务不是处于“维修工提交维修结果，待服务商审核维修结果”这一状态
                    workOrderVoVoList.remove(workOrderVo);//将此次任务从列表中移除
                }
            }
        });
        return WrapMapper.ok(new PageInfo<>(workOrderVoVoList));
    }
    


}
