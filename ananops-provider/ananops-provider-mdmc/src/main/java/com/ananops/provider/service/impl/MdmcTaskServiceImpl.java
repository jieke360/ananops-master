package com.ananops.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.ananops.RedisKeyUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;

import com.ananops.provider.mapper.*;
import com.ananops.provider.model.domain.*;
import com.ananops.provider.model.dto.*;
import com.ananops.provider.model.enums.*;
import com.ananops.provider.service.MdmcTaskItemService;
import com.ananops.provider.service.MdmcTaskService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class MdmcTaskServiceImpl extends BaseService<MdmcTask> implements MdmcTaskService {
    @Resource
    MdmcTaskMapper taskMapper;

    @Resource
    MdmcTaskLogMapper taskLogMapper;

    @Resource
    MdmcTaskItemService taskItemService;


    @Override
    public MdmcTask getTaskByTaskId(Long taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public MdmcAddTaskDto saveTask(MdmcAddTaskDto mdmcAddTaskDto,LoginAuthDto loginAuthDto) {
        MdmcTask task = new MdmcTask();
        BeanUtils.copyProperties(mdmcAddTaskDto,task);
        task.setUpdateInfo(loginAuthDto);
//        MqMessageData mqMessageData;
//        String body = JSON.toJSONString(mdmcAddTaskDto);
//        String topic = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTopic();
//        String tag = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTag();
        if(task.isNew()){
            //如果当前是新建一条任务
            //获取所有的巡检任务子项
            List<MdmcAddTaskItemDto> mdmcAddTaskItemDtoList = mdmcAddTaskDto.getMdmcAddTaskItemDtoList();
            Long taskId = super.generateId();
            task.setId(taskId);
//            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(taskId),body);
//            mqMessageData = new MqMessageData(body, topic, tag, key);
//            taskManager.saveTask(mqMessageData,task,true);
            taskMapper.insert(task);
            logger.info("新创建一条维修记录：" + task.toString());
            mdmcAddTaskItemDtoList.forEach(taskItem->{//保存所有任务子项
                taskItem.setTaskId(taskId);//设置任务子项对应的任务id
                //创建新的任务子项，并更新返回结果
                BeanUtils.copyProperties(taskItemService.saveItem(taskItem,loginAuthDto),taskItem);
            });
            //更新返回结果
            BeanUtils.copyProperties(task,mdmcAddTaskDto);
            BeanUtils.copyProperties(mdmcAddTaskItemDtoList,mdmcAddTaskDto);
        }else{
            //如果当前是更新一条记录
//            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(task.getId()),body);
//            mqMessageData = new MqMessageData(body, topic, tag, key);
//            taskManager.saveTask(mqMessageData,task,false);
            task.setStatus(2);
            taskMapper.insert(task);
            //更新返回结果
            BeanUtils.copyProperties(task,mdmcAddTaskDto);
        }
        System.out.println(task.getTitle());
        return mdmcAddTaskDto;
    }



    @Override
    public MdmcTask modifyTaskStatus(MdmcChangeStatusDto changeStatusDto,LoginAuthDto loginAuthDto) {
//        MqMessageData mqMessageData;
        Long taskId = changeStatusDto.getTaskId();
        Integer status = changeStatusDto.getStatus();
        MdmcTask task = new MdmcTask();
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        if(taskMapper.selectCountByExample(example)==0){//如果当前任务不存在
            throw new BusinessException(ErrorCodeEnum.GL9999098,taskId);
        }
        //如果当前任务存在
        changeStatusDto.setStatusMsg(MdmcTaskStatusEnum.getStatusMsg(status));
        if (status==1){taskMapper.deleteByPrimaryKey(taskId);}
        else if (status==14){FacilitatorTransfer();}
        else if (status==15){MaintainerTransfer();}
        task.setId(taskId);
        task.setStatus(status);
        task.setUpdateInfo(loginAuthDto);
//        String body = JSON.toJSONString(changeStatusDto);
//        String topic = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTopic();
//        String tag = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTag();
//        String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(task.getId()),body);
//        mqMessageData = new MqMessageData(body, topic, tag, key);
//        taskManager.modifyTaskStatus(mqMessageData,task);
        taskMapper.updateByPrimaryKey(task);

        MdmcTaskLog taskLog=new MdmcTaskLog();
        Long taskLogId = super.generateId();
        taskLog.setId(taskLogId);
        taskLog.setTaskId(taskId);
        taskLog.setStatus(status);
        taskLog.setMovement(MdmcTaskStatusEnum.getStatusMsg(status));
        taskLogMapper.insert(taskLog);
        return task;
    }

    @Override
    public Void FacilitatorTransfer() {
        return null;
    }

    @Override
    public Void MaintainerTransfer() {
        return null;
    }


    @Override
    public List<MdmcTask> getTaskListByUserId(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",statusDto.getUserId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByMaintainerId(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("maintainerId",statusDto.getMaintainerId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByFacilitatorId(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("facilitatorId",statusDto.getFacilitatorId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByPrincipalId(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("principalId",statusDto.getPrincipalId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByStatus(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status",statusDto.getStatus());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskList(MdmcStatusDto statusDto) {

        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectAll();
    }

    @Override
    public List<MdmcTask> getTaskListByProjectId(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("projectId",statusDto.getProjectId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByUserIdAndStatus(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",statusDto.getUserId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        criteria.andEqualTo("status",statusDto.getStatus());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999094);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByMaintainerIdAndStatus(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("maintainerId",statusDto.getMaintainerId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        criteria.andEqualTo("status",statusDto.getStatus());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999094);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByFacilitatorIdAndStatus(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("facilitatorId",statusDto.getFacilitatorId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        criteria.andEqualTo("status",statusDto.getStatus());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999094);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByPrincipalIdAndStatus(MdmcStatusDto statusDto) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("principalId",statusDto.getPrincipalId());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        criteria.andEqualTo("status",statusDto.getStatus());
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999094);
        }
        PageHelper.startPage(statusDto.getPageNum(),statusDto.getPageSize());
        return taskMapper.selectByExample(example);
    }


}
