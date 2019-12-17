package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "an_pmc_inspect_task")
@Data
public class PmcInspectTask extends BaseEntity {

    /**
     * 项目id
     */
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 任务名称
     */
    @Column(name = "task_name")
    private String taskName;

    /**
     * 任务类型
     */
    @Column(name = "task_type")
    private String taskType;

    /**
     * 巡检内容
     */
    @Column(name = "inspection_content")
    private String inspectionContent;

    /**
     * 巡检情况
     */
    @Column(name = "inspection_condition")
    private String inspectionCondition;

    /**
     * 处理结果
     */
    @Column(name = "deal_result")
    private String dealResult;

    /**
     * 巡检周期，单位天
     */
    @Column(name = "cycle_time")
    private Integer cycleTime;

    /**
     * 预计开始时间
     */
    @Column(name = "scheduled_start_time")
    private Date scheduledStartTime;

    /**
     * 最晚开始时间
     */
    @Column(name = "deadline_time")
    private Date deadlineTime;

    /**
     * 计划完成时间，单位天
     */
    @Column(name = "scheduled_finish_time")
    private Integer scheduledFinishTime;

    /**
     * 是否立即执行，0-否，1-是
     */
    @Column(name = "is_now")
    private Integer isNow;

    /**
     * 描述
     */
    private String description;

}