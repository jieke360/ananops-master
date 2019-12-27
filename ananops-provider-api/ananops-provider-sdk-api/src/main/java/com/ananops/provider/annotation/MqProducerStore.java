package com.ananops.provider.annotation;

import com.ananops.provider.model.enums.DelayLevelEnum;
import com.ananops.provider.model.enums.MqOrderTypeEnum;
import com.ananops.provider.model.enums.MqSendTypeEnum;

import java.lang.annotation.*;


/**
 * 保存生产者消息.
 *
 * @author ananops.net @gmail.com
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqProducerStore {
	//WAIT_CONFIRM等待发送 SAVE_AND_SEND直接发送
	MqSendTypeEnum sendType() default MqSendTypeEnum.WAIT_CONFIRM;
	//PRDER(1)有序 DIS_ORDER(0)无序
	MqOrderTypeEnum orderType() default MqOrderTypeEnum.ORDER;
	//Rocketmq默认延时级别
	DelayLevelEnum delayLevel() default DelayLevelEnum.ZERO;
}
