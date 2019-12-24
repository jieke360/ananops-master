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
}