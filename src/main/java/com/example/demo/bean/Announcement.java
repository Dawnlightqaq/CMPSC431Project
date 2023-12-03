package com.example.demo.bean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "Announcement")
@Data
@Entity
public class Announcement {
    @Id
    private String Title;
    @Id
    private Date Date;
    private String Content;
    private int Manager_EID;
}
