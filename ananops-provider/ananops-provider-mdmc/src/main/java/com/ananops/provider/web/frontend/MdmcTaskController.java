package com.ananops.provider.web.frontend;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;

import com.ananops.provider.model.domain.MdmcTask;
import com.ananops.provider.model.domain.MdmcTaskLog;
import com.ananops.provider.model.dto.MdmcAddTaskDto;
import com.ananops.provider.model.dto.MdmcChangeStatusDto;
import com.ananops.provider.service.MdmcTaskLogService;
import com.ananops.provider.service.MdmcTaskService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/mdmcTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MdmcTask",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdmcTaskController extends BaseController {
    @Resource
    MdmcTaskService taskService;

    @Resource
    MdmcTaskLogService taskLogService;

    @PostMapping(value = "/save")
    @ApiOperation(httpMethod = "POST",value = "编辑维修任务记录")

    public Wrapper<MdmcAddTaskDto> saveTask(@ApiParam(name = "saveTask",value = "添加维修任务记录")@RequestBody MdmcAddTaskDto mdmcAddTaskDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        return WrapMapper.ok(taskService.saveTask(mdmcAddTaskDto,loginAuthDto));
    }

    @GetMapping(value = "/getTaskLogs/{taskId}")
    @ApiOperation(httpMethod = "GET",value = "根据任务ID查询任务的日志")
    public Wrapper<List<MdmcTaskLog>> getTaskLogs(@PathVariable Long taskId){
        List<MdmcTaskLog> taskLogList=taskLogService.getTaskLogsByTaskId(taskId);
        return WrapMapper.ok(taskLogList);
    }

    @PostMapping(value = "/modifyTaskStatusByTaskId/{taskId}")
    @ApiOperation(httpMethod = "POST",value = "更改任务的状态")

    public Wrapper<MdmcChangeStatusDto> modifyTaskStatusByTaskId(@ApiParam(name = "modifyTaskStatus",value = "根据任务的ID修改任务的状态")@RequestBody MdmcChangeStatusDto changeStatusDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        taskService.modifyTaskStatus(changeStatusDto,loginAuthDto);
        return WrapMapper.ok(changeStatusDto);
    }

    @GetMapping(value = "/getTaskByTaskId/{taskId}")
    @ApiOperation(httpMethod = "GET",value = "根据任务的ID，获取当前的任务详情")
    public Wrapper<MdmcTask> getTaskByTaskId(@PathVariable Long taskId){
        MdmcTask task = taskService.getTaskByTaskId(taskId);
        return WrapMapper.ok(task);
    }

    @GetMapping(value = "/getTaskListByUserId/{userId}")
    @ApiOperation(httpMethod = "GET",value = "根据用户ID查询工单列表")
    public Wrapper<List<MdmcTask>> getTaskListByUserId(@PathVariable Long userId){
        List<MdmcTask> taskList=taskService.getTaskListByUserId(userId);
        return WrapMapper.ok(taskList);
    }

    @GetMapping(value = "/getTaskListByFacilitatorId/{facilitatorId}")
    @ApiOperation(httpMethod = "GET",value = "根据服务商ID查询工单列表")
    public Wrapper<List<MdmcTask>> getTaskListByFacilitatorId(@PathVariable Long facilitatorId){
        List<MdmcTask> taskList=taskService.getTaskListByFacilitatorId(facilitatorId);
        return WrapMapper.ok(taskList);
    }

    @GetMapping(value = "/getTaskListByPrincipalId/{principalId}")
    @ApiOperation(httpMethod = "GET",value = "根据甲方ID查询工单列表")
    public Wrapper<List<MdmcTask>> getTaskListByPrincipalId(@PathVariable Long principalId){
        List<MdmcTask> taskList=taskService.getTaskListByPrincipalId(principalId);
        return WrapMapper.ok(taskList);
    }
    @GetMapping(value = "/getTaskListByMaintainerId/{maintainerId}")
    @ApiOperation(httpMethod = "GET",value = "根据维修工ID查询工单列表")
    public Wrapper<List<MdmcTask>> getTaskListByMaintainerId(@PathVariable Long maintainerId){
        List<MdmcTask> taskList=taskService.getTaskListByMaintainerId(maintainerId);
        return WrapMapper.ok(taskList);
    }
}
