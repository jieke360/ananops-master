package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.MdmcTaskItemLogMapper;
import com.ananops.provider.mapper.MdmcTaskItemMapper;
import com.ananops.provider.mapper.MdmcTaskMapper;
import com.ananops.provider.model.domain.MdmcTask;
import com.ananops.provider.model.domain.MdmcTaskItem;
import com.ananops.provider.model.dto.MdmcAddTaskItemDto;

import com.ananops.provider.service.MdmcTaskItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class MdmcTaskItemServiceImpl extends BaseService<MdmcTaskItem> implements MdmcTaskItemService {
    @Resource
    MdmcTaskItemMapper mdmcTaskItemMapper;

    @Resource
    MdmcTaskMapper mdmcTaskMapper;

    @Resource
    MdmcTaskItemLogMapper mdmcTaskItemLogMapper;



    @Override
    public List<MdmcTaskItem> getItemByTaskId(Long task_id) {

        Example example1 = new Example(MdmcTask.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("id",task_id);
        if(mdmcTaskMapper.selectCountByExample(example1)==0){
            //如果查询的任务不存在
            throw new BusinessException(ErrorCodeEnum.GL9999098,task_id);
        }
        Example example2 = new Example(MdmcTaskItem.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("taskId",task_id);
        List<MdmcTaskItem> taskItemList = mdmcTaskItemMapper.selectByExample(example2);
        return taskItemList;
    }

    @Override
    public List<MdmcTaskItem> getItemByItemStatusAndTaskId(Long taskId, Integer status) {
        Example example = new Example(MdmcTaskItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskId",taskId);
        if(mdmcTaskItemMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999098);
        }
        criteria.andEqualTo("status",status);
        if(mdmcTaskItemMapper.selectCountByExample(example)==0){
            throw new BusinessException(ErrorCodeEnum.GL9999094);
        }
        return mdmcTaskItemMapper.selectByExample(example);
    }

    @Override
    public MdmcTaskItem saveItem(MdmcAddTaskItemDto mdmcAddTaskItemDto, LoginAuthDto loginAuthDto) {
        MdmcTaskItem taskItem=new MdmcTaskItem();
        BeanUtils.copyProperties(mdmcAddTaskItemDto,taskItem);
        taskItem.setUpdateInfo(loginAuthDto);
        Long taskId = taskItem.getTaskId();
        Example example = new Example(MdmcTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",taskId);
        List<MdmcTask> taskList =mdmcTaskMapper.selectByExample(example);
        if(taskList.size()==0){//如果没有此任务
            throw new BusinessException(ErrorCodeEnum.GL9999098,taskId);
        }
        if(taskItem.isNew()){//如果是新增一条任务子项记录
            Long itemId = super.generateId();
            taskItem.setId(itemId);
            mdmcTaskItemMapper.insert(taskItem);
        }else{//如果是更新已经存在的任务子项
            mdmcTaskItemMapper.updateByPrimaryKeySelective(taskItem);
        }
        return taskItem;
    }





}
