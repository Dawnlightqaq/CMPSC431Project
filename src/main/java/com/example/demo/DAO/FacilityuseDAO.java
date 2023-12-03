package com.example.demo.DAO;

import com.example.demo.bean.Facility_usage;

import java.util.Date;
import java.util.List;

public interface FacilityuseDAO {
    public int Borrow(int UID, int FID);

    public int Return(int UID, int FID);

    public List<Facility_usage> ViewusageTable();

}
