package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.ImcInspectionTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ImcInspectionTaskMapper extends MyMapper<ImcInspectionTask> {
    List<ImcInspectionTask> queryTaskByUserId(@Param(value = "userId") Long userId);

    List<ImcInspectionTask> queryTaskByUserIdAndStatus(@Param(value = "userId")Long userId,@Param(value = "status")Integer status);

    List<ImcInspectionTask> queryTaskByFacilitatorManagerId(@Param(value = "facilitatorManagerId")Long facilitatorManagerId);

    List<ImcInspectionTask> queryTaskByFacilitatorManagerIdAndStatus(@Param(value = "facilitatorManagerId")Long facilitatorManagerId,@Param(value = "status")Integer status);

    List<ImcInspectionTask> queryTaskByFacilitatorGroupId(@Param(value = "facilitatorGroupId")Long facilitatorGroupId);

    List<ImcInspectionTask> queryTaskByFacilitatorGroupIdAndStatus(@Param(value = "facilitatorGroupId")Long facilitatorGroupId,@Param(value = "status")Integer status);
}