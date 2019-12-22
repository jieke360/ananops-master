package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.MdmcTaskItem;
import com.ananops.provider.model.dto.MdmcAddTaskItemDto;

import java.util.List;

public interface MdmcTaskItemService extends IService<MdmcTaskItem> {


    List<MdmcTaskItem> getItemByTaskId(Long task_id);

    List<MdmcTaskItem> getItemByItemStatusAndTaskId(Long taskId, Integer status);

    MdmcTaskItem saveItem(MdmcAddTaskItemDto mdmcAddTaskItemDto, LoginAuthDto loginAuthDto);
}
