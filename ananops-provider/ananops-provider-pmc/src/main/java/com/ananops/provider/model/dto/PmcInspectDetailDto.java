package com.ananops.provider.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created By ChengHao On 2019/12/23
 */
@Data
@ApiModel
public class PmcInspectDetailDto implements Serializable {
    private static final long serialVersionUID = -8846828692852324246L;

    @ApiModelProperty(value = "巡检详情id")
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "巡检详情名称")
    private String name;

    /**
     * 巡检任务ID
     */
    @ApiModelProperty(value = "巡检任务ID")
    private Long inspectTaskId;

    /**
     * 巡检网点
     */
    @ApiModelProperty(value = "巡检网点")
    private String inspectWebsite;

    /**
     * 巡检人员
     */
    @ApiModelProperty(value = "巡检人员")
    private String inspectPerson;

    /**
     * 巡检设备
     */
    @ApiModelProperty(value = "巡检设备")
    private String inspectDevice;

    /**
     * 巡检情况
     */
    @ApiModelProperty(value = "巡检情况")
    private String inspectCondition;

    /**
     * 处理结果
     */
    @ApiModelProperty(value = "处理结果")
    private String dealResult;

    /**
     * 描述
     */
    private String description;

    /**
     * 预留字段
     */
    @ApiModelProperty(value = "预留字段")
    private String backup;

}
