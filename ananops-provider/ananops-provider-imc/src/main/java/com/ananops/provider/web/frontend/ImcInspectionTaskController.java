package com.ananops.provider.web.frontend;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.core.annotation.AnanLogAnnotation;
import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.model.dto.ImcAddInspectionTaskDto;
import com.ananops.provider.model.dto.ImcTaskChangeStatusDto;
import com.ananops.provider.model.dto.TaskLogQueryDto;
import com.ananops.provider.model.dto.TaskNameChangeDto;
import com.ananops.provider.model.vo.TaskLogVo;
import com.ananops.provider.service.ImcInspectionTaskLogService;
import com.ananops.provider.service.ImcInspectionTaskService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
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
    public Wrapper<ImcInspectionTask> getTaskByTaskId(@PathVariable Long taskId){
        ImcInspectionTask imcInspectionTask = imcInspectionTaskService.getTaskByTaskId(taskId);
        return WrapMapper.ok(imcInspectionTask);
    }

    @PostMapping(value = "/modifyTaskStatusByTaskId/{taskId}")
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

    @GetMapping(value = "/getTaskByStatus/{status}")
    @ApiOperation(httpMethod = "GET",value = "根据巡检任务的状态查询对应的任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByStatus(@PathVariable Integer status){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByStatus(status));
    }

    @PostMapping(value = "/modifyTaskName")
    @ApiOperation(httpMethod = "POST",value = "修改巡检任务的名字")
    @AnanLogAnnotation
    public Wrapper<TaskNameChangeDto> modifyTaskName(@ApiParam(name = "modifyTaskName",value = "修改巡检任务的名字")@RequestBody TaskNameChangeDto taskNameChangeDto){
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        imcInspectionTaskService.modifyTaskName(taskNameChangeDto,loginAuthDto);
        return WrapMapper.ok(taskNameChangeDto);
    }

    @GetMapping(value = "/getTaskByProjectId/{projectId}")
    @ApiOperation(httpMethod = "GET",value = "根据项目查询对应的所有巡检任务")
    public Wrapper<List<ImcInspectionTask>> getTaskByProjectId(@PathVariable Long projectId){
        return WrapMapper.ok(imcInspectionTaskService.getTaskByProjectId(projectId));
    }
}
