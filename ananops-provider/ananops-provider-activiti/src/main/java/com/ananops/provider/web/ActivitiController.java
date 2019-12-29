package com.ananops.provider.web;

/**
 * Created by hzq
 * on 2019/11/25
 */

import com.alibaba.fastjson.JSONObject;
import com.ananops.provider.service.impl.ActivitiServiceImpl;
import com.ananops.provider.utils.WrapMapper;
import com.ananops.provider.utils.Wrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/activiti")
@CrossOrigin
public class ActivitiController {
    @Autowired
    ActivitiServiceImpl activitiServiceImpl;

    //发布流程
    @GetMapping(value = "/deploy")
    @ApiOperation(httpMethod = "POST",value = "部署流程")
    public Wrapper<String> deploy(@ApiParam(name = "name",value = "流程名称") String name,
                                  @ApiParam(name = "bpmnpath",value = "bpmn路径") String bpmnpath,
                                  @ApiParam(name = "pngpath",value = "png路径") String pngpath) throws Exception {
        try {
            activitiServiceImpl.deploy(name, bpmnpath, pngpath);
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    //启动流程
    @GetMapping(value = "/start")
    @ApiOperation(httpMethod = "POST",value = "启动流程")
    public Wrapper<String> start(@ApiParam(name ="Uid",value = "当前用户id") Long Uid,
                                 @ApiParam(name = "processDefinitionId",value="流程定义id") String processDefinitionId) {
        try {
            activitiServiceImpl.start(String.valueOf(Uid), processDefinitionId);
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

/*    @RequestMapping(value = "/approve",method = RequestMethod.POST)
            public String approved(@RequestParam("Uid") String Uid,
                    @RequestParam("taskId") String taskId,
                    @RequestParam(value = "variable",required = false) String variable,
                    @RequestBody String body){
                try {
                    activitiServiceImpl.comment(taskId, body);
                    activitiServiceImpl.aprrove(taskId, Uid, variable);
                }catch (ActivitiObjectNotFoundException e){
                    return "该任务不存在";
        }
        return "审批完成";
    }

    @RequestMapping(value = "/disapprove",method = RequestMethod.POST)
    public String disapprove(@RequestParam("taskId") String taskId,
                             @RequestBody String body){
        try{
            activitiServiceImpl.comment(taskId,body);
            activitiServiceImpl.disapprove(taskId);
        }catch (ActivitiObjectNotFoundException e){
            return "该任务不存在";
        }
        return "审批不通过";
    }*/

/*    @RequestMapping(value = "/complete1",method = RequestMethod.POST)
    public void complete1(@RequestParam("Uid") String Uid,
                            @RequestParam("TaskId") String TaskId,
                            @RequestParam("agreement") String agreement){
      activitiServiceImpl.complete(TaskId,Uid,agreement);
    }*/

/*    //完成任务（推进）
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public String complete(@RequestParam("Uid") String Uid,
                           @RequestParam("TaskId") String TaskId,
                           @RequestParam("agreement") Boolean agreement,
                           @RequestParam(value = "variable",required = false,defaultValue = "") String variable,
                           @RequestBody String body){
        try {
            activitiServiceImpl.comment(TaskId, body);
            activitiServiceImpl.completeByVar(TaskId,Uid,variable,agreement);
        }catch (Exception e){
            return "失败！";
        }
         return "成功";
    }*/


    //获取批注
    @GetMapping(value = "/getComment")
    @ApiOperation(httpMethod = "GET",value = "获取批注")
    public Wrapper<String> comment(@ApiParam(name = "taskId",value = "任务id") String taskId) {
        JSONObject jsonObject = new JSONObject();
        List<Comment> list = activitiServiceImpl.getComment(taskId);
        if (list != null && list.size() > 0) {
            for (Comment comment : list) {
                String assignee = activitiServiceImpl.getAssignee(comment.getTaskId());
                jsonObject.put("批注人" + assignee, comment.getFullMessage());
            }
        }
        return WrapMapper.ok(jsonObject.toString());
    }

    //获取部署流程列表
    @GetMapping(value = "/deploylist")
    @ApiOperation(httpMethod = "GET",value = "获取部署流程列表")
    public Wrapper<String> personalTask() {
        try {
            List<ProcessDefinition> list = activitiServiceImpl.getDefinitionList();
            JSONObject jsonObject = new JSONObject();
            if (list != null && list.size() > 0) {
                int count = 1;
                for (ProcessDefinition processDefinition : list) {
                    String head = String.valueOf(count++);
                    List<String> content = new ArrayList<>();
                    content.add(processDefinition.getId());
                    content.add(processDefinition.getKey());
                    content.add(String.valueOf(processDefinition.getVersion()));
                    jsonObject.put(head, content);
                }
            }
            return WrapMapper.ok(jsonObject.toString());
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
    }

    //获取流程图
    @GetMapping(value = "/image")
    @ApiOperation(httpMethod = "GET",value = "获取流程图")
    public Wrapper<String> getImage(@ApiParam(name = "processDefinitionId",value="流程定义id") String processDefinitionId) throws Exception {
        String path = null;
        try {
            ProcessDefinition processDefinition = activitiServiceImpl.getProDef(processDefinitionId);
            path = activitiServiceImpl.getResource(processDefinition.getDeploymentId()
                    , processDefinition.getKey()
                    , processDefinition.getVersion());
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok(path);
    }

    //普通删除流程定义表（根据部署ID）
    @GetMapping(value = "/delete")
    @ApiOperation(httpMethod = "DELETE",value = "一般删除流程定义表（根据部署ID）")
    public Wrapper<String> deleteDefinitionList(@ApiParam(name = "processDefinitionId",value="流程定义id") String processDefinitionId) {
        try {
            ProcessDefinition processDefinition = activitiServiceImpl.getProDef(processDefinitionId);
            activitiServiceImpl.deleteDefinitionList(processDefinition.getDeploymentId());
        }  catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }

    //级联删除（强行删除）流程定义表
    @GetMapping(value = "/fdelete")
    @ApiOperation(httpMethod = "DELETE",value = "级联删除（强行删除）流程定义表")
    public Wrapper<String> deleteAnyWay(@ApiParam(name = "processDefinitionId",value="流程定义id") String processDefinitionId) {
        try {
            ProcessDefinition processDefinition = activitiServiceImpl.getProDef(processDefinitionId);
            activitiServiceImpl.deleteDefAnyWay(processDefinition.getDeploymentId());
        } catch (Exception e) {
            return WrapMapper.error(e.getMessage());
        }
        return WrapMapper.ok("success");
    }
}
