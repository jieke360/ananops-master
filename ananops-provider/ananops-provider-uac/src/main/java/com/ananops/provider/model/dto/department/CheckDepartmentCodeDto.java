/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：CheckGroupCodeDto.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.model.dto.department;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * The class Check department code dto.
 *
 * @author ananops.com@gmail.com
 */
@Data
@ApiModel
public class CheckDepartmentCodeDto implements Serializable {

	private static final long serialVersionUID = -7471245927289653237L;
	@ApiModelProperty(value = "部门ID")
	private Long departmentId;

	@ApiModelProperty(value = "部门code")
	private String departmentCode;
}
