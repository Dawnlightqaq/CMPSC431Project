package com.example.demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Facility_usage")
@Data
@Entity
public class Facility_usage {
    @Id
    private int UID;
    @Id
    private int FID;
    private Date time;
}
