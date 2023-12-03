package com.example.demo.DAO;

import com.example.demo.bean.Payment;

import java.util.List;

public interface PaymentDAO {

    public int makePayment(String Purpose, int UID, int Amount);

    public List<Payment> getPaymentByID(int UID);

    public List<Payment> getAllPayment();
}
