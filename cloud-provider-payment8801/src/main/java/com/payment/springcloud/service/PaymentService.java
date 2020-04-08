package com.payment.springcloud.service;

import com.payment.springcloud.entites.Payment;

public interface PaymentService {

    /**
     * 订单创建
     * @param payment
     * @return
     */
    int createPaymentInfo(Payment payment);

    /**
     * 获取支付信息
     * @param id
     * @return
     */
    Payment getPaymentInfo(Long id);

}
