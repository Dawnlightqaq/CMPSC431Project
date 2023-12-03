package com.example.demo.DAO;

import com.example.demo.bean.Course;
import com.example.demo.bean.Payment;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDAOImpl implements PaymentDAO{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int makePayment(String Purpose, int UID, int Amount) {
        return jdbcTemplate.update("insert into Payment(Purpose, Amount, Payment_date, Pay_UID) " +
                "values (?, ?,DATE(NOW()), ?)",Purpose,Amount,UID);
    }

    @Override
    public List<Payment> getPaymentByID(int UID) {
        String sql = "SELECT * FROM Payment WHERE Pay_UID = ? ORDER BY Purpose";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Payment>(Payment.class),UID);
    }

    @Override
    public List<Payment> getAllPayment() {
        String sql = "SELECT * FROM Payment ORDER BY Pay_UID";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Payment>(Payment.class));
    }
}
