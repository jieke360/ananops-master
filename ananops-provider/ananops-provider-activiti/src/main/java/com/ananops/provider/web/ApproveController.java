package com.ananops.provider.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ananops.provider.model.dto.ApproAgreeDto;
import com.ananops.provider.model.dto.ApproDisagreeDto;
import com.ananops.provider.model.dto.ApproSubmitDto;
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
public class  ApproveController {
    @Autowired
    ActivitiServiceImpl activitiServiceImpl;

    @Autowired
    ApproveServiceImpl approveServiceImpl;

    String variableName = "orderid";
    String startUser = "startUser";

    @PostMapping(value = "/submit")
    @ApiOperation(httpMethod = "POST",value = "提交审批")
    public Wrapper<String> submit(@ApiParam(name = "submit",value="提交审批") @RequestBody ApproSubmitDto approSubmitDto) {
        String Uid=String.valueOf(approSubmitDto.getUserid());
        String processDefinitionId=approSubmitDto.getProcessDefinitionId();
        String orderid=approSubmitDto.getOrderId();
        String body=approSubmitDto.getComment();
        String nextUid=String.valueOf(approSubmitDto.getNUserid());
        String taskId=activitiServiceImpl.start(Uid,processDefinitionId);
        activitiServiceImpl.setVariable(taskId, variableName, orderid);
        activitiServiceImpl.comment(taskId, body);
        approveServiceImpl.complete(taskId, nextUid);
        return WrapMapper.ok("success");
    }

    @PostMapping(value = "/agree")
    @ApiOperation(httpMethod = "POST",value = "审批通过")
    public Wrapper<String> agree(@ApiParam(name = "agree",value="审批通过") @RequestBody ApproAgreeDto approAgreeDto) {
        try {
            String taskId=approAgreeDto.getTaskId();
            String Uid=String.valueOf(approAgreeDto.getUserid());
            String body=approAgreeDto.getComment();
            Long orderid = Long.valueOf(activitiServiceImpl.getVariable(taskId, variableName).toString());
            Task task = activitiServiceImpl.getTask(taskId);
            String processInstanceId = task.getProcessInstanceId();
            activitiServiceImpl.comment(taskId, body);
            approveServiceImpl.aprrove(taskId, Uid);
        /*    ProcessInstance processInstance = activitiServiceImpl.getProIns(processInstanceId);
            if (processInstance == null) {
                JSONObject approve = JSON.parseObject(HttpUtil.getApprove(orderid));
                approve.replace("status", approve.get("status"), 1);
                HttpUtil.updateOrderStatus(HttpUtil.stringToRequestBody(approve.toString()));
                //下一步调维修工单服务商分配接口
            }*/
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    @PostMapping(value = "/disagree")
    @ApiOperation(httpMethod = "POST",value = "审批不通过")
    public Wrapper<String> disagree(@ApiParam(name = "disagree",value = "审批不通过") @RequestBody ApproDisagreeDto approDisagreeDto) {
        try {
            String body=approDisagreeDto.getComment();
            String taskId=approDisagreeDto.getTaskId();
            Long orderid = Long.valueOf(activitiServiceImpl.getVariable(taskId, variableName).toString());
            activitiServiceImpl.comment(taskId, body);
            approveServiceImpl.disapprove(taskId);
           /* JSONObject approve = JSON.parseObject(HttpUtil.getApprove(orderid));
            approve.replace("status", approve.get("status"), 2);
            HttpUtil.updateOrderStatus(HttpUtil.stringToRequestBody(approve.toString()));*/
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    @GetMapping(value = "/untask/{userid}")
    @ApiOperation(httpMethod = "GET",value = "获取未完成审批列表")
    public Wrapper<String> getUndoTask(@ApiParam(name = "userid",value = "当前用户id") @RequestParam Long userid) {
        JSONObject jsonObject = new JSONObject();
        List<Task> list = activitiServiceImpl.searchByAssi(String.valueOf(userid));
        if (list != null && list.size() != 0) {
            int count = 1;
            for (Task task : list) {
                if (activitiServiceImpl.getVariable(task.getId(), variableName) != null) {
                    Object orderid = activitiServiceImpl.getVariable(task.getId(), variableName);
                    Object startUid=activitiServiceImpl.getVariable(task.getId(),startUser);
                    String head = String.valueOf(count++);
                    ProcessInstance processInstance = activitiServiceImpl.getProIns(task.getProcessInstanceId());
                    List<Object> details = new ArrayList<>();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    details.add("taskId:"+task.getId());
                    details.add("startUser:"+startUid);
                    details.add("processName:"+processInstance.getProcessDefinitionKey());
                    details.add("processsInstanceId:"+processInstance.getId());
                    details.add("taskName:"+task.getName());
                    details.add("createTime:"+formatter.format(task.getCreateTime()));
                    details.add("orderId:"+orderid);
                    jsonObject.put(head, details);
                }
            }
        }
        return WrapMapper.ok(jsonObject.toString());
    }

    @GetMapping(value = "/tasked/{userid}")
    @ApiOperation(httpMethod = "GET",value = "获取已完成审批列表")
    public Wrapper<String> getTasked(@ApiParam(name = "userid",value = "当前用户id") @RequestParam Long userid) {
        JSONObject jsonObject = new JSONObject();
        List<HistoricTaskInstance> list = activitiServiceImpl.getHistoryList(String.valueOf(userid));
        if (list != null && list.size() != 0) {
            int count = 1;
            for (HistoricTaskInstance task : list) {
                Object orderid=activitiServiceImpl.getHistoricVariable(task.getProcessInstanceId(),variableName);
                if(orderid!=null) {
                    Object startUid = activitiServiceImpl.getHistoricVariable(task.getProcessInstanceId(), startUser);
                    if (orderid != null) {
                        String head = String.valueOf(count++);
                        HistoricProcessInstance historicProcessInstance = activitiServiceImpl.getProHisIns(task.getProcessInstanceId());
                        List<Object> details = new ArrayList<>();
                        details.add("taskId:" + task.getId());
                        details.add("startUser:" + startUid);
                        details.add("processName:" + historicProcessInstance.getProcessDefinitionKey());
                        details.add("processInstanceId:" + historicProcessInstance.getId());
                        details.add("taskName:" + task.getName());
                        details.add("taskCreateTime:" + task.getCreateTime());
                        details.add("taskEndTime:" + task.getEndTime());
                        details.add("orderid:" + orderid);
                        jsonObject.put(head, details);
                    }
                }
            }
        }
        return WrapMapper.ok(jsonObject.toString());
    }

}
