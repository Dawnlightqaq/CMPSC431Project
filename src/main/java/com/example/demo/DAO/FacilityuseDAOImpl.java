package com.example.demo.DAO;

import com.example.demo.bean.Course;
import com.example.demo.bean.Facility_usage;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class FacilityuseDAOImpl implements FacilityuseDAO{

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public int Borrow(int UID, int FID) {
        String sql = "SELECT In_use_status FROM Facility WHERE FID = ?";
        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject(sql, Boolean.class, FID))) {
            String sql2 = "UPDATE Facility SET In_use_status = TRUE WHERE FID = ?";
            int i = jdbcTemplate.update(sql2, FID);

            String sql3 = "INSERT INTO Facility_usage VALUES (?,?, Date(NOW()))";
            int j = jdbcTemplate.update(sql3, UID, FID);
            if (i + j != 2) {
                throw new RuntimeException();
            }
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int Return(int UID, int FID) {
        String sql = "UPDATE Facility SET In_use_status = FALSE WHERE FID = ?";
        String sql2 = "DELETE FROM Facility_usage WHERE FID = ? AND UID = ?";
        int i = jdbcTemplate.update(sql,FID);
        int j = jdbcTemplate.update(sql2,FID,UID);
        if (i + j != 2) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Override
    public List<Facility_usage> ViewusageTable() {
        String sql = "SELECT * FROM Facility_usage";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Facility_usage>(Facility_usage.class));
    }
}
