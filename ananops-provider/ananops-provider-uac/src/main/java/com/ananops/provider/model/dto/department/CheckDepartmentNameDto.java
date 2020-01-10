/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：CheckGroupNameDto.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.model.dto.department;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * The class Check department name dto.
 *
 * @author ananops.com@gmail.com
 */
@Data
@ApiModel
public class CheckDepartmentNameDto {

	@ApiModelProperty(value = "部门ID")
	private Long departmentId;

	@ApiModelProperty(value = "部门名称")
	private String departmentName;
}
