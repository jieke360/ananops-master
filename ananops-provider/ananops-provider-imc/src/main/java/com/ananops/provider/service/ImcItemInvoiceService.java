package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.ImcItemInvoice;
import com.ananops.provider.model.dto.ImcInvoiceQueryDto;

import java.util.List;

/**
 * @author Bingyue Duan
 * @version 1.0
 * @date 2020/4/21 下午8:29
 */

public interface ImcItemInvoiceService extends IService<ImcItemInvoice> {

    /**
     * 查询巡检单列表
     *
     * @param imcInvoiceQueryDto
     *
     * @param loginAuthDto
     *
     * @return
     */
    List<ImcItemInvoice> queryInvoiceList(ImcInvoiceQueryDto imcInvoiceQueryDto, LoginAuthDto loginAuthDto);

}
