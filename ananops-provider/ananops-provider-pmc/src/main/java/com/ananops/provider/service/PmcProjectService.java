package com.ananops.provider.service;

import com.ananops.base.dto.BaseQuery;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.PmcProject;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created By ChengHao On 2019/12/4
 */
public interface PmcProjectService extends IService<PmcProject> {
    /**
     * 编辑项目信息
     * @param pmcProject
     * @return
     */
    int saveProject(PmcProject pmcProject, LoginAuthDto loginAuthDto);

    /**
     * 查询项目详情
     * @param id
     * @return
     */
    PmcProject getProjectById(Long id);

    /**
     * 删除项目信息
     * @param id
     */
    void deleteProjectById(Long id);

    /**
     * 获取某个组织下的项目列表
     * @param groupId
     * @return
     */
    List<PmcProject> getProjectListByGroupId(Long groupId);

    /**
     * 分页获取所有项目列表
     * @param baseQuery
     * @return
     */
    PageInfo getProjectListWithPage(BaseQuery baseQuery);
}