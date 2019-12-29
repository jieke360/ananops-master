package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_spc_company")
public class SpcCompany {
    /**
     * 公司id，主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组织id，主键
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 法人姓名
     */
    @Column(name = "legal_person_name")
    private String legalPersonName;

    /**
     * 法人联系方式
     */
    @Column(name = "legal_person_phone")
    private String legalPersonPhone;

    /**
     * 法人身份证号
     */
    @Column(name = "legal_person_number")
    private String legalPersonNumber;

    /**
     * 主体行业
     */
    @Column(name = "main_work")
    private String mainWork;

    /**
     * 国家地区
     */
    private String country;

    /**
     * 邮政编码
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 基本户账户名称
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 基本账户账号
     */
    @Column(name = "account_number")
    private String accountNumber;

    /**
     * 营业执照类别
     */
    @Column(name = "license_type")
    private String licenseType;

    /**
     * 注册资本
     */
    @Column(name = "registered_captial")
    private String registeredCaptial;

    /**
     * 有效期
     */
    @Column(name = "expiration_date")
    private Date expirationDate;

    /**
     * 经营范围
     */
    @Column(name = "business_scope")
    private String businessScope;

    /**
     * 供应产品类别
     */
    @Column(name = "product_category")
    private String productCategory;

    /**
     * 法人身份证照片url
     */
    @Column(name = "legal_personId_photo")
    private String legalPersonidPhoto;

    /**
     * 营业执照照片url
     */
    @Column(name = "business_license_photo")
    private String businessLicensePhoto;

    /**
     * 账户开户许可证照片url
     */
    @Column(name = "account_opening_license")
    private String accountOpeningLicense;

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
     * 获取公司id，主键
     *
     * @return id - 公司id，主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置公司id，主键
     *
     * @param id 公司id，主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组织id，主键
     *
     * @return group_id - 组织id，主键
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置组织id，主键
     *
     * @param groupId 组织id，主键
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取法人姓名
     *
     * @return legal_person_name - 法人姓名
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人姓名
     *
     * @param legalPersonName 法人姓名
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    /**
     * 获取法人联系方式
     *
     * @return legal_person_phone - 法人联系方式
     */
    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    /**
     * 设置法人联系方式
     *
     * @param legalPersonPhone 法人联系方式
     */
    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }

    /**
     * 获取法人身份证号
     *
     * @return legal_person_number - 法人身份证号
     */
    public String getLegalPersonNumber() {
        return legalPersonNumber;
    }

    /**
     * 设置法人身份证号
     *
     * @param legalPersonNumber 法人身份证号
     */
    public void setLegalPersonNumber(String legalPersonNumber) {
        this.legalPersonNumber = legalPersonNumber;
    }

    /**
     * 获取主体行业
     *
     * @return main_work - 主体行业
     */
    public String getMainWork() {
        return mainWork;
    }

    /**
     * 设置主体行业
     *
     * @param mainWork 主体行业
     */
    public void setMainWork(String mainWork) {
        this.mainWork = mainWork;
    }

    /**
     * 获取国家地区
     *
     * @return country - 国家地区
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家地区
     *
     * @param country 国家地区
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取邮政编码
     *
     * @return zip_code - 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取基本户账户名称
     *
     * @return account_name - 基本户账户名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置基本户账户名称
     *
     * @param accountName 基本户账户名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 获取基本账户账号
     *
     * @return account_number - 基本账户账号
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 设置基本账户账号
     *
     * @param accountNumber 基本账户账号
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 获取营业执照类别
     *
     * @return license_type - 营业执照类别
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * 设置营业执照类别
     *
     * @param licenseType 营业执照类别
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * 获取注册资本
     *
     * @return registered_captial - 注册资本
     */
    public String getRegisteredCaptial() {
        return registeredCaptial;
    }

    /**
     * 设置注册资本
     *
     * @param registeredCaptial 注册资本
     */
    public void setRegisteredCaptial(String registeredCaptial) {
        this.registeredCaptial = registeredCaptial;
    }

    /**
     * 获取有效期
     *
     * @return expiration_date - 有效期
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * 设置有效期
     *
     * @param expirationDate 有效期
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 获取经营范围
     *
     * @return business_scope - 经营范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * 设置经营范围
     *
     * @param businessScope 经营范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * 获取供应产品类别
     *
     * @return product_category - 供应产品类别
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * 设置供应产品类别
     *
     * @param productCategory 供应产品类别
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * 获取法人身份证照片url
     *
     * @return legal_personId_photo - 法人身份证照片url
     */
    public String getLegalPersonidPhoto() {
        return legalPersonidPhoto;
    }

    /**
     * 设置法人身份证照片url
     *
     * @param legalPersonidPhoto 法人身份证照片url
     */
    public void setLegalPersonidPhoto(String legalPersonidPhoto) {
        this.legalPersonidPhoto = legalPersonidPhoto;
    }

    /**
     * 获取营业执照照片url
     *
     * @return business_license_photo - 营业执照照片url
     */
    public String getBusinessLicensePhoto() {
        return businessLicensePhoto;
    }

    /**
     * 设置营业执照照片url
     *
     * @param businessLicensePhoto 营业执照照片url
     */
    public void setBusinessLicensePhoto(String businessLicensePhoto) {
        this.businessLicensePhoto = businessLicensePhoto;
    }

    /**
     * 获取账户开户许可证照片url
     *
     * @return account_opening_license - 账户开户许可证照片url
     */
    public String getAccountOpeningLicense() {
        return accountOpeningLicense;
    }

    /**
     * 设置账户开户许可证照片url
     *
     * @param accountOpeningLicense 账户开户许可证照片url
     */
    public void setAccountOpeningLicense(String accountOpeningLicense) {
        this.accountOpeningLicense = accountOpeningLicense;
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