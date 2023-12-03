package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Employee")
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EID;
    private String Name;
    private String Email;
    private int Phone_number;
    private int Salary;
    private Date Birthday;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date Login_time;
}
