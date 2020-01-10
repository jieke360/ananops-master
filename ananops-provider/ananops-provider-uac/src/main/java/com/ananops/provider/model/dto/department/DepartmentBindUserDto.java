/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：GroupBindUserDto.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.model.dto.department;

import com.ananops.provider.model.dto.role.BindUserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * The class Department bind role dto.
 *
 * @author ananops.com@gmail.com
 */
@Data
@ApiModel(value = "DepartmentBindUserDto")
public class DepartmentBindUserDto implements Serializable {

	private static final long serialVersionUID = 1383005712348886707L;
	/**
	 * 未绑定的用户集合
	 */
	@ApiModelProperty(value = "所有角色集合")
	private Set<BindUserDto> allUserSet;

	/**
	 * 已经绑定的用户集合
	 */
	@ApiModelProperty(value = "已经绑定的角色集合")
	private Set<Long> alreadyBindUserIdSet;

}
