package com.ananops.provider.service.impl;

import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.UacRoleGroupMapper;
import com.ananops.provider.model.domain.UacRoleGroup;
import com.ananops.provider.model.exceptions.UacBizException;
import com.ananops.provider.service.UacRoleGroupService;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bingyue Duan
 * @version 1.0
 * @date 2020-02-24 19:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacRoleGroupServiceImpl extends BaseService<UacRoleGroup> implements UacRoleGroupService {

    @Resource
    private UacRoleGroupMapper uacRoleGroupMapper;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<Long> listByRoleId(Long groupId) {
        if (groupId == null) {
            throw new UacBizException(ErrorCodeEnum.UAC10015010);
        }
        UacRoleGroup roleGroup = new UacRoleGroup();
        roleGroup.setGroupId(groupId);
        List<UacRoleGroup> list = uacRoleGroupMapper.select(roleGroup);
        List<Long> roleIds = new ArrayList<>();
        if (list != null) {
            for (UacRoleGroup uacRoleGroup : list) {
                roleIds.add(uacRoleGroup.getRoleId());
            }
        }
        return roleIds;
    }
}
