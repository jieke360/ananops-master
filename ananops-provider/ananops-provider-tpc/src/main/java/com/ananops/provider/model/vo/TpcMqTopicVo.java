/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：TpcMqTopicVo.java
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

import java.util.List;

/**
 * The class Tpc mq topic vo.
 *
 * @author ananops.net @gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TpcMqTopicVo extends BaseVo {
	private static final long serialVersionUID = 3857060544292574468L;

	/**
	 * 生产者名称
	 */
	private String producerName;

	/**
	 * 城市编码
	 */
	private String topicCode;

	/**
	 * 区域编码
	 */
	private String topicName;

	/**
	 * MQ类型, 10 rocketmq 20 kafka
	 */
	private Integer mqType;

	/**
	 * 消息类型, 10 无序消息, 20 无序消息
	 */
	private Integer msgType;

	/**
	 * 状态, 0生效,10,失效
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * Tag 列表
	 */
	private List<TpcMqTagVo> tagVoList;
}
