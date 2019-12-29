package com.ananops.provider.service;


import com.ananops.annotation.NoNeedAccessAuthentication;
import com.ananops.provider.model.dto.robot.ChatRobotMsgDto;
import com.ananops.provider.service.hystrix.DingtalkFeignApiHystrix;
import com.ananops.security.feign.OAuth2FeignAutoConfiguration;
import com.ananops.wrapper.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface Dingtalk feign api.
 *
 * @author ananops.net @gmail.com
 */
@FeignClient(value = "ananops-provider-opc", configuration = OAuth2FeignAutoConfiguration.class, fallback = DingtalkFeignApiHystrix.class)
public interface DingtalkFeignApi {

	/**
	 * 钉钉机器人推送消息.
	 *
	 * @param uacUserReqDto the uac user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/opc/dingtalk/sendChatRobotMsg")
	@NoNeedAccessAuthentication
	Wrapper<Boolean> sendChatRobotMsg(@RequestBody ChatRobotMsgDto uacUserReqDto);
}
