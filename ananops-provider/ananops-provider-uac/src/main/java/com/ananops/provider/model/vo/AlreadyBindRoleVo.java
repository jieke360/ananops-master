package com.ananops.provider.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created By ChengHao On 2020/1/14
 */
@Data
@ApiModel(value = "角色绑定用户")
public class AlreadyBindRoleVo implements Serializable {

    private static final long serialVersionUID = -5744438409787917207L;

    @ApiModelProperty(value = "用户ID")
    private Long roleId;

    private Long key;
}
