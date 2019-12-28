package com.ananops.provider.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ananops.provider.service.impl.ActivitiServiceImpl;
import com.ananops.provider.service.impl.ApproveServiceImpl;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq
 * on 2019/12/05
 */

@RestController
@RequestMapping("api/v1/approve")
@CrossOrigin
public class ApproveController {
    @Autowired
    ActivitiServiceImpl activitiServiceImpl;

    @Autowired
    ApproveServiceImpl approveServiceImpl;

    String variableName = "approveId";
    String startUser = "startUser";

    @GetMapping(value = "/submit")
    @ApiOperation(httpMethod = "POST",value = "提交审批")
    public Wrapper<String> submit(@ApiParam(name = "Uid",value = "当前用户id") String Uid,
                                  @ApiParam(name = "nextUid",value="下级审批用户id") String nextUid,
                                  @ApiParam(name = "processDefinitionId",value="流程定义id") String processDefinitionId,
                                  @ApiParam(name = "approveId",value="工单id") Long approveId,
                                  @ApiParam(name = "comment",value="批注") @RequestBody String body) {
        String taskId=activitiServiceImpl.start(Uid,processDefinitionId);
        activitiServiceImpl.setVariable(taskId, variableName, approveId);
        activitiServiceImpl.comment(taskId, body);
        approveServiceImpl.complete(taskId, nextUid);
        return WrapMapper.ok("success");
    }

    @GetMapping(value = "/agree")
    @ApiOperation(httpMethod = "PUT",value = "审批通过")
    public Wrapper<String> agree(@ApiParam(name = "taskId",value = "任务id") String taskId,
                                 @ApiParam(name = "Uid",value = "当前用户id") String Uid,
                                 @ApiParam(name = "comment",value="批注") @RequestBody String body) {
        try {
            Long approveId = Long.valueOf(activitiServiceImpl.getVariable(taskId, variableName).toString());
            Task task = activitiServiceImpl.getTask(taskId);
            String processInstanceId = task.getProcessInstanceId();
            activitiServiceImpl.comment(taskId, body);
            approveServiceImpl.aprrove(taskId, Uid);
        /*    ProcessInstance processInstance = activitiServiceImpl.getProIns(processInstanceId);
            if (processInstance == null) {
                JSONObject approve = JSON.parseObject(HttpUtil.getApprove(approveId));
                approve.replace("status", approve.get("status"), 1);
                HttpUtil.updateOrderStatus(HttpUtil.stringToRequestBody(approve.toString()));
                //下一步调维修工单服务商分配接口
            }*/
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    @GetMapping(value = "/disagree")
    @ApiOperation(httpMethod = "PUT",value = "审批不通过")
    public Wrapper<String> disagree(@ApiParam(name = "taskId",value = "任务id") String taskId) {
        try {
            Long approveId = Long.valueOf(activitiServiceImpl.getVariable(taskId, variableName).toString());
            approveServiceImpl.disapprove(taskId);
           /* JSONObject approve = JSON.parseObject(HttpUtil.getApprove(approveId));
            approve.replace("status", approve.get("status"), 2);
            HttpUtil.updateOrderStatus(HttpUtil.stringToRequestBody(approve.toString()));*/
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    @GetMapping(value = "/untask")
    @ApiOperation(httpMethod = "GET",value = "获取未完成审批列表")
    public Wrapper<String> getUndoTask(@ApiParam(name = "taskId",value = "任务id") String Uid) {
        JSONObject jsonObject = new JSONObject();
        List<Task> list = activitiServiceImpl.searchByAssi(Uid);
        if (list != null && list.size() != 0) {
            int count = 1;
            for (Task task : list) {
                if (activitiServiceImpl.getVariable(task.getId(), variableName) != null) {
                    Object approveId = activitiServiceImpl.getVariable(task.getId(), variableName);
                    Object startUid=activitiServiceImpl.getVariable(task.getId(),startUser);
                    String head = String.valueOf(count++);
                    ProcessInstance processInstance = activitiServiceImpl.getProIns(task.getProcessInstanceId());
                    List<Object> details = new ArrayList<>();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    details.add(task.getId());
                    details.add(startUid);
                    details.add(processInstance.getProcessDefinitionKey());
                    details.add(task.getName());
                    details.add(formatter.format(task.getCreateTime()));
                    details.add(approveId);
                    jsonObject.put(head, details);
                }
            }
        }
        return WrapMapper.ok(jsonObject.toString());
    }

    @GetMapping(value = "/tasked")
    @ApiOperation(httpMethod = "GET",value = "获取已完成审批列表")
    public Wrapper<String> getTasked(@ApiParam(name = "taskId",value = "任务id") String Uid) {
        JSONObject jsonObject = new JSONObject();
        List<HistoricTaskInstance> list = activitiServiceImpl.getHistoryList(Uid);
        if (list != null && list.size() != 0) {
            int count = 1;
            for (HistoricTaskInstance task : list) {
                Object approveId = activitiServiceImpl.getHistoricVariable(task.getProcessInstanceId(), variableName);
                Object startUid=activitiServiceImpl.getHistoricVariable(task.getProcessInstanceId(),startUser);
                if (approveId != null) {
                    String head = String.valueOf(count++);
                    HistoricProcessInstance historicProcessInstance = activitiServiceImpl.getProHisIns(task.getProcessInstanceId());
                    List<Object> details = new ArrayList<>();
                    details.add(task.getId());
                    details.add(startUid);
                    details.add(historicProcessInstance.getProcessDefinitionKey());
                    details.add(task.getName());
                    details.add(task.getCreateTime());
                    details.add(task.getEndTime());
                    details.add(approveId);
                    jsonObject.put(head, details);
                }
            }
        }
        return WrapMapper.ok(jsonObject.toString());
    }

}
