package com.ananops.provider.service.impl;

import com.ananops.Collections3;
import com.ananops.PublicUtil;
import com.ananops.base.constant.GlobalConstant;
import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.enums.ErrorCodeEnum;
import com.ananops.core.support.BaseService;
import com.ananops.provider.mapper.*;
import com.ananops.provider.model.domain.*;
import com.ananops.provider.model.dto.department.DepartmentBindRoleReqDto;
import com.ananops.provider.model.dto.department.DepartmentBindUserDto;
import com.ananops.provider.model.dto.role.BindUserDto;
import com.ananops.provider.model.dto.user.IdStatusDto;
import com.ananops.provider.model.enums.UacDepartmentStatusEnum;
import com.ananops.provider.model.enums.UacGroupStatusEnum;
import com.ananops.provider.model.exceptions.UacBizException;
import com.ananops.provider.model.vo.DepartmentZtreeVo;
import com.ananops.provider.model.vo.MenuVo;
import com.ananops.provider.service.*;
import com.ananops.provider.utils.TreeUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * The class Uac group service.
 *
 * @author ananops.com@gmail.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacDepartmentServiceImpl extends BaseService<UacDepartment> implements UacDepartmentService {

	@Resource
	private UacDepartmentMapper uacDepartmentMapper;
	@Resource
	private UacDepartmentRoleMapper uacDepartmentRoleMapper;
	@Resource
	private UacDepartmentUserMapper uacDepartmentUserMapper;
	@Resource
	private UacRoleUserMapper uacRoleUserMapper;
	@Resource
	private UacRoleMapper uacRoleMapper;
	@Resource
	private UacUserService uacUserService;
	@Resource
	private MdcAddressService mdcAddressService;

	private int addUacDepartment(UacDepartment department) {
		if (StringUtils.isEmpty(department.getStatus())) {
			department.setStatus(UacGroupStatusEnum.ENABLE.getStatus());
		}
		return uacDepartmentMapper.insertSelective(department);
	}

	private int editUacDepartment(UacDepartment department) {
		return uacDepartmentMapper.updateByPrimaryKeySelective(department);
	}

	@Override
	public int updateUacDepartmentStatusById(IdStatusDto idStatusDto, LoginAuthDto loginAuthDto) {

		Long departmentId = idStatusDto.getId();
		Integer status = idStatusDto.getStatus();

		UacDepartment uacDepartment = new UacDepartment();
		uacDepartment.setId(departmentId);
		uacDepartment.setStatus(status);

		UacDepartment department = uacDepartmentMapper.selectByPrimaryKey(departmentId);
		if (PublicUtil.isEmpty(department)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015001, departmentId);
		}
		if (!UacGroupStatusEnum.contains(status)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015002);
		}

		//查询所有的部门
		List<UacDepartment> totalGroupList = uacDepartmentMapper.selectAll();
		List<DepartmentZtreeVo> totalList = Lists.newArrayList();
		DepartmentZtreeVo zTreeVo;
		for (UacDepartment vo : totalGroupList) {
			zTreeVo = new DepartmentZtreeVo();
			zTreeVo.setId(vo.getId());
			totalList.add(zTreeVo);
		}

