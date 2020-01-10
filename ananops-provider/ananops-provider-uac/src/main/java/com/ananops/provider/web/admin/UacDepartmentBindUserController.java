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
import com.ananops.provider.model.dto.department.DepartmentBindUserDto;
import com.ananops.provider.model.dto.department.DepartmentBindUserReqDto;
import com.ananops.provider.service.UacDepartmentService;
import com.ananops.provider.service.UacDepartmentUserService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 组织绑定用户.
 *
 * @author ananops.com @gmail.com
 */
@RestController
@RequestMapping(value = "/departmentBindUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacDepartmentBindUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacDepartmentBindUserController extends BaseController {

	@Resource
	private UacDepartmentService uacDepartmentService;
	@Resource
	private UacDepartmentUserService uacDepartmentUserService;

	/**
	 * 组织绑定用户
	 *
	 * @param departmentBindUserReqDto the group bind user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/bindUser")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "部门绑定用户")
	public Wrapper bindUser4Department(@ApiParam(name = "uacDepartmentBindUserReqDto", value = "部门绑定用户") @RequestBody DepartmentBindUserReqDto departmentBindUserReqDto) {
		logger.info("部门绑定用户...  departmentBindUserReqDto={}", departmentBindUserReqDto);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		uacDepartmentUserService.bindUacUser4Department(departmentBindUserReqDto, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 组织绑定用户页面数据
	 *
	 * @param departmentId the group id
	 *
	 * @return the group bind user page info
	 */
	@PostMapping(value = "/getBindUser/{departmentId}")
	@ApiOperation(httpMethod = "POST", value = "获取部门绑定用户页面数据")
	public Wrapper<DepartmentBindUserDto> getDepartmentBindUserPageInfo(@ApiParam(name = "departmentId", value = "部门id") @PathVariable Long departmentId) {
		logger.info("查询部门绑定用户页面数据 departmentId={}", departmentId);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Long currentUserId = loginAuthDto.getUserId();
		DepartmentBindUserDto bindUserDto = uacDepartmentService.getDepartmentBindUserDto(departmentId, currentUserId);
		return WrapMapper.ok(bindUserDto);
	}
}
