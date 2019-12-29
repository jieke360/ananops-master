package com.ananops.provider.service.hystrix;


import com.ananops.provider.model.dto.robot.ChatRobotMsgDto;
import com.ananops.provider.service.DingtalkFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;


/**
 * The class Chat robot feign api hystrix.
 *
 * @author ananops.net @gmail.com
 */
@Component
public class DingtalkFeignApiHystrix implements DingtalkFeignApi {

	@Override
	public Wrapper<Boolean> sendChatRobotMsg(final ChatRobotMsgDto uacUserReqDto) {
		return null;
	}
}
