/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：MdcAddress.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * The class Mdc address.
 *
 * @author ananops.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "an_mdc_address")
public class MdcAddress extends BaseEntity {
	private static final long serialVersionUID = -499010884211394846L;

	/**
	 * 地址名称
	 */
	private String name;

	/**
	 * 父ID
	 */
	private Long pid;

	/**
	 * 城市编码
	 */
	@Column(name = "city_code")
	private String cityCode;

	/**
	 * 级别（省市区县）
	 */
	private Integer level;

	/**
	 * 区域编码
	 */
	@Column(name = "ad_code")
	private String adCode;

	/**
	 * 行政区边界坐标点
	 */
	private String polyline;

	/**
	 * 城市中心点
	 */
	private String center;
}