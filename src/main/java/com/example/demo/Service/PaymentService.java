package com.example.demo.Service;

import com.example.demo.bean.Payment;

import java.util.List;

public interface PaymentService {
    public int makePayment(String Purpose, int UID, int Amount);

    public List<Payment> getPaymentByID(int UID);

    public List<Payment> getAllPayment();
}
