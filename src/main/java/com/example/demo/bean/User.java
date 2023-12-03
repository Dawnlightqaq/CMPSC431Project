package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "User")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UID;
    private String Name;
    private String Email;
    private int Phone_number;
    private String Gender;
    private Date Birthday;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date Login_time;
    private Date registration_date;


}
