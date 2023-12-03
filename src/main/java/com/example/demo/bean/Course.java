package com.example.demo.bean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Course")
@Data
@Entity
public class Course {
    @Id
    private String Course_name;
    @Id
    private String Season;
    @Id
    private int Year;
}
