package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.UacRoleGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Uac Group-Role mapper.
 *
 * @author Duan Bingyue
 */
@Mapper
@Component
public interface UacRoleGroupMapper extends MyMapper<UacRoleGroup> {


}