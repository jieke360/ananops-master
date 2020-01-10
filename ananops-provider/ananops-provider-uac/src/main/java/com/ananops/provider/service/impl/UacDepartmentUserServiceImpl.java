package com.ananops.provider.service.impl;

import com.ananops.Collections3;
import com.ananops.PublicUtil;
import com.ananops.base.constant.GlobalConstant;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.UacDepartmentMapper;
import com.ananops.provider.mapper.UacDepartmentUserMapper;
import com.ananops.provider.mapper.UacRoleUserMapper;
import com.ananops.provider.model.domain.*;
import com.ananops.provider.model.dto.department.DepartmentBindUserReqDto;
import com.ananops.provider.model.dto.group.GroupBindUserReqDto;
import com.ananops.provider.model.exceptions.UacBizException;
import com.ananops.provider.service.UacDepartmentService;
import com.ananops.provider.service.UacDepartmentUserService;
import com.ananops.provider.service.UacUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * The class Uac department user service.
 *
 * @author ananops.com@gmail.com
 */
@Service
public class UacDepartmentUserServiceImpl extends BaseService<UacDepartmentUser> implements UacDepartmentUserService {
	@Resource
	private UacDepartmentUserMapper uacDepartmentUserMapper;
	@Resource
	private UacDepartmentMapper uacDepartmentMapper;
	@Resource
	private UacRoleUserMapper uacRoleUserMapper;
	@Resource
	private UacUserService uacUserService;

	@Override
	public UacDepartmentUser queryByUserId(Long userId) {
		return uacDepartmentUserMapper.getByUserId(userId);
	}

	@Override
	public int updateByUserId(UacDepartmentUser uacDepartmentUser) {
		return uacDepartmentUserMapper.updateByUserId(uacDepartmentUser);
	}

	@Override
	public List<UacDepartment> getDepartmentListByUserId(Long userId) {
		return uacDepartmentUserMapper.selectDepartmentListByUserId(userId);
	}

	@Override
	public void saveUserDepartment(Long userId, Long departmentId) {
		UacDepartmentUser uacDepartmentUser = new UacDepartmentUser();
		uacDepartmentUser.setUserId(userId);
		uacDepartmentUser.setDepartmentId(departmentId);
		uacDepartmentUserMapper.insertSelective(uacDepartmentUser);
	}

	@Override
	public void bindUacUser4Department(DepartmentBindUserReqDto departmentBindUserReqDto, LoginAuthDto loginAuthDto) {
		if (departmentBindUserReqDto == null) {
			logger.error("参数不能为空");
			throw new IllegalArgumentException("参数不能为空");
		}

		Long departmentId = departmentBindUserReqDto.getDepartmentId();
		Long loginUserId = loginAuthDto.getUserId();
		List<Long> userIdList = departmentBindUserReqDto.getUserIdList();

		if (null == departmentId) {
			throw new IllegalArgumentException("部门ID不能为空");
		}

		UacDepartment department = uacDepartmentMapper.selectByPrimaryKey(departmentId);

		if (department == null) {
			logger.error("找不到角色信息 groupId={}", departmentId);
			throw new UacBizException(ErrorCodeEnum.UAC10015001, departmentId);
		}

		if (PublicUtil.isNotEmpty(userIdList) && userIdList.contains(loginUserId)) {
			logger.error("不能操作当前登录用户 userId={}", loginUserId);
			throw new UacBizException(ErrorCodeEnum.UAC10011023);
		}

		// 查询超级管理员用户Id集合
		List<Long> superUserList = uacRoleUserMapper.listSuperUser(GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID);
		List<Long> unionList = Collections3.intersection(userIdList, superUserList);
		if (PublicUtil.isNotEmpty(userIdList) && PublicUtil.isNotEmpty(unionList)) {
			logger.error("不能操作超级管理员用户 超级用户={}", unionList);
			throw new UacBizException(ErrorCodeEnum.UAC10011023);
		}

		// 1. 先取消对该角色的用户绑定(不包含超级管理员用户)
		List<UacDepartmentUser> groupUsers = uacDepartmentUserMapper.listByDepartmentId(departmentId);

		if (PublicUtil.isNotEmpty(groupUsers)) {
			uacDepartmentUserMapper.deleteExcludeSuperMng(departmentId, GlobalConstant.Sys.SUPER_MANAGER_USER_ID);
		}

		if (PublicUtil.isEmpty(userIdList)) {
			// 取消该角色的所有用户的绑定
			logger.info("取消绑定所有非超级管理员用户成功");
			return;
		}

		// 绑定所选用户
		for (Long userId : userIdList) {
			UacUser uacUser = uacUserService.queryByUserId(userId);
			if (PublicUtil.isEmpty(uacUser)) {
				logger.error("找不到绑定的用户 userId={}", userId);
				throw new UacBizException(ErrorCodeEnum.UAC10011024, userId);
			}
			UacDepartmentUser uacDepartmentUser = new UacDepartmentUser();
			uacDepartmentUser.setDepartmentId(departmentId);
			uacDepartmentUser.setUserId(userId);
			uacDepartmentUserMapper.insertSelective(uacDepartmentUser);
		}
	}
}
