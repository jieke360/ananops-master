package com.ananops.provider.model.domain;

import lombok.Data;

import javax.persistence.*;

@Table(name = "an_pmc_project_user")
@Data
public class PmcProjectUser {
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

}