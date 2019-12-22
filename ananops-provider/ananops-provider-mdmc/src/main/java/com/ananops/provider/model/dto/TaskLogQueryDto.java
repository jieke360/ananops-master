package com.ananops.provider.model.dto;

import com.ananops.base.dto.BaseQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by rongshuai on 2019/11/28 20:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class TaskLogQueryDto extends BaseQuery {

    /**
     * 巡检任务Id
     */
    private Long taskId;
}
