package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel
public class MdmcTroubleAddressDto implements Serializable {
    private static final long serialVersionUID = -7409330306626883489L;
    /**
     * 故障位置列表
     */
    @ApiModelProperty(value = "故障位置列表")
    private List<String> troubleAddressList;

    /**
     * 故障经度列表
     */
    @ApiModelProperty(value = "故障经度列表")
    private List<BigDecimal> troubleLongitudeList;

    /**
     * 故障纬度列表
     */
    @ApiModelProperty(value = "故障纬度列表")
    private List<BigDecimal> troubleLatitudeList;
}
