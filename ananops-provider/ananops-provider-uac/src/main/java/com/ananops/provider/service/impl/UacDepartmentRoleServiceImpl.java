package com.ananops.provider.service.impl;

import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.UacDepartmentRoleMapper;
import com.ananops.provider.mapper.UacDepartmentUserMapper;
import com.ananops.provider.model.domain.UacDepartment;
import com.ananops.provider.model.domain.UacDepartmentRole;
import com.ananops.provider.service.UacDepartmentRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Uac group user service.
 *
 * @author ananops.com@gmail.com
 */
@Service
public class UacDepartmentRoleServiceImpl extends BaseService<UacDepartmentRole> implements UacDepartmentRoleService {
	@Resource
	private UacDepartmentUserMapper uacDepartmentUserMapper;
	@Resource
	private UacDepartmentRoleMapper uacDepartmentRoleMapper;

	@Override
	public UacDepartmentRole queryByRoleId(Long roleId) {
		return uacDepartmentRoleMapper.getByRoleId(roleId);
	}

	@Override
	public int updateByRoleId(UacDepartmentRole uacDepartmentRole) {
		return uacDepartmentRoleMapper.updateByRoleId(uacDepartmentRole);
	}

	@Override
	public List<UacDepartment> getDepartmentListByRoleId(Long roleId) {
		return uacDepartmentRoleMapper.selectDepartmentListByRoleId(roleId);
	}

	@Override
	public void saveUserDepartment(Long userId, Long departmentId) {
		UacDepartmentRole uacDepartmentRole = new UacDepartmentRole();
		uacDepartmentRole.setRoleId(userId);
		uacDepartmentRole.setDepartmentId(departmentId);
		uacDepartmentRoleMapper.insertSelective(uacDepartmentRole);
	}
}
