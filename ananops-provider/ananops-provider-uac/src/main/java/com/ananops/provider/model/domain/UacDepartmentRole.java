package com.ananops.provider.model.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "an_uac_department_role")
@Alias(value = "uacDepartmentRole")
public class UacDepartmentRole implements Serializable {
    private static final long serialVersionUID = -5741805527975738025L;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;
}
