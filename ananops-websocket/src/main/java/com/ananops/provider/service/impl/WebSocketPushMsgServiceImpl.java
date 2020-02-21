package com.ananops.provider.service.impl;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.provider.model.dto.ImcTaskStatusChangeDto;
import com.ananops.provider.model.dto.WebSocketMsgDto;
import com.ananops.provider.service.WebSocketPushMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by rongshuai on 2020/2/19 19:28
 */
@Service
public class WebSocketPushMsgServiceImpl implements WebSocketPushMsgService {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Override
    public void SendMessageToWebSocketClient(WebSocketMsgDto webSocketMsgDto, LoginAuthDto loginUser){
        if(loginUser!=null){
            String userId = String.valueOf(loginUser.getUserId());
            try{
                //发送单对单WebSocket消息
                messagingTemplate.convertAndSendToUser(userId,"/queue/chat",webSocketMsgDto);
            }catch (Exception e){
                throw new BusinessException(ErrorCodeEnum.WEBSOCKET10100001);
            }
        }
    }

}
