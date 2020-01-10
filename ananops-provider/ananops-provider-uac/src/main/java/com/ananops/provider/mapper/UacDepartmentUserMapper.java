/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupUserMapper.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.domain.UacDepartmentUser;
import com.ananops.provider.model.domain.UacGroup;
import com.ananops.provider.model.domain.UacGroupUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Uac group user mapper.
 *
 * @author ananops.com@gmail.com
 */
@Mapper
@Component
public interface UacDepartmentUserMapper extends MyMapper<UacDepartmentUser> {

	/**
	 * Query by user id uac group user.
	 *
	 * @param userId the user id
	 *
	 * @return the uac group user
	 */
	UacDepartmentUser getByUserId(Long userId);

	/**
	 * Update by user id int.
	 *
	 * @param uacDepartmentUser the uac group user
	 *
	 * @return the int
	 */
	int updateByUserId(UacDepartmentUser uacDepartmentUser);

	/**
	 * Select group list by user id list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<UacDepartment> selectDepartmentListByUserId(Long userId);

	/**
	 * List by group id list.
	 *
	 * @param departmentId the group id
	 *
	 * @return the list
	 */
	List<UacDepartmentUser> listByDepartmentId(@Param("departmentId") Long departmentId);

	/**
	 * Delete exclude super mng int.
	 *
	 * @param departmentId            the group id
	 * @param superManagerUserId the super manager role id
	 *
	 * @return the int
	 */
	int deleteExcludeSuperMng(@Param("departmentId") Long departmentId, @Param("superManagerUserId") Long superManagerUserId);
}