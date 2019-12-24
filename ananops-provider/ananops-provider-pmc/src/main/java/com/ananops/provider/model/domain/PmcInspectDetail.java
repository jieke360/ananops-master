package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "an_pmc_inspect_detail")
@Data
public class PmcInspectDetail extends BaseEntity {
    /**
     * 名称
     */
    private String name;

    /**
     * 巡检任务ID
     */
    @Column(name = "inspection_task_id")
    private Long inspectionTaskId;

    /**
     * 巡检任务名称
     */
    @Column(name = "inspection_task_name")
    private String inspectionTaskName;

    /**
     * 巡检网点
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 维修工id
     */
    @Column(name = "maintainer_id")
    private Long maintainerId;

    /**
     * 维修工名称
     */
    @Column(name = "maintainer_name")
    private String maintainerName;

    /**
     * 巡检内容描述
     */
    private String description;

    /**
     * 巡检结果
     */
    private String result;

    /**
     * 巡检状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;


}