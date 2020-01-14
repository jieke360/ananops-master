package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.MdmcReview;
import com.ananops.provider.model.domain.MdmcTask;
import com.ananops.provider.model.domain.MdmcTaskLog;
import com.ananops.provider.model.dto.*;

import java.util.List;


public interface MdmcTaskService extends IService<MdmcTask> {

    /**
     * 根据维修工单ID获取工单详情
     * @param taskId
     * @return
     */
    MdmcTask getTaskByTaskId(Long taskId);

    /**
     * 创建/编辑/处理维修工单
     * @param mdmcAddTaskDto
     * @param loginAuthDto
     * @return
     */
    MdmcAddTaskDto saveTask(MdmcAddTaskDto mdmcAddTaskDto, LoginAuthDto loginAuthDto);

    /**
     * 工程师提交维修信息
     * @param mdmcTaskDto
     * @return
     */
    @Deprecated
    MdmcTaskDto modifyTask(MdmcTaskDto mdmcTaskDto);

    /**
     * 修改维修工单状态
     * @param changeStatusDto
     * @param loginAuthDto
     * @return
     */
    MdmcTask modifyTaskStatus(MdmcChangeStatusDto changeStatusDto, LoginAuthDto loginAuthDto);

    @Deprecated
    Void FacilitatorTransfer();

    @Deprecated
    Void MaintainerTransfer();

    /**
     * 根据状态查询维修工单列表
     * @param statusDto
     * @return
     */
    List<MdmcTask> getTaskListByStatus(MdmcStatusDto statusDto);

    /**
     * 获取所有用户维修工单列表
     * @param statusDto
     * @return
     */
    List<MdmcTask> getTaskList(MdmcStatusDto statusDto);

    /**
     * 根据用户ID、角色和状态获取工单列表
     * @param queryDto
     * @return
     */
    List<MdmcTask> getTaskListByIdAndStatus(MdmcQueryDto queryDto);

    /**
     * 根据用户ID、角色和状态列表（为空则表示所有状态）获取工单列表
     * @param statusArrayDto
     * @return
     */
    List<MdmcListDto> getTaskListByIdAndStatusArrary(MdmcStatusArrayDto statusArrayDto);

    /**
     * 根据用户ID、角色和状态列表（为空则表示所有状态）获取工单列表并分页返回
     * @param queryDto
     * @return
     */
    MdmcPageDto getTaskListByPage(MdmcQueryDto queryDto);

    /**
     * 分配工程师
     * @param mdmcChangeMaintainerDto
     * @return
     */
    MdmcTask modifyMaintainer(MdmcChangeMaintainerDto mdmcChangeMaintainerDto);

    /**
     * 工程师拒单
     * @param refuseMdmcTaskDto
     * @return
     */
    MdmcChangeStatusDto refuseTaskByMaintainer(RefuseMdmcTaskDto refuseMdmcTaskDto);

    /**
     * 服务商拒单
     * @param refuseMdmcTaskDto
     * @return
     */
    MdmcChangeStatusDto refuseTaskByFacilitator(RefuseMdmcTaskDto refuseMdmcTaskDto);

    /**
     * 获取实例中值为空的属性名称
     * @param source
     * @return
     */
    String[] getNullPropertyNames (Object source);

    /**
     * 拷贝Bean数据，并忽略空值
     * @param source
     * @param target
     */
    void copyPropertiesWithIgnoreNullProperties(Object source, Object target);
}
