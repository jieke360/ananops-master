/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：UacGroupCommonController.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.web.admin;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.BaseController;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.domain.UacGroup;
import com.ananops.provider.model.dto.department.CheckDepartmentCodeDto;
import com.ananops.provider.model.dto.department.CheckDepartmentNameDto;
import com.ananops.provider.model.dto.group.CheckGroupCodeDto;
import com.ananops.provider.model.dto.group.CheckGroupNameDto;
import com.ananops.provider.model.enums.UacGroupTypeEnum;
import com.ananops.provider.model.vo.DepartmentZtreeVo;
import com.ananops.provider.model.vo.GroupZtreeVo;
import com.ananops.provider.service.UacDepartmentService;
import com.ananops.provider.service.UacGroupService;
import com.ananops.wrapper.WrapMapper;
import com.ananops.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 部门相关公用接口
 *
 * @author ananops.com @gmail.com
 */
@RestController
@RequestMapping(value = "/department", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacDepartmentCommonController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacDepartmentCommonController extends BaseController {

	@Resource
	private UacDepartmentService uacDepartmentService;
	@Resource
	private UacGroupService uacGroupService;

	/**
	 * 根据当前登录人查询部门列表
	 *
	 * @return the group tree by id
	 */
	@PostMapping(value = "/getDepartmentTree")
	@ApiOperation(httpMethod = "POST", value = "根据当前登录人查询部门树")
	public Wrapper<List<DepartmentZtreeVo>> getGroupTreeById() {

		logger.info("根据当前登录人查询部门树");
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Long departmentId = loginAuthDto.getDepartmentId();
		UacDepartment uacDepartment = uacDepartmentService.queryById(departmentId);
		List<DepartmentZtreeVo> tree = uacDepartmentService.getDepartmentTree(uacDepartment.getId());
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", tree);
	}

	/**
	 * 通过部门ID查询部门树
	 *
	 * @param departmentId the group id
	 *
	 * @return the group tree by id
	 */
	@PostMapping(value = "/getDepartmentTree/{departmentId}")
	@ApiOperation(httpMethod = "POST", value = "通过部门ID查询部门列表")
	public Wrapper<List<DepartmentZtreeVo>> getGroupTreeById(@ApiParam(name = "departmentId", value = "通过部门ID查询部门列表") @PathVariable Long departmentId) {

		logger.info("通过部门ID查询部门列表 departmentId={}", departmentId);

		List<DepartmentZtreeVo> tree = uacDepartmentService.getDepartmentTree(departmentId);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "操作成功", tree);
	}

	/**
	 * Check group name with edit wrapper.
	 *
	 * @param checkDepartmentNameDto the check group name dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkDepartmentName")
	@ApiOperation(httpMethod = "POST", value = "编辑校验部门名唯一性")
	public Wrapper<Boolean> checkGroupName(@ApiParam(name = "checkDepartmentName", value = "部门名称") @RequestBody CheckDepartmentNameDto checkDepartmentNameDto) {
		logger.info("校验部门名称唯一性 checkDepartmentNameDto={}", checkDepartmentNameDto);

		Long id = checkDepartmentNameDto.getDepartmentId();
		String departmentName = checkDepartmentNameDto.getDepartmentName();

		Example example = new Example(UacDepartment.class);
		Example.Criteria criteria = example.createCriteria();

		if (id != null) {
			criteria.andNotEqualTo("id", id);
		}
		criteria.andEqualTo("departmentName", departmentName);

		int result = uacDepartmentService.selectCountByExample(example);
		return WrapMapper.ok(result < 1);
	}

	/**
	 * 修改时验证部门编码
	 *
	 * @param checkDepartmentCodeDto the check group code dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkDepartmentCode")
	@ApiOperation(httpMethod = "POST", value = "修改校验部门编码唯一性")
	public Wrapper<Boolean> checkGroupCode(@ApiParam(name = "checkDepartmentCode", value = "部门相关信息") @RequestBody CheckDepartmentCodeDto checkDepartmentCodeDto) {
		logger.info("校验部门编码唯一性 checkDepartmentCodeDto={}", checkDepartmentCodeDto);

		Long id = checkDepartmentCodeDto.getDepartmentId();
		String departmentCode = checkDepartmentCodeDto.getDepartmentCode();

		Example example = new Example(UacGroup.class);
		Example.Criteria criteria = example.createCriteria();

		if (id != null) {
			criteria.andNotEqualTo("id", id);
		}
		criteria.andEqualTo("departmentCode", departmentCode);

		int result = uacDepartmentService.selectCountByExample(example);
		return WrapMapper.ok(result < 1);
	}

}
