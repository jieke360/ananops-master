package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_spc_performance")
public class SpcPerformance {
    /**
     * Id主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 交易类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 工程地点
     */
    @Column(name = "project_location")
    private String projectLocation;

    /**
     * 项目负责人姓名
     */
    @Column(name = "project_principal")
    private String projectPrincipal;

    /**
     * 项目负责人身份证号码
     */
    @Column(name = "project_principal_number")
    private String projectPrincipalNumber;

    /**
     * 项目技术负责人姓名
     */
    @Column(name = "project_tech_pr")
    private String projectTechPr;

    /**
     * 项目技术负责人身份证号码
     */
    @Column(name = "project_tech_pr_number")
    private String projectTechPrNumber;

    /**
     * 工程描述
     */
    @Column(name = "project_desc")
    private String projectDesc;

    /**
     * 竣工日期
     */
    @Column(name = "project_finish")
    private Date projectFinish;

    /**
     * 业主名称
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 中标通知书编号
     */
    @Column(name = "bid_number")
    private String bidNumber;

    /**
     * 中标金额（万元）
     */
    @Column(name = "bid_amount")
    private String bidAmount;

    /**
     * 中标通知书url
     */
    @Column(name = "bid_photo")
    private String bidPhoto;

    /**
     * 合同主页url
     */
    @Column(name = "project_contract")
    private String projectContract;

    /**
     * 竣工验收报告url
     */
    @Column(name = "project_finish_report")
    private String projectFinishReport;

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
     * 最近操作人
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
     * 获取Id主键
     *
     * @return id - Id主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置Id主键
     *
     * @param id Id主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取交易类型
     *
     * @return project_type - 交易类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置交易类型
     *
     * @param projectType 交易类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * 获取工程地点
     *
     * @return project_location - 工程地点
     */
    public String getProjectLocation() {
        return projectLocation;
    }

    /**
     * 设置工程地点
     *
     * @param projectLocation 工程地点
     */
    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    /**
     * 获取项目负责人姓名
     *
     * @return project_principal - 项目负责人姓名
     */
    public String getProjectPrincipal() {
        return projectPrincipal;
    }

    /**
     * 设置项目负责人姓名
     *
     * @param projectPrincipal 项目负责人姓名
     */
    public void setProjectPrincipal(String projectPrincipal) {
        this.projectPrincipal = projectPrincipal;
    }

    /**
     * 获取项目负责人身份证号码
     *
     * @return project_principal_number - 项目负责人身份证号码
     */
    public String getProjectPrincipalNumber() {
        return projectPrincipalNumber;
    }

    /**
     * 设置项目负责人身份证号码
     *
     * @param projectPrincipalNumber 项目负责人身份证号码
     */
    public void setProjectPrincipalNumber(String projectPrincipalNumber) {
        this.projectPrincipalNumber = projectPrincipalNumber;
    }

    /**
     * 获取项目技术负责人姓名
     *
     * @return project_tech_pr - 项目技术负责人姓名
     */
    public String getProjectTechPr() {
        return projectTechPr;
    }

    /**
     * 设置项目技术负责人姓名
     *
     * @param projectTechPr 项目技术负责人姓名
     */
    public void setProjectTechPr(String projectTechPr) {
        this.projectTechPr = projectTechPr;
    }

    /**
     * 获取项目技术负责人身份证号码
     *
     * @return project_tech_pr_number - 项目技术负责人身份证号码
     */
    public String getProjectTechPrNumber() {
        return projectTechPrNumber;
    }

    /**
     * 设置项目技术负责人身份证号码
     *
     * @param projectTechPrNumber 项目技术负责人身份证号码
     */
    public void setProjectTechPrNumber(String projectTechPrNumber) {
        this.projectTechPrNumber = projectTechPrNumber;
    }

    /**
     * 获取工程描述
     *
     * @return project_desc - 工程描述
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * 设置工程描述
     *
     * @param projectDesc 工程描述
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    /**
     * 获取竣工日期
     *
     * @return project_finish - 竣工日期
     */
    public Date getProjectFinish() {
        return projectFinish;
    }

    /**
     * 设置竣工日期
     *
     * @param projectFinish 竣工日期
     */
    public void setProjectFinish(Date projectFinish) {
        this.projectFinish = projectFinish;
    }

    /**
     * 获取业主名称
     *
     * @return customer_name - 业主名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置业主名称
     *
     * @param customerName 业主名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取中标通知书编号
     *
     * @return bid_number - 中标通知书编号
     */
    public String getBidNumber() {
        return bidNumber;
    }

    /**
     * 设置中标通知书编号
     *
     * @param bidNumber 中标通知书编号
     */
    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
    }

    /**
     * 获取中标金额（万元）
     *
     * @return bid_amount - 中标金额（万元）
     */
    public String getBidAmount() {
        return bidAmount;
    }

    /**
     * 设置中标金额（万元）
     *
     * @param bidAmount 中标金额（万元）
     */
    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    /**
     * 获取中标通知书url
     *
     * @return bid_photo - 中标通知书url
     */
    public String getBidPhoto() {
        return bidPhoto;
    }

    /**
     * 设置中标通知书url
     *
     * @param bidPhoto 中标通知书url
     */
    public void setBidPhoto(String bidPhoto) {
        this.bidPhoto = bidPhoto;
    }

    /**
     * 获取合同主页url
     *
     * @return project_contract - 合同主页url
     */
    public String getProjectContract() {
        return projectContract;
    }

    /**
     * 设置合同主页url
     *
     * @param projectContract 合同主页url
     */
    public void setProjectContract(String projectContract) {
        this.projectContract = projectContract;
    }

    /**
     * 获取竣工验收报告url
     *
     * @return project_finish_report - 竣工验收报告url
     */
    public String getProjectFinishReport() {
        return projectFinishReport;
    }

    /**
     * 设置竣工验收报告url
     *
     * @param projectFinishReport 竣工验收报告url
     */
    public void setProjectFinishReport(String projectFinishReport) {
        this.projectFinishReport = projectFinishReport;
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
     * 获取最近操作人
     *
     * @return last_operator - 最近操作人
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * 设置最近操作人
     *
     * @param lastOperator 最近操作人
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