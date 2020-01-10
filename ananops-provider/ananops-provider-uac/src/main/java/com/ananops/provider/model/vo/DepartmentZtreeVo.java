/*
 * Copyright (c) 2019. ananops.com All Rights Reserved.
 * 项目名称：ananops平台
 * 类名称：departmentZtreeVo.java
 * 创建人：ananops
 * 平台官网: http://ananops.com
 */

package com.ananops.provider.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * The class department z tree vo.
 *
 * @author ananops.com@gmail.com
 */
@Getter
@Setter
public class DepartmentZtreeVo extends ZtreeResponseVo implements Serializable {

	private static final long serialVersionUID = 8835704500635133372L;
	/**
	 * 部门id
	 */
	private Long groupId;
	/**
	 * 部门名称
	 */
	private String groupName;
	/**
	 *部门编码
	 */
	private String departmentCode;

	/**
	 * 部门流水号
	 */
	private String departmentSerialNo;

	/**
	 * 部门名称
	 */
	private String departmentName;

	/**
	 * 详细地址
	 */
	private String departmentAddress;

	/**
	 * 所在城市
	 */
	private String departmentCity;

	/**
	 * 联系人
	 */
	private String contact;

	/**
	 * 联系人电话
	 */
	private String contactPhone;

	/**
	 * 创建人
	 */
	private String creator;

	/**
	 * 图标样式
	 */
	private String iconSkin;

	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdTime;

	/**
	 * 状态
	 */
	private int status;

	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 是否是节点
	 */
	private Integer leaf;

	/**
	 * Equals boolean.
	 *
	 * @param o the o
	 *
	 * @return the boolean
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}

		DepartmentZtreeVo that = (DepartmentZtreeVo) o;

		return this.getId().equals(that.getId());

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "departmentZTreeVo{" +
				", groupId='" + groupId + '\'' +
				", groupName='" + groupName + '\'' +
				", departmentCode='" + departmentCode + '\'' +
				", departmentSerialNo='" + departmentSerialNo + '\'' +
				", departmentName='" + departmentName + '\'' +
				", departmentAddress='" + departmentAddress + '\'' +
				", departmentCity='" + departmentCity + '\'' +
				", contact='" + contact + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				", creator='" + creator + '\'' +
				", iconSkin='" + iconSkin + '\'' +
				", createdTime=" + createdTime +
				", status='" + status + '\'' +
				", level=" + level +
				", leaf=" + leaf +
				'}';
	}
}
