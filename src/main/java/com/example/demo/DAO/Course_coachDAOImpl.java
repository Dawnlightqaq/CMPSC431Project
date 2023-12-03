package com.example.demo.DAO;

import com.example.demo.bean.Coach_teach_course;
import com.example.demo.bean.Course;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Course_coachDAOImpl implements Course_coachDAO{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int assignCoachToCourse(int Coach_EID, String Course, String Season, int Year) {
        String sql = "INSERT INTO Coach_teach_course(Coach_EID, Course_name, Season, Year) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, Coach_EID, Course, Season, Year);
    }

    @Override
    public List<Coach_teach_course> ViewTable() {
        String sql = "SELECT * FROM Coach_teach_course";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Coach_teach_course>(Coach_teach_course.class));
    }
}
