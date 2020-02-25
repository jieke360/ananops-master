package com.ananops.provider.consumer;

import com.ananops.JacksonUtil;
import com.ananops.base.constant.AliyunMqTopicConstants;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.base.exception.BusinessException;
import com.ananops.core.mq.MqMessage;
import com.ananops.provider.model.dto.WebSocketMsgDto;
import com.ananops.provider.model.dto.mqdto.MdmcSendMsgDto;
import com.ananops.provider.service.WebSocketPushMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by huqiaoqian on 2020/2/24
 */
@Slf4j
@Service
public class MdmcTopicConsumer {
    @Resource
    WebSocketPushMsgService webSocketPushMsgService;

    public void handlerSendMdmcTopic(String body, String topicName, String tags, String keys){
        MqMessage.checkMessage(body, keys, topicName);
        if (StringUtils.equals(tags, AliyunMqTopicConstants.MqTagEnum.MDMC_TASK_STATUS_CHANGED.getTag())) {
            System.out.println("MDMC_TASK_TOPIC:" + body);
            MdmcSendMsgDto mdmcSendMsgDto;
            try {
                mdmcSendMsgDto = JacksonUtil.parseJson(body, MdmcSendMsgDto.class);
            } catch (IOException e) {
                log.error("发送短信MQ出现异常={}", e.getMessage(), e);
                throw new IllegalArgumentException("JSON转换异常", e);
            }
            if(mdmcSendMsgDto==null){
                throw new BusinessException(ErrorCodeEnum.WEBSOCKET10100000);
            }
            String userId = String.valueOf(mdmcSendMsgDto.getUserId());
            WebSocketMsgDto<MdmcSendMsgDto> webSocketMsgDto = new WebSocketMsgDto<>();
            webSocketMsgDto.setTopic(AliyunMqTopicConstants.MqTopicEnum.MDMC_TOPIC.getTopic());
            webSocketMsgDto.setTag(AliyunMqTopicConstants.MqTagEnum.MDMC_TASK_STATUS_CHANGED.getTag());
            webSocketMsgDto.setContent(mdmcSendMsgDto);
            log.info("webSocketMsgDto = {}",webSocketMsgDto);
            log.info("userId = {}",userId);
            webSocketPushMsgService.SendMessageToWebSocketClient(webSocketMsgDto,userId);
        }
        else throw new BusinessException(ErrorCodeEnum.TPC100500019);
    }
}
