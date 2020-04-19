package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_mdc_form_instance")
public class MdcFormInstance {
    /**
     * 表单模板ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模板ID
     */
    @Column(name = "template_id")
    private Long templateId;

    /**
     * 巡检子项ID
     */
    @Column(name = "inspc_item_id")
    private Long inspcItemId;

    /**
     * 点位名称
     */
    @Column(name = "point_name")
    private String pointName;

    /**
     * 点位地址
     */
    @Column(name = "point_address")
    private String pointAddress;

    /**
     * 巡检单位ID
     */
    @Column(name = "inspc_company_id")
    private Long inspcCompanyId;

    /**
     * 巡检单位名称
     */
    @Column(name = "inspc_company")
    private String inspcCompany;

    /**
     * 巡检结论
     */
    @Column(name = "inspc_result")
    private String inspcResult;

    /**
     * 巡检日期
     */
    @Column(name = "inspc_date")
    private Date inspcDate;

    /**
     * 用户确认
     */
    @Column(name = "user_confirm")
    private String userConfirm;

    /**
     * 巡检工程师ID
     */
    @Column(name = "engineer_id")
    private Long engineerId;

    /**
     * 巡检工程师名称
     */
    private String engineer;

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
     * 获取模板ID
     *
     * @return template_id - 模板ID
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板ID
     *
     * @param templateId 模板ID
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取巡检子项ID
     *
     * @return inspc_item_id - 巡检子项ID
     */
    public Long getInspcItemId() {
        return inspcItemId;
    }

    /**
     * 设置巡检子项ID
     *
     * @param inspcItemId 巡检子项ID
     */
    public void setInspcItemId(Long inspcItemId) {
        this.inspcItemId = inspcItemId;
    }

    /**
     * 获取点位名称
     *
     * @return point_name - 点位名称
     */
    public String getPointName() {
        return pointName;
    }

    /**
     * 设置点位名称
     *
     * @param pointName 点位名称
     */
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    /**
     * 获取点位地址
     *
     * @return point_address - 点位地址
     */
    public String getPointAddress() {
        return pointAddress;
    }

    /**
     * 设置点位地址
     *
     * @param pointAddress 点位地址
     */
    public void setPointAddress(String pointAddress) {
        this.pointAddress = pointAddress;
    }

    /**
     * 获取巡检单位ID
     *
     * @return inspc_company_id - 巡检单位ID
     */
    public Long getInspcCompanyId() {
        return inspcCompanyId;
    }

    /**
     * 设置巡检单位ID
     *
     * @param inspcCompanyId 巡检单位ID
     */
    public void setInspcCompanyId(Long inspcCompanyId) {
        this.inspcCompanyId = inspcCompanyId;
    }

    /**
     * 获取巡检单位名称
     *
     * @return inspc_company - 巡检单位名称
     */
    public String getInspcCompany() {
        return inspcCompany;
    }

    /**
     * 设置巡检单位名称
     *
     * @param inspcCompany 巡检单位名称
     */
    public void setInspcCompany(String inspcCompany) {
        this.inspcCompany = inspcCompany;
    }

    /**
     * 获取巡检结论
     *
     * @return inspc_result - 巡检结论
     */
    public String getInspcResult() {
        return inspcResult;
    }

    /**
     * 设置巡检结论
     *
     * @param inspcResult 巡检结论
     */
    public void setInspcResult(String inspcResult) {
        this.inspcResult = inspcResult;
    }

    /**
     * 获取巡检日期
     *
     * @return inspc_date - 巡检日期
     */
    public Date getInspcDate() {
        return inspcDate;
    }

    /**
     * 设置巡检日期
     *
     * @param inspcDate 巡检日期
     */
    public void setInspcDate(Date inspcDate) {
        this.inspcDate = inspcDate;
    }

    /**
     * 获取用户确认
     *
     * @return user_confirm - 用户确认
     */
    public String getUserConfirm() {
        return userConfirm;
    }

    /**
     * 设置用户确认
     *
     * @param userConfirm 用户确认
     */
    public void setUserConfirm(String userConfirm) {
        this.userConfirm = userConfirm;
    }

    /**
     * 获取巡检工程师ID
     *
     * @return engineer_id - 巡检工程师ID
     */
    public Long getEngineerId() {
        return engineerId;
    }

    /**
     * 设置巡检工程师ID
     *
     * @param engineerId 巡检工程师ID
     */
    public void setEngineerId(Long engineerId) {
        this.engineerId = engineerId;
    }

    /**
     * 获取巡检工程师名称
     *
     * @return engineer - 巡检工程师名称
     */
    public String getEngineer() {
        return engineer;
    }

    /**
     * 设置巡检工程师名称
     *
     * @param engineer 巡检工程师名称
     */
    public void setEngineer(String engineer) {
        this.engineer = engineer;
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