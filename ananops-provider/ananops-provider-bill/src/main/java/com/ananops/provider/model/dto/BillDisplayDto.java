package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode()
@Data
public class BillDisplayDto {

    
    @ApiModelProperty(value = "账单ID")
    private String id;

    @ApiModelProperty(value = "支付方式")
    private String paymentMethod;

    @ApiModelProperty(value = "交易方式")
    private String transactionMethod;

    @ApiModelProperty(value = "数额")
    private Float amount;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "当前时间")
    private Long time;

    @ApiModelProperty(value = "服务商id")
    private String supplier;

    @ApiModelProperty(value = "服务商名称")
    private String supplierName;

    @ApiModelProperty(value = "工单ID")
    private String workOrderId;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "设备数量")
    private Float deviceAmount;

    @ApiModelProperty(value = "")
    private Float serviceAmount;
}