package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "User_take_Course")
@Data
@Entity
public class User_take_Course {
    @Id
    private int UID;
    @Id
    private String Course_name;
    @Id
    private int Year;
    @Id
    private String Season;
}
