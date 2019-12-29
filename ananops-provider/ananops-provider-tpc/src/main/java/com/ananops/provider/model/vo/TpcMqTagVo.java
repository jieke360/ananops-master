/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：TpcMqTagVo.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.model.vo;

import com.ananops.base.dto.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class Mdc mq tag vo.
 *
 * @author ananops.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TpcMqTagVo extends BaseVo {
	private static final long serialVersionUID = -4176095424582783954L;
	/**
	 * 主题ID
	 */
	private Long topicId;

	/**
	 * 主题编码
	 */
	private String topicCode;

	/**
	 * 主题名称
	 */
	private String topicName;

	/**
	 * 城市编码
	 */
	private String tagCode;

	/**
	 * 区域编码
	 */
	private String tagName;

	/**
	 * 状态, 0生效,10,失效
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;
}
