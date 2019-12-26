/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacGroupBindUserController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.ananops.provider.web.admin;


import com.ananops.base.dto.BaseQuery;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.annotation.LogAnnotation;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.UacRole;
import com.ananops.provider.model.domain.UacUser;
import com.ananops.provider.model.dto.group.GroupBindUacUserDto;
import com.ananops.provider.model.dto.group.GroupBindUserDto;
import com.ananops.provider.model.dto.group.GroupBindUserReqDto;
import com.ananops.provider.model.vo.RoleVo;
import com.ananops.provider.service.UacGroupService;
import com.ananops.provider.service.UacRoleService;
import com.ananops.provider.service.UacUserService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 组织绑定用户.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacGroupBindUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacGroupBindUserController extends BaseController {

	@Resource
	private UacUserService uacUserService;

	@Resource
	private UacGroupService uacGroupService;

	@Resource
	private UacRoleService uacRoleService;

	/**
	 * 组织绑定用户
	 *
	 * @param groupBindUserReqDto the group bind user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/bindUser")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "组织绑定用户")
	public Wrapper bindUser4Role(@ApiParam(name = "uacGroupBindUserReqDto", value = "组织绑定用户") @RequestBody GroupBindUserReqDto groupBindUserReqDto) {
		logger.info("组织绑定用户...  groupBindUserReqDto={}", groupBindUserReqDto);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		uacGroupService.bindUacUser4Group(groupBindUserReqDto, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 组织绑定用户页面数据
	 *
	 * @param groupId the group id
	 *
	 * @return the group bind user page info
	 */
	@PostMapping(value = "/getBindUser/{groupId}")
	@ApiOperation(httpMethod = "POST", value = "获取组织绑定用户页面数据")
	public Wrapper<GroupBindUserDto> getGroupBindUserPageInfo(@ApiParam(name = "groupId", value = "组织id") @PathVariable Long groupId) {
		logger.info("查询组织绑定用户页面数据 groupId={}", groupId);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Long currentUserId = loginAuthDto.getUserId();
		GroupBindUserDto bindUserDto = uacGroupService.getGroupBindUserDto(groupId, currentUserId);
		return WrapMapper.ok(bindUserDto);
	}

	@PostMapping(value = "/queryUserListWithPage")
	@ApiOperation(httpMethod = "POST", value = "查询用户列表")
	public Wrapper<PageInfo<UacUser>> queryUacRoleListWithPage(@ApiParam(name = "user", value = "用户信息") @RequestBody UacUser uacUser) {

		logger.info("查询用户列表roleQuery={}", uacUser);
		PageHelper.startPage(uacUser.getPageNum(), uacUser.getPageSize());
		uacUser.setOrderBy("created_time desc");
		PageInfo<UacUser> users= uacUserService.queryUserListWithPage(uacUser);
		return WrapMapper.ok(users);
	}

	@PostMapping(value = "/getGroupBindUserList")
	@ApiOperation(httpMethod = "POST", value = "获取组织绑定当前用户页面数据")
	public Wrapper<PageInfo<UacUser>> getGroupBindCurUserpageInfo(@ApiParam(name = "pageInfo", value = "分页信息") @RequestBody BaseQuery baseQuery) {
		logger.info("查询组织绑定当前用户页面数据");
		PageHelper.startPage(baseQuery.getPageNum(), baseQuery.getPageSize());
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Long curUserGroupId = loginAuthDto.getGroupId();
		Long currentUserId = loginAuthDto.getUserId();
		List<UacUser> users = uacRoleService.getRoleBindUacUserDto(curUserGroupId, currentUserId);
		return WrapMapper.ok(new PageInfo<>(users));
	}
}
