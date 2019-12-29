package com.ananops.provider.model.domain;

import javax.persistence.*;

@Table(name = "an_spc_engineer_certificate")
public class SpcEngineerCertificate {
    /**
     * 工程师ID
     */
    @Column(name = "engineer_id")
    private Long engineerId;

    /**
     * 资质证书ID
     */
    @Column(name = "certificate_id")
    private Long certificateId;

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
     * 获取资质证书ID
     *
     * @return certificate_id - 资质证书ID
     */
    public Long getCertificateId() {
        return certificateId;
    }

    /**
     * 设置资质证书ID
     *
     * @param certificateId 资质证书ID
     */
    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }
}