/*
 * Copyright (c) 2018. ananops.net All Rights Reserved.
 * 项目名称：ananops快速搭建企业级分布式微服务平台
 * 类名称：MdcDictService.java
 * 创建人：刘兆明
 * 联系方式：ananops.net@gmail.com
 * 开源地址: https://github.com/ananops
 * 博客地址: http://blog.ananops.net
 * 项目官网: http://ananops.net
 */

package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.base.dto.UpdateStatusDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.MdcDict;
import com.ananops.provider.model.vo.MdcDictVo;

import java.util.List;

/**
 * The interface Mdc dict service.
 *
 * @author ananops.net @gmail.com
 */
public interface MdcDictService extends IService<MdcDict> {

	/**
	 * 获取字典树.
	 *
	 * @return the dict tree list
	 */
	List<MdcDictVo> getDictTreeList();

	/**
	 * 根据ID获取字典信息.
	 *
	 * @param dictId the dict id
	 *
	 * @return the mdc dict vo by id
	 */
	MdcDictVo getMdcDictVoById(Long dictId);

	/**
	 * 根据id修改字典信息.
	 *
	 * @param updateStatusDto the update status dto
	 * @param loginAuthDto    the login auth dto
	 *
	 * @return the int
	 */
	void updateMdcDictStatusById(UpdateStatusDto updateStatusDto, LoginAuthDto loginAuthDto);

	/**
	 * 编辑字典.
	 *
	 * @param mdcDict      the mdc dict
	 * @param loginAuthDto the login auth dto
	 */
	void saveMdcDict(MdcDict mdcDict, LoginAuthDto loginAuthDto);

	/**
	 * Check dict has child dict boolean.
	 *
	 * @param dictId the dict id
	 *
	 * @return the boolean
	 */
	boolean checkDictHasChildDict(Long dictId);
}
