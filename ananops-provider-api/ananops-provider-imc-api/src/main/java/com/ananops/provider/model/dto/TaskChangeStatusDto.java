package com.ananops.provider.model.dto;

import com.ananops.base.dto.LoginAuthDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/1/4 11:00
 */
@Data
@ApiModel
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TaskChangeStatusDto implements Serializable {
    private static final long serialVersionUID = 7518743322967534899L;
    /**
     * 巡检任务ID
     */
    @ApiModelProperty(value = "巡检任务ID")
    private Long taskId;

    /**
     * 修改后的状态
     */
    @ApiModelProperty(value = "修改后的状态")
    private Integer status;

    /**
     * 巡检任务修改后的状态描述
     */
    @ApiModelProperty(value = "巡检任务修改后的状态描述")
    private String statusMsg;

    /**
     * 当前操作用户的身份信息
     */
    @ApiModelProperty(value = "当前操作用户的LoginAuthDto")
    private LoginAuthDto loginAuthDto;
}
