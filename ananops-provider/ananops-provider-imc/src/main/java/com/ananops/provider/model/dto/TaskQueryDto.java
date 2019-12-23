package com.ananops.provider.model.dto;

import com.ananops.base.dto.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by rongshuai on 2019/12/22 12:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class TaskQueryDto extends BaseQuery {
    private static final long serialVersionUID = 8091137737261631366L;

    /**
     * 巡检任务对应的状态
     */
    @ApiModelProperty(value = "巡检任务对应的状态")
    private Integer status;

    /**
     * 巡检任务对应的甲方用户id
     */
    @ApiModelProperty(value = "巡检任务对应的甲方用户ID")
    private Long userId;

    /**
     * 巡检任务对应的项目id
     */
    @ApiModelProperty(value = "巡检任务对应的项目ID")
    private Long projectId;

    /**
     * 巡检任务对应的服务商id
     */
    @ApiModelProperty(value = "巡检任务对应的服务商ID")
    private Long facilitatorId;

}
