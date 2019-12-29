package com.ananops.provider.model.domain;

import javax.persistence.*;

@Table(name = "an_spc_company_performance")
public class SpcCompanyPerformance {
    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 业绩ID
     */
    @Column(name = "performance_id")
    private Long performanceId;

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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