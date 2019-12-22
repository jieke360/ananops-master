package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.MdmcReview;
import com.ananops.provider.model.domain.MdmcTask;
import com.ananops.provider.model.domain.MdmcTaskLog;
import com.ananops.provider.model.dto.*;

import java.util.List;


public interface MdmcTaskService extends IService<MdmcTask> {



    MdmcTask getTaskByTaskId(Long taskId);


    MdmcAddTaskDto saveTask(MdmcAddTaskDto mdmcAddTaskDto, LoginAuthDto loginAuthDto);


    MdmcTask modifyTaskStatus(MdmcChangeStatusDto changeStatusDto, LoginAuthDto loginAuthDto);

    List<MdmcTask> getTaskListByUserId(Long userId);

    List<MdmcTask> getTaskListByMaintainerId(Long maintainerId);

    List<MdmcTask> getTaskListByFacilitatorId(Long facilitatorId);

    List<MdmcTask> getTaskListByPrincipalId(Long principalId);
}
