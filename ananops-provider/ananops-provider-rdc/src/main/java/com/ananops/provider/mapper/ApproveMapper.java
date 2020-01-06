package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.Approve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApproveMapper extends MyMapper<Approve> {
    Approve selectOnProcessingApprove(@Param("approverId") Long approverId, @Param("objectType")Integer objectType, @Param("objectId")Long objectId);
}