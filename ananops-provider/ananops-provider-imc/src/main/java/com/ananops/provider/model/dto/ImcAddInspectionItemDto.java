package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rongshuai on 2019/11/28 10:18
 */
@Data
@ApiModel
public class ImcAddInspectionItemDto implements Serializable {
    private static final long serialVersionUID = -3159670420426980074L;
    /**
     * 巡检任务子项ID
     */
    @ApiModelProperty(value = "巡检任务子项ID")
    private Long id;
    /**
     * 从属的巡检任务的ID
     */
    @ApiModelProperty(value = "从属的巡检任务的ID")
    private Long inspectionTaskId;

    /**
     * 计划开始时间
     */
    @ApiModelProperty(value = "计划开始时间")
    private Date scheduledStartTime;

    /**
     * 实际开始时间
     */
    @ApiModelProperty(value = "实际开始时间")
    private Date actualStartTime;

    /**
     * 实际完成时间
     */
    @ApiModelProperty(value = "实际完成时间")
    private Date actualFinishTime;

    /**
     * 计划完成天数
     */
    @ApiModelProperty(value = "计划完成天数")
    private Integer days;

    /**
     * 巡检周期（月）
     */
    @ApiModelProperty(value = "巡检周期（月）")
    private Integer frequency;

    /**
     * 巡检子项内容描述
     */
    @ApiModelProperty(value = "巡检子项内容描述")
    private String description;

    /**
     * 巡检子项的巡检状态
     */
    @ApiModelProperty(value = "巡检子项的巡检状态")
    private Integer status;

    /**
     * 巡检子项的位置，纬度
     */
    @ApiModelProperty(value = "巡检子项的位置，纬度")
    private BigDecimal itemLatitude;

    /**
     * 巡检子项的位置，经度
     */
    @ApiModelProperty(value = "巡检子项的位置，经度")
    private BigDecimal itemLongitude;

    /**
     * 巡检子项结果描述
     */
    @ApiModelProperty(value = "巡检子项结果描述")
    private String result;

    /**
     * 巡检子项的名称
     */
    @ApiModelProperty(value = "巡检子项的名称")
    private String itemName;

    /**
     * 巡检子项对应的维修工
     */
    @ApiModelProperty(value = "巡检子项对应的维修工")
    private Long maintainerId;

}
