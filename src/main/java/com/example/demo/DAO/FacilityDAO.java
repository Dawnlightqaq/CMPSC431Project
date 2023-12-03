package com.example.demo.DAO;

import com.example.demo.bean.Facility;

import java.util.List;

public interface FacilityDAO {
    public int addFacility(String status, String Facility_name);

    public int deleteFacility(int FID);

    public List<String> ViewAllFacility();

    public Boolean checkFacilityUsage(int FID);

    public List<Facility> ViewAllDetailsF();

}
