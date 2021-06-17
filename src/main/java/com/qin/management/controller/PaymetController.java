package com.qin.management.controller;

import com.qin.management.config.AlipayConfig;
import com.qin.management.pojo.AlipayBean;
import com.qin.management.service.alipay.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PaymetController {
    @Autowired
    private PaymentServiceImpl paymentService;
    @Autowired
    AlipayConfig alipayConfig;
    @RequestMapping("api/alipay")
    public String toAlipay(@RequestBody AlipayBean alipayBean) throws IOException {
        System.out.println(alipayBean.toString());

        String result = paymentService.toAlipay(alipayBean);
        return result;
    }
}