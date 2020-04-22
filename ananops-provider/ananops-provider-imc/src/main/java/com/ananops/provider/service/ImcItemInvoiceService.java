package com.ananops.provider.service;

import com.ananops.base.dto.LoginAuthDto;
import com.ananops.core.support.IService;
import com.ananops.provider.model.domain.ImcItemInvoice;
import com.ananops.provider.model.dto.FormDataDto;
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

    /**
     * 根据InvoiceId查询表单项详情
     *
     * @param invoiceId
     *
     * @return
     */
    FormDataDto queryDetailsById(Long invoiceId);

    /**
     * 保存工程师提交的巡检单数据
     *
     * @param formDataDto 巡检单数据
     *
     * @param loginAuthDto 登录用户信息
     *
     * @return
     */
    Integer saveData(FormDataDto formDataDto, LoginAuthDto loginAuthDto);
}
