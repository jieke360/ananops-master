package com.ananops.provider.mapper;

import com.ananops.core.mybatis.MyMapper;
import com.ananops.provider.model.domain.ImcItemInvoiceDesc;
import com.ananops.provider.model.domain.ImcItemInvoiceDevice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 巡检记录表实例设备
 *
 * @author Bingyue Duan
 *
 * @version 1.0
 *
 * @date 2020/4/19 下午5:14
 */
@Mapper
@Component
public interface ImcItemInvoiceDeviceMapper extends MyMapper<ImcItemInvoiceDevice> {

}