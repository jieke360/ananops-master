/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupMapper.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.UacDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Uac group mapper.
 *
 * @author ananops.com@gmail.com
 */
@Mapper
@Component
public interface UacDepartmentMapper extends MyMapper<UacDepartment> {
    List<UacDepartment> selectDepartmentListByUserId(Long userId);
}