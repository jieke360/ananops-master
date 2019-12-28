package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.UacGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Uac group mapper.
 *
 * @author ananops.net@gmail.com
 */
@Mapper
@Component
public interface UacGroupMapper extends MyMapper<UacGroup> {
    List<UacGroup> selectGroupListByUserId(Long userId);
}