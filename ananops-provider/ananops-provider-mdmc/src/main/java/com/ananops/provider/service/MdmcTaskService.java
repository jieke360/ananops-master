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

    MdmcTaskDto modifyTask(MdmcTaskDto mdmcTaskDto);

    MdmcTask modifyTaskStatus(MdmcChangeStatusDto changeStatusDto, LoginAuthDto loginAuthDto);

    Void FacilitatorTransfer();

    Void MaintainerTransfer();

    List<MdmcTask> getTaskListByStatus(MdmcStatusDto statusDto);

    List<MdmcTask> getTaskList(MdmcStatusDto statusDto);

    List<MdmcTask> getTaskListByIdAndStatus(MdmcQueryDto queryDto);

    List<MdmcListDto> getTaskListByIdAndStatusArrary(MdmcStatusArrayDto statusArrayDto);

    MdmcPageDto getTaskListByPage(MdmcQueryDto queryDto);

    MdmcTask modifyMaintainer(MdmcChangeMaintainerDto mdmcChangeMaintainerDto);

    MdmcChangeStatusDto refuseTaskByMaintainer(RefuseMdmcTaskDto refuseMdmcTaskDto);

    MdmcChangeStatusDto refuseTaskByFacilitator(RefuseMdmcTaskDto refuseMdmcTaskDto);

    String[] getNullPropertyNames (Object source);

    void copyProperties(Object source, Object target);
}
