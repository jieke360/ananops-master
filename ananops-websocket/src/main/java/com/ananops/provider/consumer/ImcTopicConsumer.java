package com.ananops.provider.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ananops.JacksonUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.mq.MqMessage;
import com.ananops.provider.model.dto.ImcTaskStatusChangeDto;
import com.ananops.provider.model.dto.UpdateAttachmentDto;
import com.ananops.provider.model.dto.WebSocketMsgDto;
import com.ananops.provider.service.WebSocketPushMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by rongshuai on 2020/2/19 18:56
 */
@Slf4j
@Service
public class ImcTopicConsumer {

    @Resource
    WebSocketPushMsgService webSocketPushMsgService;

    public void handlerSendImcTopic(String body, String topicName, String tags, String keys){
        MqMessage.checkMessage(body, keys, topicName);
        if (StringUtils.equals(tags, AliyunMqTopicConstants.MqTagEnum.IMC_TASK_STATUS_CHANGED.getTag())) {
            System.out.println("IMC_TASK_TOPIC:" + body);
            ImcTaskStatusChangeDto imcTaskStatusChangeDto;
            try {
                imcTaskStatusChangeDto = JacksonUtil.parseJson(body, ImcTaskStatusChangeDto.class);
            } catch (IOException e) {
                log.error("发送短信MQ出现异常={}", e.getMessage(), e);
                throw new IllegalArgumentException("JSON转换异常", e);
            }
            if(imcTaskStatusChangeDto==null){
                throw new BusinessException(ErrorCodeEnum.WEBSOCKET10100000);
            }
            LoginAuthDto loginUser = imcTaskStatusChangeDto.getLoginAuthDto();
            WebSocketMsgDto<ImcTaskStatusChangeDto> webSocketMsgDto = new WebSocketMsgDto<>();
            webSocketMsgDto.setTopic(AliyunMqTopicConstants.MqTopicEnum.IMC_TOPIC.getTopic());
            webSocketMsgDto.setTag(AliyunMqTopicConstants.MqTagEnum.IMC_TASK_STATUS_CHANGED.getTag());
            webSocketMsgDto.setContent(imcTaskStatusChangeDto);
            webSocketPushMsgService.SendMessageToWebSocketClient(webSocketMsgDto,loginUser);
        }else if(StringUtils.equals(tags, AliyunMqTopicConstants.MqTagEnum.IMC_ITEM_STATUS_CHANGED.getTag())){
            System.out.println("IMC_ITEM_TOPIC:" + body);
        }
    }
}
