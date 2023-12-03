package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Payment")
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PID;
    private String Purpose;
    private int Amount;
    private Date Payment_date;
    private int Pay_UID;
}
