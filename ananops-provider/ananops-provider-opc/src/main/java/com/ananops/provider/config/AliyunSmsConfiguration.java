/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：AliyunSmsConfiguration.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ananops.config.properties.AnanopsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * The class Aliyun sms configuration.
 *
 * @author ananops.net@gmail.com
 */
@Slf4j
@Configuration
public class AliyunSmsConfiguration {

	@Resource
	private AnanopsProperties AnanopsProperties;

	/**
	 * Acs client acs client.
	 *
	 * @return the acs client
	 *
	 * @throws ClientException the client exception
	 */
	@Bean
	public IAcsClient acsClient() throws ClientException {
		log.info("SMS Bean IAcsClient Start");
		IClientProfile profile = DefaultProfile.getProfile(AnanopsProperties.getAliyun().getSms().getRegionId(), AnanopsProperties.getAliyun().getKey().getAccessKeyId(), AnanopsProperties.getAliyun().getKey().getAccessKeySecret());
		DefaultProfile.addEndpoint(AnanopsProperties.getAliyun().getSms().getEndpointName(), AnanopsProperties.getAliyun().getSms().getRegionId(), AnanopsProperties.getAliyun().getSms().getProduct(), AnanopsProperties.getAliyun().getSms().getDomain());
		DefaultAcsClient defaultAcsClient = new DefaultAcsClient(profile);
		log.info("加载SMS Bean IAcsClient OK");
		return defaultAcsClient;
	}

}
