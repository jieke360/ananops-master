package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.UacUserMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Uac user menu mapper.
 *
 * @author ananops.net@gmail.com
 */
@Mapper
@Component
public interface UacUserMenuMapper extends MyMapper<UacUserMenu> {
}