package com.example.demo.bean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Coach_teach_course")
@Data
@Entity
public class Coach_teach_course {
    @Id
    private int Coach_EID;
    @Id
    private String Course_name;
    @Id
    private String Season;
    @Id
    private int Year;
}
