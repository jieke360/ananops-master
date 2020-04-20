package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.MdcFormTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 表单模板
 *
 * @author Bingyue Duan
 *
 * @version 1.0
 *
 * @date 2020/4/19 下午5:14
 */
@Mapper
@Component
public interface MdcFormTemplateMapper extends MyMapper<MdcFormTemplate> {
}