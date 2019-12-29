/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：OptSmsService.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

/**
 * The interface Opt sms service.
 *
 * @author ananops.net@gmail.com
 */
public interface OptSmsService {
	/**
	 * Send sms send sms response.
	 *
	 * @param sendSmsRequest the send sms request
	 *
	 * @return the send sms response
	 */
	SendSmsResponse sendSms(SendSmsRequest sendSmsRequest);
}
