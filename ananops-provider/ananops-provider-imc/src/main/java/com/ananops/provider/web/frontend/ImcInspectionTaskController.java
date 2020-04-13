package com.ananops.provider.web.frontend;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.core.annotation.AnanLogAnnotation;
import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.model.dto.*;
import com.ananops.provider.model.dto.oss.ElementImgUrlDto;
import com.ananops.provider.model.dto.oss.OptUploadFileRespDto;
import com.ananops.provider.model.vo.TaskLogVo;
import com.ananops.provider.service.ImcInspectionTaskLogService;
import com.ananops.provider.service.ImcInspectionTaskService;
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
 * Created by rongshuai on 2019/11/27 19:28
 */
@RestController
@RequestMapping(value = "/inspectionTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - ImcInspectionTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ImcInspectionTaskController extends BaseController {
    @Resource
    ImcInspectionTaskService imcInspectionTaskService;

    @Resource
    ImcInspectionTaskLogService imcInspectionTaskLogService;

    @PostMapping(value = "/save")
    @ApiOperation(httpMethod = "POST",value = "编辑巡检任务记录")
    @AnanLogAnnotation
    public Wrapper<ImcAddInspectionTaskDto> saveInspectionTask(@ApiParam(name = "saveInspectionTask",value = "编辑巡检任务记录")@RequestBody ImcAddInspectionTaskDto imcAddInspectionTaskDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return WrapMapper.ok(imcInspectionTaskService.saveTask(imcAddInspectionTaskDto,loginAuthDto));
    }

    @GetMapping(value = "/getTaskByTaskId/{taskId}")
    @ApiOperation(httpMethod = "GET",value = "根据任务的ID，获取当前的任务详情")
    public Wrapper<ImcInspectionTaskDto> getTaskDtoByTaskId(@PathVariable Long taskId){
        ImcInspectionTaskDto imcInspectionTaskDto = imcInspectionTaskService.getTaskDtoByTaskId(taskId);
        return WrapMapper.ok(imcInspectionTaskDto);
    }

    @PostMapping(value = "/modifyTaskStatusByTaskId")
    @ApiOperation(httpMethod = "POST",value = "更改巡检任务的状态")
    @AnanLogAnnotation
    public Wrapper<ImcTaskChangeStatusDto> modifyTaskStatusByTaskId(@ApiParam(name = "modifyTaskStatus",value = "根据巡检任务的ID修改巡检任务的状态")@RequestBody ImcTaskChangeStatusDto imcTaskChangeStatusDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        imcInspectionTaskService.modifyTaskStatus(imcTaskChangeStatusDto,loginAuthDto);
        return WrapMapper.ok(imcTaskChangeStatusDto);
    }

    @PostMapping(value = "/getTaskLogs")
    @ApiOperation(httpMethod = "POST",value = "根据巡检任务ID查询任务的日志")
    public Wrapper<List<TaskLogVo>> getTaskLogs(@ApiParam(name = "getTaskLogsByTaskId",value = "根据巡检任务ID查询任务的日志")@RequestBody TaskLogQueryDto taskLogQueryDto){
        return WrapMapper.ok(imcInspectionTaskLogService.getTaskLogsByTaskId(taskLogQueryDto));
    }

    @PostMapping(value = "/getTaskByStatus")
    @ApiOperation(httpMethod = "POST",value = "根据巡检任务的状态查询对应的任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByStatus(@ApiParam(name = "getTaskByStatus",value = "根据巡检任务的状态查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByStatus(taskQueryDto));
    }

    @PostMapping(value = "/getTaskListByStatus")
    @ApiOperation(httpMethod = "POST",value = "根据巡检任务的状态查询对应的任务（可返回总数total）")
    public Wrapper<PageInfo> getTaskListByStatus(@ApiParam(name = "getTaskByStatus",value = "根据巡检任务的状态查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByStatusAndPage(taskQueryDto));
    }

    @PostMapping(value = "/modifyTaskName")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务的名字")
    @AnanLogAnnotation
    public Wrapper<TaskNameChangeDto> modifyTaskName(@ApiParam(name = "modifyTaskName",value = "修改巡检任务的名字")@RequestBody TaskNameChangeDto taskNameChangeDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        imcInspectionTaskService.modifyTaskName(taskNameChangeDto,loginAuthDto);
        return WrapMapper.ok(taskNameChangeDto);
    }

    @PostMapping(value = "/getTaskByProjectId")
    @ApiOperation(httpMethod = "POST",value = "根据项目查询对应的所有巡检任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByProjectId(@ApiParam(name = "getTaskByProjectId",value = "根据项目ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByProjectId(taskQueryDto));
    }

    @PostMapping(value = "/getTaskListByProjectId")
    @ApiOperation(httpMethod = "POST",value = "根据项目查询对应的所有巡检任务（可返回总数total）")
    public Wrapper<PageInfo> getTaskListByProjectId(@ApiParam(name = "getTaskByProjectId",value = "根据项目ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByProjectIdAndPage(taskQueryDto));
    }

    @PostMapping(value = "/getTaskByUserId")
    @ApiOperation(httpMethod = "POST",value = "根据用户（1：甲方负责人，2：服务商）的id查询对应的巡检任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByUserId(@ApiParam(name = "getTaskByUserId",value = "根据用户（1：甲方负责人，2：服务商）的ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByUserId(taskQueryDto));
    }

    @PostMapping(value = "/getTaskListByUserId")
    @ApiOperation(httpMethod = "POST",value = "根据用户（1：甲方负责人，2：服务商）的id查询对应的巡检任务（可返回总数total）")
    public Wrapper<PageInfo> getTaskListByUserId(@ApiParam(name = "getTaskByUserId",value = "根据用户（1：甲方负责人，2：服务商）的ID查询巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByUserIdAndPage(taskQueryDto));
    }

    @PostMapping(value = "/getTaskByUserIdAndStatus")
    @ApiOperation(httpMethod = "POST",value = "根据用户（1：甲方负责人，2：服务商）id查询指定状态的巡检任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByUserIdAndStatus(@ApiParam(name = "getTaskByUserIdAndStatus",value = "根据用户（1：甲方负责人，2：服务商）id查询指定状态的巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByUserIdAndStatus(taskQueryDto));
    }

    @PostMapping(value = "/getTaskListByUserIdAndStatus")
    @ApiOperation(httpMethod = "POST",value = "根据用户（1：甲方负责人，2：服务商）id查询指定状态的巡检任务（可返回总数total）")
    public Wrapper<PageInfo> getTaskListByUserIdAndStatus(@ApiParam(name = "getTaskByUserIdAndStatus",value = "根据用户（1：甲方负责人，2：服务商）id查询指定状态的巡检任务")@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByUserIdAndStatusAndPage(taskQueryDto));
    }

    @PostMapping(value = "/modifyFacilitatorIdByTaskId")
    @ApiOperation(httpMethod = "POST",value = "根据巡检任务的ID修改对应任务的服务商ID")
    public Wrapper<TaskChangeFacilitatorDto> modifyFacilitatorIdByTaskId(@ApiParam(name = "modifyFacilitatorByTaskId",value = "根据巡检任务的ID修改对应任务的服务商ID")@RequestBody TaskChangeFacilitatorDto taskChangeFacilitatorDto){
        return WrapMapper.ok(imcInspectionTaskService.modifyFacilitator(taskChangeFacilitatorDto));
    }

    @PostMapping(value = "/refuseTaskByFacilitator")
    @ApiOperation(httpMethod = "POST",value = "服务商拒单")
    @AnanLogAnnotation
    public Wrapper<ImcTaskChangeStatusDto> refuseTaskByFacilitator(@RequestBody ConfirmImcTaskDto refuseImcTaskDto){
        refuseImcTaskDto.setLoginAuthDto(getLoginAuthDto());
        return WrapMapper.ok(imcInspectionTaskService.refuseImcTaskByFacilitator(refuseImcTaskDto));
    }

    @PostMapping(value = "/acceptTaskByFacilitator")
    @ApiOperation(httpMethod = "POST",value = "服务商接单")
    @AnanLogAnnotation
    public Wrapper<ImcTaskChangeStatusDto> acceptTaskByFacilitator(@RequestBody ConfirmImcTaskDto acceptImcTaskDto){
        acceptImcTaskDto.setLoginAuthDto(getLoginAuthDto());
        return WrapMapper.ok(imcInspectionTaskService.acceptImcTaskByFacilitator(acceptImcTaskDto));
    }


    @PostMapping(value = "/deleteTaskByTaskId/{taskId}")
    @ApiOperation(httpMethod = "POST",value = "删除指定的巡检任务")
    public Wrapper deleteTaskByTaskId(@PathVariable Long taskId){
        imcInspectionTaskService.deleteTaskById(taskId);
        return WrapMapper.ok();
    }

    @PostMapping(value = "/getAllUnauthorizedTask")
    @ApiOperation(httpMethod = "POST",value = "查询当前甲方负责人下面的全部未授权的任务")
    public Wrapper<List<ImcInspectionTask>> getAllUnauthorizedTask(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllUnauthorizedTaskByPrincipalId(taskQueryDto));
    }

    @PostMapping(value = "/getAllUnauthorizedTaskList")
    @ApiOperation(httpMethod = "POST",value = "查询当前甲方负责人下面的全部未授权的任务（可返回总数total）")
    public Wrapper<PageInfo> getAllUnauthorizedTaskList(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllUnauthorizedTaskByPrincipalIdAndPage(taskQueryDto));
    }

    @PostMapping(value = "/getAllDeniedTask")
    @ApiOperation(httpMethod = "POST",value = "查询当前甲方负责人下面的全部未授权的任务")
    public Wrapper<List<ImcInspectionTask>> getAllDeniedTask(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllDeniedTaskByPrincipalId(taskQueryDto));
    }

    @PostMapping(value = "/getAllDeniedTaskList")
    @ApiOperation(httpMethod = "POST",value = "查询当前甲方负责人下面的全部未授权的任务（可返回总数total）")
    public Wrapper<PageInfo> getAllDeniedTaskList(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllDeniedTaskByPrincipalIdAndPage(taskQueryDto));
    }

    @PostMapping(value = "/acceptImcTaskByPrincipal")
    @ApiOperation(httpMethod = "POST",value = "同意执行巡检任务")
    @AnanLogAnnotation
    public Wrapper<ImcTaskChangeStatusDto> acceptImcTaskByPrincipal(@RequestBody ImcTaskChangeStatusDto imcTaskChangeStatusDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        imcTaskChangeStatusDto.setLoginAuthDto(loginAuthDto);
        return WrapMapper.ok(imcInspectionTaskService.acceptImcTaskByPrincipal(imcTaskChangeStatusDto));
    }

    @PostMapping(value = "/denyImcTaskByPrincipal")
    @ApiOperation(httpMethod = "POST",value = "否决执行巡检任务")
    @AnanLogAnnotation
    public Wrapper<ImcTaskChangeStatusDto> denyImcTask(@RequestBody ImcTaskChangeStatusDto imcTaskChangeStatusDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        imcTaskChangeStatusDto.setLoginAuthDto(loginAuthDto);
        return WrapMapper.ok(imcInspectionTaskService.denyImcTaskByPrincipal(imcTaskChangeStatusDto));
    }

    @PostMapping(value = "/getImcTaskNumberByUserIdAndRole")
    @ApiOperation(httpMethod = "POST",value = "根据用户id和用户角色获取全部的巡检任务数目(1->甲方负责人   2->服务商)")
    public Wrapper<Integer> getImcTaskNumberByUserIdAndRole(@RequestBody TaskQueryDto taskQueryDto){
        logger.info("根据用户id和用户角色获取全部的巡检任务数目，taskQueryDto={}",taskQueryDto);
        return WrapMapper.ok(imcInspectionTaskService.getImcTaskNumberByUserIdAndRole(taskQueryDto));
    }

    @GetMapping(value = "/getItemNumberByTaskId/{taskId}")
    @ApiOperation(httpMethod = "GET",value = "根据任务的ID，获取当前任务下的子项数")
    public Wrapper<Integer> getItemNumberByTaskId(@PathVariable Long taskId){
        return WrapMapper.ok(imcInspectionTaskService.getItemNumberByTaskId(taskId));
    }

    @GetMapping(value = "/getUndistributeTaskList")
    @ApiOperation(httpMethod = "GET",value = "获取全部未分配工程师，且还剩10天截止的巡检任务")
    public Wrapper<List<UndistributedImcTaskDto>> getUndistributeTaskList(){
        return WrapMapper.ok(imcInspectionTaskService.queryAllUndistributedTask());
    }

    @GetMapping(value = "/getImcTaskReport/{taskId}")
    @ApiOperation(httpMethod = "GET",value = "获取巡检任务报告")
    public Wrapper<List<ElementImgUrlDto>> getImcTaskReport(@PathVariable Long taskId){
        return WrapMapper.ok(imcInspectionTaskService.getReportUrlList(taskId,getLoginAuthDto()));
    }

    @PostMapping(value = "/getAllUnDistributedTask")
    @ApiOperation(httpMethod = "POST",value = "获取全部当前服务商未分配工程师的巡检任务")
    public Wrapper<PageInfo> getAllUnDistributedTask(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllUnDistributedTask(getLoginAuthDto(),taskQueryDto));
    }

    @PostMapping(value = "/getAllUnConfirmedTask")
    @ApiOperation(httpMethod = "POST",value = "获取全部当前服务商未接单的巡检任务")
    public Wrapper<PageInfo> getAllUnConfirmedTask(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllUnConfirmedTask(getLoginAuthDto(),taskQueryDto));
    }

    @PostMapping(value = "/getAllFinishedTaskByFacilitatorId")
    @ApiOperation(httpMethod = "POST",value = "获取全部当前服务商已完成的巡检任务")
    public Wrapper<PageInfo> getAllFinishedTaskByFacilitatorId(@RequestBody TaskQueryDto taskQueryDto){
        return WrapMapper.ok(imcInspectionTaskService.getAllFinishedTaskByFacilitatorIdAndPage(getLoginAuthDto(),taskQueryDto));
    }
}
