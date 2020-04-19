package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_mdc_form_instance_device")
public class MdcFormInstanceDevice {
    /**
     * 表单模板ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 实例ID
     */
    @Column(name = "instace_id")
    private Long instaceId;

    /**
     * 设备状态描述
     */
    private String content;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 最后操作人
     */
    @Column(name = "last_operator")
    private String lastOperator;

    /**
     * 最后操作人ID
     */
    @Column(name = "last_operator_id")
    private Long lastOperatorId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取表单模板ID
     *
     * @return id - 表单模板ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置表单模板ID
     *
     * @param id 表单模板ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取实例ID
     *
     * @return instace_id - 实例ID
     */
    public Long getInstaceId() {
        return instaceId;
    }

    /**
     * 设置实例ID
     *
     * @param instaceId 实例ID
     */
    public void setInstaceId(Long instaceId) {
        this.instaceId = instaceId;
    }

    /**
     * 获取设备状态描述
     *
     * @return content - 设备状态描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置设备状态描述
     *
     * @param content 设备状态描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建人ID
     *
     * @return creator_id - 创建人ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人ID
     *
     * @param creatorId 创建人ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取最后操作人
     *
     * @return last_operator - 最后操作人
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * 设置最后操作人
     *
     * @param lastOperator 最后操作人
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * 获取最后操作人ID
     *
     * @return last_operator_id - 最后操作人ID
     */
    public Long getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * 设置最后操作人ID
     *
     * @param lastOperatorId 最后操作人ID
     */
    public void setLastOperatorId(Long lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}