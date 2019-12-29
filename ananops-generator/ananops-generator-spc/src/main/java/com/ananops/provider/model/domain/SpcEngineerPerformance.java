package com.ananops.provider.model.domain;

import javax.persistence.*;

@Table(name = "an_spc_engineer_performance")
public class SpcEngineerPerformance {
    /**
     * 工程师ID
     */
    @Column(name = "engineer_id")
    private Long engineerId;

    /**
     * 业绩ID
     */
    @Column(name = "performance_id")
    private Long performanceId;

    /**
     * 获取工程师ID
     *
     * @return engineer_id - 工程师ID
     */
    public Long getEngineerId() {
        return engineerId;
    }

    /**
     * 设置工程师ID
     *
     * @param engineerId 工程师ID
     */
    public void setEngineerId(Long engineerId) {
        this.engineerId = engineerId;
    }

    /**
     * 获取业绩ID
     *
     * @return performance_id - 业绩ID
     */
    public Long getPerformanceId() {
        return performanceId;
    }

    /**
     * 设置业绩ID
     *
     * @param performanceId 业绩ID
     */
    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }
}