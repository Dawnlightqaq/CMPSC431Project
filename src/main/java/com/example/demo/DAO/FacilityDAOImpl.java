package com.example.demo.DAO;

import com.example.demo.bean.Course;
import com.example.demo.bean.Facility;
import com.example.demo.bean.Payment;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class FacilityDAOImpl implements FacilityDAO{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int addFacility(String status, String Facility_name) {
        return jdbcTemplate.update("insert into Facility(Status, Facility_name, Purchase_time, In_use_status) " +
                "values (?, ?,DATE(NOW()), false)",status,Facility_name);
    }

    @Override
    public int deleteFacility(int FID) {
        return jdbcTemplate.update("DELETE FROM Facility WHERE FID = ?", FID);
    }

    @Override
    public List<String> ViewAllFacility() {
        String sql = "SELECT Facility_name FROM Facility ORDER BY FID";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public Boolean checkFacilityUsage(int FID) {
        String sql = "SELECT In_use_status FROM Facility WHERE FID = ?";
        return jdbcTemplate.queryForObject(sql,Boolean.class,FID);
    }

    @Override
    public List<Facility> ViewAllDetailsF() {
        String sql = "SELECT * FROM Facility ORDER BY FID";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Facility>(Facility.class));
    }
}
