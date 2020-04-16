package com.ananops.provider.service;

import com.alipay.api.AlipayApiException;
import com.ananops.provider.alipay.AlipayBean;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/4/15 19:26
 */
public interface AlipayService {
    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}

