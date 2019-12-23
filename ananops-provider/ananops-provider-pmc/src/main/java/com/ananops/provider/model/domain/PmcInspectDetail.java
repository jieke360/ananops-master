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
    @Column(name = "inspect_task_id")
    private Long inspectTaskId;

    /**
     * 巡检网点
     */
    @Column(name = "inspect_website")
    private String inspectWebsite;

    /**
     * 巡检人员
     */
    @Column(name = "inspect_person")
    private String inspectPerson;

    /**
     * 巡检设备
     */
    @Column(name = "inspect_device")
    private String inspectDevice;

    /**
     * 巡检情况
     */
    @Column(name = "inspect_condition")
    private String inspectCondition;

    /**
     * 处理结果
     */
    @Column(name = "deal_result")
    private String dealResult;

    /**
     * 描述
     */
    private String description;

    /**
     * 预留字段
     */
    private String backup;



}