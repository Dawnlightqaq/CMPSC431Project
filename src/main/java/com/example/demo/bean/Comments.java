package com.example.demo.bean;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Comments")
@Data
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CID;
    private int UID;
    private String Comment_Content;
}
