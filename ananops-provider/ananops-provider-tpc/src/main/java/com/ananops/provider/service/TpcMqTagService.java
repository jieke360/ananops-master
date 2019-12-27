/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：TpcMqTagService.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.TpcMqTag;
import com.ananops.provider.model.vo.TpcMqTagVo;

import java.util.List;

/**
 * The interface Tpc mq tag service.
 *
 * @author ananops.net @gmail.com
 */
public interface TpcMqTagService extends IService<TpcMqTag> {
	/**
	 * 查询Tag列表.
	 *
	 * @param mdcMqTag the mdc mq tag
	 *
	 * @return the list
	 */
	List<TpcMqTagVo> listWithPage(TpcMqTag mdcMqTag);

	/**
	 * 根据ID删除TAG.
	 *
	 * @param tagId the tag id
	 *
	 * @return the int
	 */
	int deleteTagById(Long tagId);
}
