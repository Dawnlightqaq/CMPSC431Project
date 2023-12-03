package com.example.demo.bean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Coach")
@Data
@Entity
public class Coach {
    @Id
    private int Coach_EID;
    private String Field;
    private String Gender;
}
