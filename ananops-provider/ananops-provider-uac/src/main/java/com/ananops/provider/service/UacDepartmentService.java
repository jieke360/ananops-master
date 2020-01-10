/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupService.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.service;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.dto.department.DepartmentBindRoleReqDto;
import com.ananops.provider.model.dto.department.DepartmentBindUserDto;
import com.ananops.provider.model.dto.user.IdStatusDto;
import com.ananops.provider.model.vo.DepartmentZtreeVo;
import com.ananops.provider.model.vo.MenuVo;

import java.util.List;

/**
 * The interface Uac group service.
 *
 * @author ananops.com@gmail.com
 */
public interface UacDepartmentService extends IService<UacDepartment> {

	/**
	 * Update uac group status by id int.
	 *
	 * @param idStatusDto  the id status dto
	 * @param loginAuthDto the login auth dto
	 *
	 * @return the int
	 */
	int updateUacDepartmentStatusById(IdStatusDto idStatusDto, LoginAuthDto loginAuthDto);

	/**
	 * Delete uac group by id int.
	 *
	 * @param id the id
	 *
	 * @return the int
	 */
	int deleteUacDepartmentById(Long id);

	/**
	 * Query by id uac group.
	 *
	 * @param departmentId the group id
	 *
	 * @return the uac group
	 */
	UacDepartment queryById(Long departmentId);

	/**
	 * Gets group tree.
	 *
	 * @param id the id
	 *
	 * @return the group tree
	 */
	List<DepartmentZtreeVo> getDepartmentTree(Long id);

	/**
	 * Find current user have group info list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<MenuVo> getDepartmentTreeListByUserId(Long userId);

	/**
	 * Gets group bind user dto.
	 *
	 * @param departmentId the group id
	 * @param userId  the user id
	 *
	 * @return the group bind user dto
	 */
	DepartmentBindUserDto getDepartmentBindUserDto(Long departmentId, Long userId);

	/**
	 * get group bind role id.
	 *
	 * @param departmentId the department id
	 * @return role id
	 */
	Long getDepartmentBindRoleId(Long departmentId);

	/**
	 * Bind uac user 4 group int.
	 *
	 * @param departmentBindRoleReqDto the group bind user req dto
	 * @param loginAuthDto        the login auth dto
	 */
	void bindUacRole4Department(DepartmentBindRoleReqDto departmentBindRoleReqDto, LoginAuthDto loginAuthDto);

	/**
	 * Save uac group int.
	 *
	 * @param department        the group
	 * @param loginAuthDto the login auth dto
	 *
	 * @return the int
	 */
	int saveUacDepartment(UacDepartment department, LoginAuthDto loginAuthDto);

	/**
	 * Gets by id.
	 *
	 * @param id the id
	 *
	 * @return the by id
	 */
	UacDepartment getById(Long id);

	UacDepartment getByUserId(Long userId);
}
