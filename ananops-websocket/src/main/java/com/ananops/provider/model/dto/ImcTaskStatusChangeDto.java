package com.ananops.provider.model.dto;

import com.ananops.base.dto.LoginAuthDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/2/21 15:09
 */
@Data
public class ImcTaskStatusChangeDto implements Serializable {
    private static final long serialVersionUID = -6023020658406411069L;

    /**
     * 巡检任务ID
     */
    private Long taskId;

    /**
     * 修改后的状态
     */
    private Integer status;

    /**
     * 巡检任务修改后的状态描述
     */
    private String statusMsg;

    /**
     * 当前操作用户的身份信息
     */
    private LoginAuthDto loginAuthDto;
}
