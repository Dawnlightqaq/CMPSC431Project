package com.example.demo.Service;

import com.example.demo.DAO.FacilityDAO;
import com.example.demo.bean.Facility;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityServiceImpl implements FacilityService{
    @Resource
    FacilityDAO facilityDAO;
    @Override
    public int addFacility(String status, String Facility_name) {
        return facilityDAO.addFacility(status,Facility_name);
    }

    @Override
    public int deleteFacility(int FID) {
        return facilityDAO.deleteFacility(FID);
    }

    @Override
    public List<String> ViewAllFacility() {
        return facilityDAO.ViewAllFacility();
    }

    @Override
    public Boolean checkFacilityUsage(int FID) {
        return facilityDAO.checkFacilityUsage(FID);
    }

    @Override
    public List<Facility> ViewAllDetailsF() {
        return facilityDAO.ViewAllDetailsF();
    }
}
