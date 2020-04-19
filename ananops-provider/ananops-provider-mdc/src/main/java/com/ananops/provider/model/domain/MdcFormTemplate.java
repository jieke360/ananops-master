package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_mdc_form_template")
public class MdcFormTemplate {
    /**
     * 表单模板ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Schema ID
     */
    @Column(name = "schema_id")
    private Long schemaId;

    /**
     * 表单类型（system/user）
     */
    private String type;

    /**
     * 表单状态
     */
    private String status;

    /**
     * 表单备注说明
     */
    private String mark;

    /**
     * 公司组织ID
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 关联的项目ID
     */
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 逻辑删除
     */
    private String dr;

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
     * 获取Schema ID
     *
     * @return schema_id - Schema ID
     */
    public Long getSchemaId() {
        return schemaId;
    }

    /**
     * 设置Schema ID
     *
     * @param schemaId Schema ID
     */
    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * 获取表单类型（system/user）
     *
     * @return type - 表单类型（system/user）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置表单类型（system/user）
     *
     * @param type 表单类型（system/user）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取表单状态
     *
     * @return status - 表单状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置表单状态
     *
     * @param status 表单状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取表单备注说明
     *
     * @return mark - 表单备注说明
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置表单备注说明
     *
     * @param mark 表单备注说明
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取公司组织ID
     *
     * @return group_id - 公司组织ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置公司组织ID
     *
     * @param groupId 公司组织ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取关联的项目ID
     *
     * @return project_id - 关联的项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置关联的项目ID
     *
     * @param projectId 关联的项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取逻辑删除
     *
     * @return dr - 逻辑删除
     */
    public String getDr() {
        return dr;
    }

    /**
     * 设置逻辑删除
     *
     * @param dr 逻辑删除
     */
    public void setDr(String dr) {
        this.dr = dr;
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