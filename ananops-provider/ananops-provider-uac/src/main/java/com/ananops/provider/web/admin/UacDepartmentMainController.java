/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupMainController.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.web.admin;


import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.annotation.LogAnnotation;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.dto.user.IdStatusDto;
import com.ananops.provider.model.vo.MenuVo;
import com.ananops.provider.service.UacDepartmentService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理主页面
 *
 * @author ananops.com @gmail.com
 */
@RestController
@RequestMapping(value = "/department", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacDepartmentMainController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacDepartmentMainController extends BaseController {

	@Resource
	private UacDepartmentService uacDepartmentService;

	/**
	 * 根据id删除部门
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/deleteById/{id}")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "根据id删除部门")
	public Wrapper deleteDepartmentById(@ApiParam(name = "id", value = "部门id") @PathVariable Long id) {
		logger.info(" 根据id删除部门 id={}", id);
		int result = uacDepartmentService.deleteUacDepartmentById(id);
		if (result < 1) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "操作失败");
		} else {
			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功");
		}
	}

	/**
	 * 根据id修改部门状态
	 *
	 * @param idStatusDto the id status dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/modifyStatus")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "根据id修改部门状态")
	public Wrapper modifyDepartmentStatus(@ApiParam(name = "modifyDepartmentStatus", value = "修改状态") @RequestBody IdStatusDto idStatusDto) {
		logger.info("根据id修改部门状态 idStatusDto={}", idStatusDto);
		UacDepartment uacDepartment = new UacDepartment();
		uacDepartment.setId(idStatusDto.getId());
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Integer status = idStatusDto.getStatus();
		uacDepartment.setStatus(status);
		int result = uacDepartmentService.updateUacDepartmentStatusById(idStatusDto, loginAuthDto);
		if (result < 1) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "操作失败");
		} else {
			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功");
		}
	}


	/**
	 * 获取主页面数据
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/getTree")
	@ApiOperation(httpMethod = "POST", value = "获取部门树")
	public Wrapper<List<MenuVo>> getTree() {
		Long userId = super.getLoginAuthDto().getUserId();
		List<MenuVo> tree = uacDepartmentService.getDepartmentTreeListByUserId(userId);
		return WrapMapper.ok(tree);
	}

	/**
	 * 编辑部门
	 *
	 * @param department the group
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/save")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "编辑部门信息")
	public Wrapper editDepartment(@ApiParam(name = "group", value = "部门信息") @RequestBody UacDepartment department) {
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		uacDepartmentService.saveUacDepartment(department, loginAuthDto);
		return WrapMapper.ok();
	}


	/**
	 * 获取编辑页面数据
	 *
	 * @param id the id
	 *
	 * @return the edit group page info
	 */
	@PostMapping(value = "/queryById/{id}")
	@ApiOperation(httpMethod = "POST", value = "获取编辑页面数据")
	public Wrapper<UacDepartment> getEditGroupPageInfo(@ApiParam(name = "id", value = "部门id") @PathVariable Long id) {
		UacDepartment department = uacDepartmentService.getById(id);
		return WrapMapper.ok(department);
	}
}
