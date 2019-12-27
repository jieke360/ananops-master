/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：HandleUserJwtTokenJob.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.ananops.elastic.lite.annotation.ElasticJobConfig;
import com.ananops.provider.service.UacRpcService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * The class Spring simple job.
 *
 * @author ananops.net @gmail.com
 */
@Slf4j
@ElasticJobConfig(cron = "0 0/30 * * * ?")
public class HandleUserJwtTokenJob implements SimpleJob {
	@Resource
	private UacRpcService uacRpcService;

	/**
	 * Execute.
	 *
	 * @param shardingContext the sharding context
	 */
	@Override
	public void execute(final ShardingContext shardingContext) {
		uacRpcService.batchUpdateTokenOffLine();
	}
}
