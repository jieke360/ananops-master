package com.ananops.provider.web;

import com.alipay.api.AlipayApiException;
import com.ananops.provider.alipay.AlipayBean;
import com.ananops.provider.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/4/15 19:26
 */
@RestController()
@RequestMapping("order")
public class AlipayController {
    @Autowired
    private AlipayService alipayService;

    /**
     * 阿里支付
     * @param tradeNo
     * @param subject
     * @param amount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "alipay")
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return alipayService.aliPay(alipayBean);
    }
}
