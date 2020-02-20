package com.ananops.provider.config;


import com.ananops.RedisKeyUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.dto.UserTokenDto;
import com.ananops.provider.model.domain.MqMessageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * Created by rongshuai on 2020/2/18 22:43
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Resource
	private RedisTemplate<String,Object> redisTemplate;

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration){
		registration.setInterceptors(new ChannelInterceptorAdapter() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
				if (StompCommand.CONNECT.equals(accessor.getCommand())) {
					final String jwtToken = StringUtils.substringAfter(accessor.getFirstNativeHeader("Authorization"),"Bearer ");
					LoginAuthDto loginUser = (UserTokenDto) redisTemplate.opsForValue().get(RedisKeyUtil.getAccessTokenKey(jwtToken));
					System.out.println(loginUser.toString());
					String body = loginUser.toString();
					String topic = AliyunMqTopicConstants.MqTagEnum.IMC_TASK_STATUS_CHANGED.getTopic();
					String tag = AliyunMqTopicConstants.MqTagEnum.IMC_TASK_STATUS_CHANGED.getTag();
					String key = RedisKeyUtil.createMqKey(topic,tag,String.valueOf(loginUser.getUserId()),body);
					MqMessageData mqMessageData = new MqMessageData(body,topic,tag,key);
					if(loginUser!=null){//将userId和socket连接进行绑定
						String userId = String.valueOf(loginUser.getUserId());
						if(StringUtils.isNotEmpty(userId)){
							System.out.println(userId);
							Principal principal = new Principal() {
								@Override
								public String getName() {
									return userId;
								}
							};
							accessor.setUser(principal);
						}
					}
				}
				return message;
			}
		});
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
				// bypasses spring web security
				.setAllowedOrigins("*");
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// prefix for subscribe
		config.enableSimpleBroker("/topic","/queue");
		// prefix for send
		config.setApplicationDestinationPrefixes("/app");
	}
}
