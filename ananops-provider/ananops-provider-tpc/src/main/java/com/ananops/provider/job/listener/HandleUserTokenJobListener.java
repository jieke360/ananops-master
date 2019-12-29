/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：HandleUserTokenJobListener.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.job.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.ananops.provider.model.dto.robot.ChatRobotMsgDto;
import com.ananops.provider.model.factory.ChatRobotMsgFactory;
import com.ananops.provider.service.OpcRpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The class Handle user token job listener.
 *
 * @author ananops.net @gmail.com
 */
@Slf4j
public class HandleUserTokenJobListener implements ElasticJobListener {//事件监听器

	@Resource
	private OpcRpcService opcRpcService;

	private AtomicLong startTime = new AtomicLong();
	private AtomicLong endTimestamp = new AtomicLong();
	@Value("ananops.dingTalk.webhookToken.jobListener")
	private String webhookToken;

	/**
	 * Before job executed.
	 *
	 * @param shardingContexts the sharding contexts
	 */
	@Override
	public void beforeJobExecuted(ShardingContexts shardingContexts) {//定时任务执行前
		log.info("beforeJobExecuted - shardingContexts={}", shardingContexts);
		startTime.set(System.currentTimeMillis());
	}

	/**
	 * After job executed.
	 *
	 * @param shardingContexts the sharding contexts
	 */
	@Override
	public void afterJobExecuted(ShardingContexts shardingContexts) {//定时任务执行后
		log.info("afterJobExecuted - shardingContexts={}", shardingContexts);
		endTimestamp.set(System.currentTimeMillis());
		long exeTime = endTimestamp.get() - startTime.get();
		String message = String.format("jobName: %s | 执行完毕, 总耗时: %s", shardingContexts.getJobName(), exeTime + "毫秒");
		this.sendDingTalk(message);
	}

	private void sendDingTalk(String message) {//定时任务执行后就发送消息
		log.info("开始发送消息. message={}", message);
		ChatRobotMsgDto chatRobotMsgDto = ChatRobotMsgFactory.createChatRobotTextMsg(webhookToken, message, false, null);
		boolean result = opcRpcService.sendChatRobotMsg(chatRobotMsgDto);
		if (result) {
			log.info("发送消息成功. message={}", message);
		} else {
			log.error("发送消息失败. message={}", message);
		}
	}
}