package com.example.demo.Service;

import com.example.demo.DAO.CommentDAO;
import com.example.demo.DAO.PaymentDAO;
import com.example.demo.bean.Payment;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDAO paymentDAO;
    @Override
    public int makePayment(String Purpose, int UID, int Amount) {
        return paymentDAO.makePayment(Purpose,UID,Amount);
    }

    @Override
    public List<Payment> getPaymentByID(int UID) {
        return paymentDAO.getPaymentByID(UID);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentDAO.getAllPayment();
    }
}
