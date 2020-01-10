package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "an_uac_department")
@Alias(value = "uacDepartment")
public class UacDepartment extends BaseEntity {

    private static final long serialVersionUID = -1088135857990309560L;

    /**
     * 所属组织id
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 组织名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 部门编码
     */
    @Column(name = "department_code")
    private String departmentCode;

    /**
     * 部门名称
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 是否叶子节点,1不是0是
     */
    private Integer leaf;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 部门地址
     */
    @Column(name = "department_address")
    private String departmentAddress;

    /**
     * 省名称
     */
    @Column(name = "province_name")
    private String provinceName;

    /**
     * 省编码
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 城市编码
     */
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 区名称
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 区编码
     */
    @Column(name = "area_id")
    private Long areaId;

    /**
     * 街道编码
     */
    @Column(name = "street_id")
    private Long streetId;

    /**
     * 街道名称
     */
    @Column(name = "street_name")
    private String streetName;

    /**
     * 详细地址
     */
    @Column(name = "detail_address")
    private String detailAddress;

    /**
     * 联系人手机号
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 描述
     */
    private String remark;

    /**
     * 预留排序字段
     */
    private Integer number;

    /**
     * 上级部门编码
     */
    @Transient
    private String parentDepartmentCode;

    /**
     * 上级部门名称
     */
    @Transient
    private String parentDepartmentName;

    /**
     * 四级地址数组
     */
    @Transient
    private List<Long> addressList;
}
