package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Table(name = "Facility")
@Data
@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FID;
    private String status;
    private Date Purchase_time;
    private String Facility_name;
    private Boolean inUseStatus;
}
