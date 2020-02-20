package com.ananops.provider.service;

import com.ananops.provider.model.Chat;
import com.ananops.provider.model.Greeting;
import com.ananops.provider.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by rongshuai on 2020/2/18 22:43
 */
@RestController
public class GreetingController {

	@Autowired
	SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000 * 24); // simulated delay
		Greeting greeting = new Greeting("Hello, " + message.getName() + "!");
		return greeting;
	}

	@MessageMapping("/chat")
	public void greetToOne(Principal principal, Chat chat) throws Exception {
		String from = principal.getName();
		chat.setFrom(from);
		System.out.println(chat.toString());
		System.out.println(principal);
		messagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
	}


}
