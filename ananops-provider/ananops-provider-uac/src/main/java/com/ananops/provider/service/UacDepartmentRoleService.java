/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupUserService.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.domain.UacDepartmentRole;

import java.util.List;


/**
 * The interface Uac department role service.
 *
 * @author ananops.com@gmail.com
 */
public interface UacDepartmentRoleService extends IService<UacDepartmentRole> {
	/**
	 * 根据userId查询
	 *
	 * @param roleId the user id
	 *
	 * @return the uac group user
	 */
	UacDepartmentRole queryByRoleId(Long roleId);

	/**
	 * 根据userId和version修改
	 *
	 * @param uacDepartmentRole the uac group user
	 *
	 * @return the int
	 */
	int updateByRoleId(UacDepartmentRole uacDepartmentRole);

	/**
	 * 通过用户Id获取部门信息
	 *
	 * @param roleId the user id
	 *
	 * @return the group list by user id
	 */
	List<UacDepartment> getDepartmentListByRoleId(Long roleId);

	/**
	 * Save user group.
	 *
	 * @param roleId      the id
	 * @param departmentId the group id
	 */
	void saveUserDepartment(Long roleId, Long departmentId);
}
