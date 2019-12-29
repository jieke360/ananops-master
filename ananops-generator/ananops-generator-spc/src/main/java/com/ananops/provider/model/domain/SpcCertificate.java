package com.ananops.provider.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "an_spc_certificate")
public class SpcCertificate {
    /**
     * Id主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资格证书编号
     */
    @Column(name = "ce_number")
    private String ceNumber;

    /**
     * 资格证书类型
     */
    @Column(name = "ce_type")
    private String ceType;

    /**
     * 资格证书等级
     */
    @Column(name = "ce_degree")
    private String ceDegree;

    /**
     * 资格证书发放日期
     */
    @Column(name = "ce_first_time")
    private Date ceFirstTime;

    /**
     * 有效期限
     */
    @Column(name = "ce_expiration_date")
    private Date ceExpirationDate;

    /**
     * 发放资格证书单位
     */
    @Column(name = "ce_authority")
    private String ceAuthority;

    /**
     * 资格证书照片url
     */
    @Column(name = "ce_photo")
    private String cePhoto;

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
     * 获取资格证书编号
     *
     * @return ce_number - 资格证书编号
     */
    public String getCeNumber() {
        return ceNumber;
    }

    /**
     * 设置资格证书编号
     *
     * @param ceNumber 资格证书编号
     */
    public void setCeNumber(String ceNumber) {
        this.ceNumber = ceNumber;
    }

    /**
     * 获取资格证书类型
     *
     * @return ce_type - 资格证书类型
     */
    public String getCeType() {
        return ceType;
    }

    /**
     * 设置资格证书类型
     *
     * @param ceType 资格证书类型
     */
    public void setCeType(String ceType) {
        this.ceType = ceType;
    }

    /**
     * 获取资格证书等级
     *
     * @return ce_degree - 资格证书等级
     */
    public String getCeDegree() {
        return ceDegree;
    }

    /**
     * 设置资格证书等级
     *
     * @param ceDegree 资格证书等级
     */
    public void setCeDegree(String ceDegree) {
        this.ceDegree = ceDegree;
    }

    /**
     * 获取资格证书发放日期
     *
     * @return ce_first_time - 资格证书发放日期
     */
    public Date getCeFirstTime() {
        return ceFirstTime;
    }

    /**
     * 设置资格证书发放日期
     *
     * @param ceFirstTime 资格证书发放日期
     */
    public void setCeFirstTime(Date ceFirstTime) {
        this.ceFirstTime = ceFirstTime;
    }

    /**
     * 获取有效期限
     *
     * @return ce_expiration_date - 有效期限
     */
    public Date getCeExpirationDate() {
        return ceExpirationDate;
    }

    /**
     * 设置有效期限
     *
     * @param ceExpirationDate 有效期限
     */
    public void setCeExpirationDate(Date ceExpirationDate) {
        this.ceExpirationDate = ceExpirationDate;
    }

    /**
     * 获取发放资格证书单位
     *
     * @return ce_authority - 发放资格证书单位
     */
    public String getCeAuthority() {
        return ceAuthority;
    }

    /**
     * 设置发放资格证书单位
     *
     * @param ceAuthority 发放资格证书单位
     */
    public void setCeAuthority(String ceAuthority) {
        this.ceAuthority = ceAuthority;
    }

    /**
     * 获取资格证书照片url
     *
     * @return ce_photo - 资格证书照片url
     */
    public String getCePhoto() {
        return cePhoto;
    }

    /**
     * 设置资格证书照片url
     *
     * @param cePhoto 资格证书照片url
     */
    public void setCePhoto(String cePhoto) {
        this.cePhoto = cePhoto;
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