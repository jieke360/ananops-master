
package com.ananops.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * The class Login auth dto.
 *
 * @author ananops.net@gmail.com
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "登录人信息")
public class LoginAuthDto implements Serializable {
	private static final long serialVersionUID = -1137852221455042256L;

	@ApiModelProperty(value = "用户ID")
	private Long userId;

	@ApiModelProperty(value = "登录名")
	private String loginName;

	@ApiModelProperty(value = "用户名")
	private String userName;

	@ApiModelProperty(value = "组织ID")
	private Long groupId;

	@ApiModelProperty(value = "组织名称")
	private String groupName;

	@ApiModelProperty(value = "部门ID")
	private Long departmentId;

	@ApiModelProperty(value = "部门名称")
	private String departmentName;

	public LoginAuthDto() {
	}

	public LoginAuthDto(Long userId, String loginName, String userName) {
		this.userId = userId;
		this.loginName = loginName;
		this.userName = userName;
	}

	public LoginAuthDto(Long userId, String loginName, String userName, Long groupId, String groupName, Long departmentId, String departmentName) {
		this.userId = userId;
		this.loginName = loginName;
		this.userName = userName;
		this.groupId = groupId;
		this.groupName = groupName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
}
