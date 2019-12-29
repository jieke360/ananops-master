package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_spc_engineer")
public class SpcEngineer {
    /**
     * Id主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * UAC用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 所在省市
     */
    private String location;

    /**
     * 身份证号码
     */
    @Column(name = "identity_number")
    private String identityNumber;

    /**
     * 身份证有效期
     */
    @Column(name = "identity_expiration_date")
    private Date identityExpirationDate;

    /**
     * 职务
     */
    private String position;

    /**
     * 职称
     */
    private String title;

    /**
     * 学历
     */
    private String education;

    /**
     * 从业开始时间
     */
    @Column(name = "employment_start_time")
    private Date employmentStartTime;

    /**
     * 工程师身份证照片url
     */
    @Column(name = "identity_photo")
    private String identityPhoto;

    /**
     * 职称证书编号
     */
    @Column(name = "title_ce_number")
    private String titleCeNumber;

    /**
     * 职称证书发放日期
     */
    @Column(name = "title_ce_time")
    private Date titleCeTime;

    /**
     * 发放职称证书单位
     */
    @Column(name = "title_ce_authority")
    private String titleCeAuthority;

    /**
     * 职称证书照片url
     */
    @Column(name = "title_ce_photo")
    private String titleCePhoto;

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
    @Column(name = "creator_time")
    private Date creatorTime;

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
     * 获取UAC用户ID
     *
     * @return user_id - UAC用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置UAC用户ID
     *
     * @param userId UAC用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取所在省市
     *
     * @return location - 所在省市
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所在省市
     *
     * @param location 所在省市
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取身份证号码
     *
     * @return identity_number - 身份证号码
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * 设置身份证号码
     *
     * @param identityNumber 身份证号码
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * 获取身份证有效期
     *
     * @return identity_expiration_date - 身份证有效期
     */
    public Date getIdentityExpirationDate() {
        return identityExpirationDate;
    }

    /**
     * 设置身份证有效期
     *
     * @param identityExpirationDate 身份证有效期
     */
    public void setIdentityExpirationDate(Date identityExpirationDate) {
        this.identityExpirationDate = identityExpirationDate;
    }

    /**
     * 获取职务
     *
     * @return position - 职务
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职务
     *
     * @param position 职务
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取职称
     *
     * @return title - 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职称
     *
     * @param title 职称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取从业开始时间
     *
     * @return employment_start_time - 从业开始时间
     */
    public Date getEmploymentStartTime() {
        return employmentStartTime;
    }

    /**
     * 设置从业开始时间
     *
     * @param employmentStartTime 从业开始时间
     */
    public void setEmploymentStartTime(Date employmentStartTime) {
        this.employmentStartTime = employmentStartTime;
    }

    /**
     * 获取工程师身份证照片url
     *
     * @return identity_photo - 工程师身份证照片url
     */
    public String getIdentityPhoto() {
        return identityPhoto;
    }

    /**
     * 设置工程师身份证照片url
     *
     * @param identityPhoto 工程师身份证照片url
     */
    public void setIdentityPhoto(String identityPhoto) {
        this.identityPhoto = identityPhoto;
    }

    /**
     * 获取职称证书编号
     *
     * @return title_ce_number - 职称证书编号
     */
    public String getTitleCeNumber() {
        return titleCeNumber;
    }

    /**
     * 设置职称证书编号
     *
     * @param titleCeNumber 职称证书编号
     */
    public void setTitleCeNumber(String titleCeNumber) {
        this.titleCeNumber = titleCeNumber;
    }

    /**
     * 获取职称证书发放日期
     *
     * @return title_ce_time - 职称证书发放日期
     */
    public Date getTitleCeTime() {
        return titleCeTime;
    }

    /**
     * 设置职称证书发放日期
     *
     * @param titleCeTime 职称证书发放日期
     */
    public void setTitleCeTime(Date titleCeTime) {
        this.titleCeTime = titleCeTime;
    }

    /**
     * 获取发放职称证书单位
     *
     * @return title_ce_authority - 发放职称证书单位
     */
    public String getTitleCeAuthority() {
        return titleCeAuthority;
    }

    /**
     * 设置发放职称证书单位
     *
     * @param titleCeAuthority 发放职称证书单位
     */
    public void setTitleCeAuthority(String titleCeAuthority) {
        this.titleCeAuthority = titleCeAuthority;
    }

    /**
     * 获取职称证书照片url
     *
     * @return title_ce_photo - 职称证书照片url
     */
    public String getTitleCePhoto() {
        return titleCePhoto;
    }

    /**
     * 设置职称证书照片url
     *
     * @param titleCePhoto 职称证书照片url
     */
    public void setTitleCePhoto(String titleCePhoto) {
        this.titleCePhoto = titleCePhoto;
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
     * @return creator_time - 创建时间
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 设置创建时间
     *
     * @param creatorTime 创建时间
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
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