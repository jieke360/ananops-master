package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "an_pmc_project")
@Data
public class PmcProject extends BaseEntity {
    /**
     * 合同id
     */
    @Column(name = "contract_id")
    private Long contractId;

    /**
     * 合同名称
     */
    @Column(name = "contract_name")
    private String contractName;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 是否签署合同（0-没有，1-有，没有签署合同的未虚拟项目）
     */
    @Column(name = "is_contract")
    private Integer isContract;

    /**
     * 甲方id
     */
    @Column(name = "party_a_id")
    private Long partyAId;

    /**
     * 甲方名称
     */
    @Column(name = "party_a_name")
    private String partyAName;

    /**
     * 乙方id
     */
    @Column(name = "party_b_id")
    private Long partyBId;

    /**
     * 乙方名称
     */
    @Column(name = "party_b_name")
    private String partyBName;

    /**
     * 联系人1姓名
     */
    @Column(name = "a_one_name")
    private String aOneName;

    /**
     * 甲方项目负责人联系方式1
     */
    @Column(name = "party_a_one")
    private String partyAOne;

    /**
     * 联系人2姓名
     */
    @Column(name = "a_two_name")
    private String aTwoName;

    /**
     * 甲方项目负责人联系方式2
     */
    @Column(name = "party_a_two")
    private String partyATwo;

    /**
     * 联系人3姓名
     */
    @Column(name = "a_three_name")
    private String aThreeName;

    /**
     * 甲方项目负责人联系方式3
     */
    @Column(name = "party_a_three")
    private String partyAThree;

    /**
     * 乙方项目负责人
     */
    @Column(name = "b_name")
    private String bName;

    /**
     * 乙方负责人电话
     */
    @Column(name = "party_b_one")
    private String partyBOne;

    /**
     * 乙方24小时值班电话
     */
    @Column(name = "party_b_tel")
    private String partyBTel;

    /**
     * 乙方24小时开通的移动电话
     */
    @Column(name = "party_b_phone")
    private String partyBPhone;

    /**
     * 乙方24小时开通邮箱
     */
    @Column(name = "party_b_email")
    private String partyBEmail;

    /**
     * 开始时间（虚拟项目必填）
     */
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束时间（虚拟项目必填
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 项目是否作废（0-有效，1-作废）
     */
    @Column(name = "is_destory")
    private Integer isDestory;

    /**
     * 描述
     */
    private String description;

}