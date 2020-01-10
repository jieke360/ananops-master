package com.ananops.provider.model.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "an_uac_department_user")
@Alias(value = "uacDepartmentUser")
public class UacDepartmentUser implements Serializable {
    private static final long serialVersionUID = -5741805527975738025L;

    /**
     * 角色id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;
}
