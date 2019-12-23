package com.ananops.provider.model.dto;

import com.ananops.base.dto.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class MdmcStatusDto extends BaseQuery {

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("甲方id")
    private Long principalId;

    @ApiModelProperty("服务商id")
    private Long facilitatorId;

    @ApiModelProperty("维修工id")
    private Long maintainerId;

    @ApiModelProperty("工单id")
    private Long taskId;


}
