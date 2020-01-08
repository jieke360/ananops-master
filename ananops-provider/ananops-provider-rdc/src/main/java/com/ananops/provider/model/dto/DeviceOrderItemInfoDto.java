package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

@ApiModel
@Getter
public class DeviceOrderItemInfoDto implements Serializable {

    @ApiModelProperty("设备编号，自定义设备不填")
    @JsonProperty("deviceId")
    private Long id;

    @ApiModelProperty("设备名称")
    private String name;

    @ApiModelProperty("设备类型")
    private String type;

    @ApiModelProperty("设备厂商")
    private String manufacture;

    @ApiModelProperty("设备型号")
    private String model;

    @ApiModelProperty("申请数量")
    private Integer count;
}
