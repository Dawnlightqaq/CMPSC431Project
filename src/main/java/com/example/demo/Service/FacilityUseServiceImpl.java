package com.example.demo.Service;

import com.example.demo.DAO.FacilityDAO;
import com.example.demo.DAO.FacilityuseDAO;
import com.example.demo.bean.Facility_usage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacilityUseServiceImpl implements FacilityUseService {
    @Resource
    FacilityuseDAO facilityuseDAO;

    @Override
    public int Borrow(int UID, int FID) {
        return facilityuseDAO.Borrow(UID,FID);
    }

    @Override
    public int Return(int UID, int FID) {
        return facilityuseDAO.Return(UID, FID);
    }

    @Override
    public List<Facility_usage> ViewusageTable() {
        return facilityuseDAO.ViewusageTable();
    }
}
