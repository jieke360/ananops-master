package com.ananops.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.ananops.RedisKeyUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.manager.MdmcTaskManager;
import com.ananops.provider.mapper.*;
import com.ananops.provider.model.domain.*;
import com.ananops.provider.model.dto.*;
import com.ananops.provider.model.enums.*;
import com.ananops.provider.service.MdmcTaskItemService;
import com.ananops.provider.service.MdmcTaskService;
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
    MdmcTaskManager taskManager;

    @Resource
    MdmcTaskItemService taskItemService;


    @Override
    public MdmcTask getTaskByTaskId(Long taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public MdmcAddTaskDto saveTask(MdmcAddTaskDto mdmcAddTaskDto, LoginAuthDto loginAuthDto) {
        MdmcTask task = new MdmcTask();
        BeanUtils.copyProperties(mdmcAddTaskDto,task);
        task.setUpdateInfo(loginAuthDto);
        MqMessageData mqMessageData;
        String body = JSON.toJSONString(mdmcAddTaskDto);
        String topic = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTopic();
        String tag = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTag();
        if(task.isNew()){
            //如果当前是新建一条任务
            //获取所有的巡检任务子项
            List<MdmcAddTaskItemDto> mdmcAddTaskItemDtoList = mdmcAddTaskDto.getMdmcAddTaskItemDtoList();
            Long taskId = super.generateId();
            task.setId(taskId);
            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(taskId),body);
            mqMessageData = new MqMessageData(body, topic, tag, key);
            taskManager.saveTask(mqMessageData,task,true);
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
            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(task.getId()),body);
            mqMessageData = new MqMessageData(body, topic, tag, key);
            taskManager.saveTask(mqMessageData,task,false);
            //更新返回结果
            BeanUtils.copyProperties(task,mdmcAddTaskDto);
        }
        System.out.println(task.getTitle());
        return mdmcAddTaskDto;
    }



    @Override
    public MdmcTask modifyTaskStatus(MdmcChangeStatusDto changeStatusDto, LoginAuthDto loginAuthDto) {
        MqMessageData mqMessageData;
        Long taskId = changeStatusDto.getTaskId();
        Integer status = changeStatusDto.getStatus();
        MdmcTask task = new MdmcTask();
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        if(taskMapper.selectCountByExample(example)==0){//如果当前任务不存在
            throw new BusinessException(ErrorCodeEnum.GL9999098,taskId);
        }
        //如果当前任务存在
        changeStatusDto.setStatusMsg(MdmcTaskStatusEnum.getStatusMsg(status));
        task.setId(taskId);
        task.setStatus(status);
        task.setUpdateInfo(loginAuthDto);
        String body = JSON.toJSONString(changeStatusDto);
        String topic = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTopic();
        String tag = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTag();
        String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(task.getId()),body);
        mqMessageData = new MqMessageData(body, topic, tag, key);
        taskManager.modifyTaskStatus(mqMessageData,task);

        MdmcTaskLog taskLog=new MdmcTaskLog();
        taskLog.setTaskId(taskId);
        taskLog.setStatus(status);
        taskLog.setMovement(MdmcTaskStatusEnum.getStatusMsg(status));
        taskLogMapper.insert(taskLog);
        return task;
    }

    @Override
    public List<MdmcTask> getTaskListByUserId(Long userId) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByMaintainerId(Long maintainerId) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("maintainerId",maintainerId);
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByFacilitatorId(Long facilitatorId) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("facilitatorId",facilitatorId);
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<MdmcTask> getTaskListByPrincipalId(Long principalId) {
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("principalId",principalId);
        if(taskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        return taskMapper.selectByExample(example);
    }


}
