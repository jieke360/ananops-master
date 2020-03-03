package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 加盟服务商
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "an_bmc_bill")
public class BmcBill extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2853449914001346057L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "transaction_method")
    private String transactionMethod;

    private Float amount;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    private Long supplier;

    @Column(name = "supplier_name")
    private String supplierName;

    private Long time;

    @Column(name = "work_order_id")
    private Long workOrderId;

    private String state;

    @Column(name = "device_amount")
    private Float deviceAmount;

    @Column(name = "service_amount")
    private Float serviceAmount;

    private Integer version;

    private String creator;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "last_operator")
    private String lastOperator;

    @Column(name = "last_operator_id")
    private Long lastOperatorId;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return payment_method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return transaction_method
     */
    public String getTransactionMethod() {
        return transactionMethod;
    }

    /**
     * @param transactionMethod
     */
    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    /**
     * @return amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return supplier
     */
    public Long getSupplier() {
        return supplier;
    }

    /**
     * @param supplier
     */
    public void setSupplier(Long supplier) {
        this.supplier = supplier;
    }

    /**
     * @return supplier_name
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return time
     */
    public Long getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * @return work_order_id
     */
    public Long getWorkOrderId() {
        return workOrderId;
    }

    /**
     * @param workOrderId
     */
    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return device_amount
     */
    public Float getDeviceAmount() {
        return deviceAmount;
    }

    /**
     * @param deviceAmount
     */
    public void setDeviceAmount(Float deviceAmount) {
        this.deviceAmount = deviceAmount;
    }

    /**
     * @return service_amount
     */
    public Float getServiceAmount() {
        return serviceAmount;
    }

    /**
     * @param serviceAmount
     */
    public void setServiceAmount(Float serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return creator_id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return last_operator
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * @param lastOperator
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * @return last_operator_id
     */
    public Long getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * @param lastOperatorId
     */
    public void setLastOperatorId(Long lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}