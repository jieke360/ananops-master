/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupUserService.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.domain.UacDepartmentUser;
import com.ananops.provider.model.dto.department.DepartmentBindUserReqDto;
import com.ananops.provider.model.dto.group.GroupBindUserReqDto;

import java.util.List;


/**
 * The interface Uac group user service.
 *
 * @author ananops.com@gmail.com
 */
public interface UacDepartmentUserService extends IService<UacDepartmentUser> {
	/**
	 * 根据userId查询
	 *
	 * @param userId the user id
	 *
	 * @return the uac group user
	 */
	UacDepartmentUser queryByUserId(Long userId);

	/**
	 * 根据userId和version修改
	 *
	 * @param uacDepartmentUser the uac group user
	 *
	 * @return the int
	 */
	int updateByUserId(UacDepartmentUser uacDepartmentUser);

	/**
	 * 通过用户Id获取组织信息
	 *
	 * @param userId the user id
	 *
	 * @return the group list by user id
	 */
	List<UacDepartment> getDepartmentListByUserId(Long userId);

	/**
	 * Save user group.
	 *
	 * @param userId      the id
	 * @param departmentId the department id
	 */
	void saveUserDepartment(Long userId, Long departmentId);

	/**
	 * Bind uac user 4 group int.
	 *
	 * @param departmentBindUserReqDto the group bind user req dto
	 * @param loginAuthDto        the login auth dto
	 */
	void bindUacUser4Department(DepartmentBindUserReqDto departmentBindUserReqDto, LoginAuthDto loginAuthDto);
}
