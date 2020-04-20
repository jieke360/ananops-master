package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import javax.persistence.*;

/**
 * 表单实例
 *
 * @author Bingyue Duan
 *
 * @version 1.0
 *
 * @date 2020/4/19 下午5:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "an_mdc_form_instance")
public class MdcFormInstance extends BaseEntity {

    private static final long serialVersionUID = 5128701582925429134L;

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
}