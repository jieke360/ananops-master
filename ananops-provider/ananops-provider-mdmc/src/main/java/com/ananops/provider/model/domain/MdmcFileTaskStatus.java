package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;

import javax.persistence.*;

@Table(name = "an_mdmc_file_task_status")
public class MdmcFileTaskStatus extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private Integer status;

    @Column(name = "attachment_id")
    private Long attachmentId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return attachment_id
     */
    public Long getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId
     */
    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
}