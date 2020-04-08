//package com.payment.springcloud.service.impl;
//
//import com.payment.springcloud.dao.PaymentDao;
//import com.payment.springcloud.entites.Payment;
//import com.payment.springcloud.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    PaymentDao paymentDao;
//    @Override
//    public int createPaymentInfo(Payment payment) {
//
//        return paymentDao.create(payment);
//    }
//
//    @Override
//    public Payment getPaymentInfo(Long id) {
//        return paymentDao.getPaymentId(id);
//
//    }
//}
