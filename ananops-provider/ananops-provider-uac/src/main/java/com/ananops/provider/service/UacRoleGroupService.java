package com.ananops.provider.service;

import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.UacRoleGroup;

import java.util.List;

/**
 * @author Bingyue Duan
 * @version 1.0
 * @date 2020-02-24 19:45
 */

public interface UacRoleGroupService extends IService<UacRoleGroup> {

    /**
     * 通过groupId列出所有关联角色.
     *
     * @param groupId the group id
     *
     * @return the list
     */
    List<Long> listByRoleId(Long groupId);

    /**
     * 通过角色Id删除与Group的关联表记录
     *
     * @param roleId 角色ID
     */
    void deleteByRoleId(Long roleId);

    /**
     * 批量通过角色Id删除与Group的关联表记录
     *
     * @param roleId 角色ID
     */
    void deleteByRoleIdList(List<Long> roleIdList);
}
