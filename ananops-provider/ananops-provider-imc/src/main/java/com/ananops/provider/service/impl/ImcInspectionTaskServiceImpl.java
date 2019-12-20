package com.ananops.provider.service.impl;


import com.alibaba.fastjson.JSON;
import com.ananops.RedisKeyUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.manager.ImcTaskManager;
import com.ananops.provider.mapper.ImcInspectionTaskMapper;
import com.ananops.provider.model.domain.ImcInspectionTask;
import com.ananops.provider.model.domain.MqMessageData;
import com.ananops.provider.model.dto.ImcAddInspectionItemDto;
import com.ananops.provider.model.dto.ImcAddInspectionTaskDto;
import com.ananops.provider.model.dto.ImcTaskChangeStatusDto;
import com.ananops.provider.model.dto.TaskNameChangeDto;
import com.ananops.provider.model.enums.ItemStatusEnum;
import com.ananops.provider.model.enums.TaskStatusEnum;
import com.ananops.provider.service.ImcInspectionItemService;
import com.ananops.provider.service.ImcInspectionTaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rongshuai on 2019/11/27 19:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ImcInspectionTaskServiceImpl extends BaseService<ImcInspectionTask> implements ImcInspectionTaskService {
    @Resource
    ImcInspectionTaskMapper imcInspectionTaskMapper;

    @Resource
    ImcTaskManager imcTaskManager;

    @Resource
    ImcInspectionItemService imcInspectionItemService;



    /**
     * 插入一条巡检任务记录
     * @param imcAddInspectionTaskDto
     * @return
     */
    public ImcAddInspectionTaskDto saveTask(ImcAddInspectionTaskDto imcAddInspectionTaskDto, LoginAuthDto loginAuthDto){
        ImcInspectionTask imcInspectionTask = new ImcInspectionTask();
        BeanUtils.copyProperties(imcAddInspectionTaskDto,imcInspectionTask);
        imcInspectionTask.setUpdateInfo(loginAuthDto);
        MqMessageData mqMessageData;
        String body = JSON.toJSONString(imcAddInspectionTaskDto);
        String topic = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTopic();
        String tag = AliyunMqTopicConstants.MqTagEnum.UPDATE_INSPECTION_TASK.getTag();
        if(imcInspectionTask.isNew()){
            //如果当前是新建一条任务
            //获取所有的巡检任务子项
            List<ImcAddInspectionItemDto> imcAddInspectionItemDtoList = imcAddInspectionTaskDto.getImcAddInspectionItemDtoList();
            Long taskId = super.generateId();
            imcInspectionTask.setId(taskId);
            //将巡检任务状态设置为等待服务商接单
            imcInspectionTask.setStatus(TaskStatusEnum.WAITING_FOR_FACILITATOR.getStatusNum());
            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(taskId),body);
            mqMessageData = new MqMessageData(body, topic, tag, key);
            imcTaskManager.saveInspectionTask(mqMessageData,imcInspectionTask,true);
            logger.info("新创建一条巡检记录：" + imcInspectionTask.toString());
            imcAddInspectionItemDtoList.forEach(item->{//保存所有巡检任务子项
                item.setInspectionTaskId(taskId);//设置巡检任务子项对应的任务id
                item.setDays(imcInspectionTask.getDays());//设置巡检任务子项对应的巡检周期
                item.setFrequency(imcInspectionTask.getFrequency());//设置巡检任务子项对应的巡检频率
                item.setScheduledStartTime(imcInspectionTask.getScheduledStartTime());//设置巡检任务子项的对应的计划开始时间
                Long scheduledStartTime = item.getScheduledStartTime().getTime();//获得巡检任务子项的预计开始时间
                Long currentTime = System.currentTimeMillis();//获得当前时间
                if(scheduledStartTime<=currentTime){//如果计划执行时间<=当前时间，说明，巡检任务需要立即执行
                    //将巡检任务子项的状态设置为等待巡检
                    item.setStatus(ItemStatusEnum.WAITING_FOR_INSPECTION.getStatusNum());
                }
                //创建新的任务子项，并更新返回结果
                BeanUtils.copyProperties(imcInspectionItemService.saveInspectionItem(item,loginAuthDto),item);
            });
            //更新返回结果
            BeanUtils.copyProperties(imcInspectionTask,imcAddInspectionTaskDto);
            BeanUtils.copyProperties(imcAddInspectionItemDtoList,imcAddInspectionTaskDto);
        }else{
            //如果当前是更新一条记录
            String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(imcInspectionTask.getId()),body);
            mqMessageData = new MqMessageData(body, topic, tag, key);
            imcTaskManager.saveInspectionTask(mqMessageData,imcInspectionTask,false);
            //更新返回结果
            BeanUtils.copyProperties(imcInspectionTask,imcAddInspectionTaskDto);
        }
        System.out.println(imcInspectionTask.getTaskName());
        return imcAddInspectionTaskDto;
    }

    /**
     *
     * @param taskId
     * @return
     */
    public ImcInspectionTask getTaskByTaskId(Long taskId){//根据巡检任务的ID，获取巡检任务的详情
        return imcInspectionTaskMapper.selectByPrimaryKey(taskId);
    }


    public ImcInspectionTask modifyTaskStatus(ImcTaskChangeStatusDto imcTaskChangeStatusDto, LoginAuthDto loginAuthDto){
        MqMessageData mqMessageData;
        Long taskId = imcTaskChangeStatusDto.getTaskId();
        Integer status = imcTaskChangeStatusDto.getStatus();
        ImcInspectionTask imcInspectionTask = new ImcInspectionTask();
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        if(imcInspectionTaskMapper.selectCountByExample(example)==0){//如果当前任务不存在
            throw new BusinessException(ErrorCodeEnum.GL9999098,taskId);
        }
        //如果当前任务存在
        imcTaskChangeStatusDto.setStatusMsg(TaskStatusEnum.getStatusMsg(status));
        imcInspectionTask.setId(taskId);
        imcInspectionTask.setStatus(status);
        imcInspectionTask.setUpdateInfo(loginAuthDto);
        String body = JSON.toJSONString(imcTaskChangeStatusDto);
        String topic = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTopic();
        String tag = AliyunMqTopicConstants.MqTagEnum.MODIFY_INSPECTION_TASK_STATUS.getTag();
        String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(imcInspectionTask.getId()),body);
        mqMessageData = new MqMessageData(body, topic, tag, key);
        imcTaskManager.modifyTaskStatus(mqMessageData,imcInspectionTask);
        return imcInspectionTask;
    }

    public List<ImcInspectionTask> getTaskByStatus(Integer status){
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status",status);
        if(imcInspectionTaskMapper.selectCountByExample(example)==0){//当前状态没有对应的任务
            throw new BusinessException(ErrorCodeEnum.GL9999091);
        }
        return imcInspectionTaskMapper.selectByExample(example);
    }

    public ImcInspectionTask modifyTaskName(TaskNameChangeDto taskNameChangeDto,LoginAuthDto loginAuthDto){
        ImcInspectionTask imcInspectionTask = new ImcInspectionTask();
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskNameChangeDto.getTaskId());
        if(imcInspectionTaskMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        imcInspectionTask = imcInspectionTaskMapper.selectByExample(example).get(0);
        imcInspectionTask.setTaskName(taskNameChangeDto.getTaskName());
        imcInspectionTask.setUpdateInfo(loginAuthDto);
        imcInspectionTaskMapper.updateByPrimaryKeySelective(imcInspectionTask);
        return imcInspectionTask;
    }

    public List<ImcInspectionTask> getTaskByProjectId(Long projectId){
        Example example = new Example(ImcInspectionTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("projectId",projectId);
        if(imcInspectionTaskMapper.selectCountByExample(example)==0){//当前状态没有对应的任务
            throw new BusinessException(ErrorCodeEnum.GL9999091);
        }
        return imcInspectionTaskMapper.selectByExample(example);
    }
}
