package com.ananops.provider.model.domain;

import com.ananops.core.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import javax.persistence.*;

/**
 * 表单实例设备统计
 *
 * @author Bingyue Duan
 *
 * @version 1.0
 *
 * @date 2020/4/19 下午5:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "an_mdc_form_instance_device")
public class MdcFormInstanceDevice extends BaseEntity {

    private static final long serialVersionUID = -2163874264272309921L;

    /**
     * 实例ID
     */
    @Column(name = "instace_id")
    private Long instaceId;

    /**
     * 设备状态描述
     */
    private String content;
}