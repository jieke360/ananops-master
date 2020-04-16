package com.ananops.provider.service.impl;

import com.alipay.api.AlipayApiException;
import com.ananops.provider.alipay.Alipay;
import com.ananops.provider.alipay.AlipayBean;
import com.ananops.provider.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/4/15 19:27
 */
@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}

