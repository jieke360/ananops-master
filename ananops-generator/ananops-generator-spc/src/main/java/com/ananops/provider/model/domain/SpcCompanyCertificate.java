package com.ananops.provider.model.domain;

import javax.persistence.*;

@Table(name = "an_spc_company_certificate")
public class SpcCompanyCertificate {
    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 资质ID
     */
    @Column(name = "certificate_id")
    private Long certificateId;

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
     * 获取资质ID
     *
     * @return certificate_id - 资质ID
     */
    public Long getCertificateId() {
        return certificateId;
    }

    /**
     * 设置资质ID
     *
     * @param certificateId 资质ID
     */
    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }
}