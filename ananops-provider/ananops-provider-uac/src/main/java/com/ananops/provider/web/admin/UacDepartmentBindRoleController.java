/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupBindUserController.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.web.admin;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.annotation.LogAnnotation;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.dto.department.DepartmentBindRoleReqDto;
import com.ananops.provider.service.UacDepartmentService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 组织绑定角色.
 *
 * @author ananops.com @gmail.com
 */
@RestController
@RequestMapping(value = "/departmentBindRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacDepartmentBindRoleController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacDepartmentBindRoleController extends BaseController {

	@Resource
	private UacDepartmentService uacDepartmentService;

	/**
	 * 组织绑定角色
	 *
	 * @param departmentBindRoleReqDto the group bind user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/bindRole")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "部门绑定角色")
	public Wrapper bindUser4Role(@ApiParam(name = "uacGroupBindRoleReqDto", value = "部门绑定角色") @RequestBody DepartmentBindRoleReqDto departmentBindRoleReqDto) {
		logger.info("部门绑定角色...  departmentBindRoleReqDto={}", departmentBindRoleReqDto);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		uacDepartmentService.bindUacRole4Department(departmentBindRoleReqDto, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 组织绑定角色页面数据
	 *
	 * @param departmentId the group id
	 *
	 * @return the group bind user page info
	 */
	@PostMapping(value = "/getBindRoleId/{departmentId}")
	@ApiOperation(httpMethod = "POST", value = "获取部门绑定角色id")
	public Wrapper<Long> getDepartmentBindRolePageInfo(@ApiParam(name = "departmentId", value = "部门id") @PathVariable Long departmentId) {
		logger.info("查询部门绑定角色页面数据 groupId={}", departmentId);
		Long roleId = uacDepartmentService.getDepartmentBindRoleId(departmentId);
		return WrapMapper.ok(roleId);
	}
}
