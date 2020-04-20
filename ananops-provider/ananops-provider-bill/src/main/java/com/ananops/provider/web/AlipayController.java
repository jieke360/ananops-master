package com.ananops.provider.web;

import com.alipay.api.AlipayApiException;
import com.ananops.provider.alipay.AlipayBean;
import com.ananops.provider.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param outTradeNo
     * @param subject
     * @param totalAmount
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
    @GetMapping(value = "return")
    public String success(String charset,
                          String out_trade_no,
                          String method,
                          String total_amount,
                          String sign,
                          String trade_no,
                          String auth_app_id,
                          String version,
                          String app_id,
                          String sign_type,
                          String seller_id,
                          String timestamp){
        System.out.println("***********************");
        System.out.println("charset"+charset);
        System.out.println("out_trade_no"+out_trade_no);
        System.out.println("method"+method);
        System.out.println("total_amount"+total_amount);
        System.out.println("sign"+sign);
        System.out.println("trade_no"+trade_no);
        System.out.println("auth_app_id"+auth_app_id);
        System.out.println("version"+version);
        System.out.println("app_id"+app_id);
        System.out.println("sign_type"+sign_type);
        System.out.println("seller_id"+seller_id);
        System.out.println("timestamp"+timestamp);
        return "已成功完成支付";
    }
}
