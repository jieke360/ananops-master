package com.ananops.provider.model.domain;

import javax.persistence.*;

@Table(name = "an_spc_company_engineer")
public class SpcCompanyEngineer {
    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 工程师ID
     */
    @Column(name = "engineer_id")
    private Long engineerId;

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
}