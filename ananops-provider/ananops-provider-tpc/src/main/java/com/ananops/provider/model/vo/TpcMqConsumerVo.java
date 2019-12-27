/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：TpcMqConsumerVo.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * The class Mdc mq consumer vo.
 *
 * @author ananops.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TpcMqConsumerVo extends TpcMqSubscribeVo {
	private static final long serialVersionUID = 8833595265432073801L;

	/**
	 * 订阅Topic集合
	 */
	private List<TpcMqTopicVo> mqTopicVoList;

}