//		UacDepartmentRole uacDepartmentRole = new UacDepartmentRole();
//		UacGroupUser groupUser = uacGroupUserMapper.selectOne(uacGroupUser);
//		// 查询当前登陆人所在的部门信息
//		UacGroup currentUserUacGroup = uacGroupMapper.selectByPrimaryKey(groupUser.getGroupId());
//		// 查询当前登陆人能禁用的所有子节点
//		List<GroupZtreeVo> childGroupList = this.getGroupTree(currentUserUacGroup.getId());
//		// 计算不能禁用的部门= 所有的部门 - 禁用的所有子节点
//		totalList.removeAll(childGroupList);
//		// 判断所选的部门是否在不能禁用的列表里
//		GroupZtreeVo zTreeVo1 = new GroupZtreeVo();
//		zTreeVo1.setId(group.getId());
//		if (totalList.contains(zTreeVo1)) {
//			throw new UacBizException(ErrorCodeEnum.UAC10011023);
//		}
//		if (groupUser.getGroupId().equals(uacGroup.getId()) && UacGroupStatusEnum.ENABLE.getStatus() == group.getStatus()) {
//			throw new UacBizException(ErrorCodeEnum.UAC10011023);
//		}
//		uacGroup.setGroupName(group.getGroupName());
//		uacGroup.setGroupCode(group.getGroupCode());
//		uacGroup.setVersion(group.getVersion() + 1);
//		int result = uacGroupMapper.updateByPrimaryKeySelective(uacGroup);
		int result = 0;
		// 获取当前所选部门的所有子节点
		List<DepartmentZtreeVo> childUacDepartmentList = this.getDepartmentTree(uacDepartment.getId());
		// 批量修改部门状态
		if (PublicUtil.isNotEmpty(childUacDepartmentList)) {
			UacDepartment childDepartment;
			for (DepartmentZtreeVo uacDepartment1 : childUacDepartmentList) {
				if (UacDepartmentStatusEnum.ENABLE.getStatus() == status) {
					UacDepartment parentDepartment = uacDepartmentMapper.selectByPrimaryKey(uacDepartment1.getpId());
					if (parentDepartment.getStatus() == UacDepartmentStatusEnum.DISABLE.getStatus()) {
						throw new UacBizException(ErrorCodeEnum.UAC10015003);
					}
				}
				childDepartment = new UacDepartment();
				childDepartment.setStatus(uacDepartment.getStatus());
				childDepartment.setId(uacDepartment1.getId());
				result = uacDepartmentMapper.updateByPrimaryKeySelective(childDepartment);
				if (result < 1) {
					throw new UacBizException(ErrorCodeEnum.UAC10015006, uacDepartment1.getId());
				}
			}
		}
		return result;
	}

	@Override
	public int deleteUacDepartmentById(Long id) {

		Preconditions.checkArgument(id != null, "部门id为空");
		Preconditions.checkArgument(!Objects.equals(id, GlobalConstant.Sys.SUPER_MANAGER_GROUP_ID), "该部门不能删除");

		// 根据前台传入的部门参数校验该部门是否存在
		UacDepartment uacDepartment = uacDepartmentMapper.selectByPrimaryKey(id);
		if (PublicUtil.isEmpty(uacDepartment)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015004, id);
		}
		//判断该部门下是否存在子节点
		UacDepartment childDepartment = new UacDepartment();
		childDepartment.setPid(id);
		List<UacDepartment> childDepartmentList = uacDepartmentMapper.select(childDepartment);
		if (PublicUtil.isNotEmpty(childDepartmentList)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015007, id);
		}
		//判断该部门下是否存在用户
		UacDepartmentRole uacDepartmentRole = new UacDepartmentRole();
		uacDepartmentRole.setDepartmentId(id);
		List<UacDepartmentRole> uacDepartmentRoleList = uacDepartmentRoleMapper.select(uacDepartmentRole);
		if (PublicUtil.isNotEmpty(uacDepartmentRoleList)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015008, id);
		}

		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public UacDepartment queryById(Long departmentId) {
		Preconditions.checkArgument(PublicUtil.isNotEmpty(departmentId), "部门Id不能为空");
		UacDepartment query = new UacDepartment();
		query.setId(departmentId);
		return uacDepartmentMapper.selectOne(query);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<DepartmentZtreeVo> getDepartmentTree(Long departmentId) {
		// 1. 如果是仓库则 直接把仓库信息封装成ztreeVo返回
		List<DepartmentZtreeVo> tree = Lists.newArrayList();

		UacDepartment uacDepartment = uacDepartmentMapper.selectByPrimaryKey(departmentId);

		DepartmentZtreeVo zTreeMenuVo = buildDepartmentZTreeVoByDepartment(uacDepartment);
		if (0L == uacDepartment.getPid()) {
			zTreeMenuVo.setOpen(true);
		}

		tree.add(zTreeMenuVo);

		// 2.如果是部门id则遍历部门+仓库的树结构

		// 如果是部门 则查询父id为
		UacDepartment uacDepartmentQuery = new UacDepartment();
		uacDepartmentQuery.setPid(departmentId);
		List<UacDepartment> departmentList = uacDepartmentMapper.select(uacDepartmentQuery);
		if (PublicUtil.isNotEmpty(departmentList)) {
			tree = buildNode(departmentList, tree);
		}

		return tree;
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<MenuVo> getDepartmentTreeListByUserId(Long userId) {
		UacDepartmentUser uacDepartmentUser = uacDepartmentUserMapper.getByUserId(userId);
		Long departmentId = uacDepartmentUser.getDepartmentId();
		//获取当前所选部门的所有子节点
		List<DepartmentZtreeVo> childUacDepartmentList = this.getDepartmentTree(departmentId);
		return this.buildDepartmentTree(childUacDepartmentList, departmentId);
	}

	private List<MenuVo> buildDepartmentTree(List<DepartmentZtreeVo> childUacDepartmentList, Long currentDepartmentId) {
		List<MenuVo> listVo = Lists.newArrayList();
		MenuVo menuVo;
		for (DepartmentZtreeVo department : childUacDepartmentList) {
			menuVo = new MenuVo();
			menuVo.setId(department.getId());
			if (currentDepartmentId.equals(department.getId())) {
				menuVo.setPid(0L);
			} else {
				menuVo.setPid(department.getpId());
			}
			menuVo.setMenuCode(department.getDepartmentCode());
			menuVo.setMenuName(department.getDepartmentName());
			listVo.add(menuVo);
		}

		return TreeUtil.getChildMenuVos(listVo, 0L);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public DepartmentBindUserDto getDepartmentBindUserDto(Long departmentId, Long currentUserId) {
		DepartmentBindUserDto departmentBindUserDto = new DepartmentBindUserDto();
		Set<Long> alreadyBindUserIdSet = Sets.newHashSet();
		UacDepartment uacDepartment = uacDepartmentMapper.selectByPrimaryKey(departmentId);
		if (PublicUtil.isEmpty(uacDepartment)) {
			logger.error("找不到uacDepartment={}, 的部门", uacDepartment);
			throw new UacBizException(ErrorCodeEnum.UAC10015001, departmentId);
		}

		// 查询所有用户包括已禁用的用户
		List<BindUserDto> bindUserDtoList = uacRoleMapper.selectAllNeedBindUser(GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID, currentUserId);
		// 该部门已经绑定的用户
		List<UacDepartmentUser> setAlreadyBindUserSet = uacDepartmentUserMapper.listByDepartmentId(departmentId);

		Set<BindUserDto> allUserSet = new HashSet<>(bindUserDtoList);

		for (UacDepartmentUser uacDepartmentUser : setAlreadyBindUserSet) {
			alreadyBindUserIdSet.add(uacDepartmentUser.getUserId());
		}

		departmentBindUserDto.setAllUserSet(allUserSet);
		departmentBindUserDto.setAlreadyBindUserIdSet(alreadyBindUserIdSet);

		return departmentBindUserDto;
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Long getDepartmentBindRoleId(Long departmentId) {
		UacDepartmentRole uacDepartmentRole = uacDepartmentRoleMapper.selectByPrimaryKey(departmentId);
		if (PublicUtil.isEmpty(uacDepartmentRole)) {
			logger.error("找不到uacDepartmentId={}, 的部门", departmentId);
			throw new UacBizException(ErrorCodeEnum.UAC10015001, departmentId);
		}
		return uacDepartmentRole.getRoleId();
	}


	/**
	 * Bind uac user 4 group int.
	 *
	 * @param departmentBindRoleReqDto the group bind user req dto
	 * @param loginAuthDto          the auth res dto
	 */
	@Override
	public void bindUacRole4Department(DepartmentBindRoleReqDto departmentBindRoleReqDto, LoginAuthDto loginAuthDto) {
		if (departmentBindRoleReqDto == null) {
			logger.error("参数不能为空");
			throw new IllegalArgumentException("参数不能为空");
		}

		Long departmentId = departmentBindRoleReqDto.getDepartmentId();
		Long loginUserId = loginAuthDto.getUserId();
		List<Long> userIdList = departmentBindRoleReqDto.getRoleIdList();

		if (null == departmentId) {
			throw new IllegalArgumentException("組織ID不能为空");
		}

		UacDepartment uacDepartment = uacDepartmentMapper.selectByPrimaryKey(departmentId);

		if (uacDepartment == null) {
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
		List<UacDepartmentUser> departmentUsers = uacDepartmentUserMapper.listByDepartmentId(departmentId);

		if (PublicUtil.isNotEmpty(departmentUsers)) {
			uacDepartmentUserMapper.deleteExcludeSuperMng(departmentId, GlobalConstant.Sys.SUPER_MANAGER_ROLE_ID);
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
			uacDepartmentUser.setUserId(userId);
			uacDepartmentUser.setDepartmentId(departmentId);
			uacDepartmentUserMapper.insertSelective(uacDepartmentUser);
		}
	}

	@Override
	public int saveUacDepartment(UacDepartment department, LoginAuthDto loginAuthDto) {
		int result;
		Preconditions.checkArgument(!StringUtils.isEmpty(department.getPid()), "上级节点不能为空");

		UacDepartment parentDepartment = uacDepartmentMapper.selectByPrimaryKey(department.getPid());
		if (PublicUtil.isEmpty(parentDepartment)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015009, department.getPid());
		}
		setDepartmentAddress(department);
		department.setUpdateInfo(loginAuthDto);

		if (department.isNew()) {
			Long groupId = super.generateId();
			department.setId(groupId);
			department.setLevel(parentDepartment.getLevel() + 1);
			result = this.addUacDepartment(department);
		} else {
			result = this.editUacDepartment(department);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public UacDepartment getById(Long id) {
		UacDepartment uacDepartment = uacDepartmentMapper.selectByPrimaryKey(id);
		if (PublicUtil.isEmpty(uacDepartment)) {
			throw new UacBizException(ErrorCodeEnum.UAC10015001, id);
		}
		UacDepartment parentDepartment = uacDepartmentMapper.selectByPrimaryKey(uacDepartment.getPid());
		if (parentDepartment != null) {
			uacDepartment.setParentDepartmentCode(parentDepartment.getDepartmentCode());
			uacDepartment.setParentDepartmentName(parentDepartment.getDepartmentName());
		}
		// 处理级联菜单回显地址
		Long provinceId = uacDepartment.getProvinceId();
		Long cityId = uacDepartment.getCityId();
		Long areaId = uacDepartment.getAreaId();
		Long streetId = uacDepartment.getStreetId();
		List<Long> addressList = Lists.newArrayList();
		if (provinceId != null) {
			addressList.add(provinceId);
		}
		if (cityId != null) {
			addressList.add(cityId);
		}
		if (areaId != null) {
			addressList.add(areaId);
		}
		if (streetId != null) {
			addressList.add(streetId);
		}
		uacDepartment.setAddressList(addressList);
		return uacDepartment;
	}

	@Override
	public UacDepartment getByUserId(Long userId) {
		return null;
	}

	private void setDepartmentAddress(UacDepartment uacDepartment) {
		List<Long> addressList = uacDepartment.getAddressList();
		Preconditions.checkArgument(!PublicUtil.isEmpty(addressList), "地址不能为空");
		Preconditions.checkArgument(addressList.size() >= GlobalConstant.TWO_INT, "地址至少选两级");

		StringBuilder departmentAddress = new StringBuilder();
		int level = 0;
		for (Long addressId : addressList) {
			// 根据地址ID获取地址名称
			String addressName = mdcAddressService.getAddressById(addressId).getName();
			if (level == 0) {
				uacDepartment.setProvinceId(addressId);
				uacDepartment.setProvinceName(addressName);
			} else if (level == 1) {
				uacDepartment.setCityId(addressId);
				uacDepartment.setCityName(addressName);
			} else if (level == 2) {
				uacDepartment.setAreaId(addressId);
				uacDepartment.setAreaName(addressName);
			} else {
				uacDepartment.setStreetId(addressId);
				uacDepartment.setStreetName(addressName);
			}
			departmentAddress.append(addressName);
			level++;
		}
		uacDepartment.setDepartmentAddress(departmentAddress.toString());
	}

	private DepartmentZtreeVo buildDepartmentZTreeVoByDepartment(UacDepartment department) {
		DepartmentZtreeVo vo = new DepartmentZtreeVo();

		vo.setId(department.getId());
		vo.setpId(department.getPid());
		vo.setName(department.getGroupName());
		vo.setStatus(department.getStatus());
		vo.setLeaf(department.getLevel());
		vo.setLevel(department.getLevel());
		vo.setDepartmentCode(department.getDepartmentCode());

		vo.setContact(department.getContact());
		vo.setContactPhone(department.getContactPhone());
		vo.setCreatedTime(department.getCreatedTime() == null ? new Date() : department.getCreatedTime());
		vo.setCreator(department.getCreator());
		vo.setDepartmentAddress(department.getDepartmentAddress());
		vo.setGroupName(department.getGroupName());

		return vo;
	}

	private List<DepartmentZtreeVo> buildNode(List<UacDepartment> departmentList, List<DepartmentZtreeVo> tree) {

		for (UacDepartment department : departmentList) {

			DepartmentZtreeVo departmentZtreeVo = buildDepartmentZTreeVoByDepartment(department);

			if (0L == department.getPid()) {
				departmentZtreeVo.setOpen(true);
			}
			// 设置根节点
			tree.add(departmentZtreeVo);

			UacDepartment query = new UacDepartment();
			query.setPid(department.getId());

			List<UacDepartment> departmentChildrenList = uacDepartmentMapper.select(query);
			// 有子节点 递归查询
			if (PublicUtil.isNotEmpty(departmentChildrenList)) {
				buildNode(departmentChildrenList, tree);
			}

		}
		return tree;
	}
}
