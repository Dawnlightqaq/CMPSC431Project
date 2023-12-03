package com.example.demo.DAO;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Course_userDAOImpl implements Course_userDAO{

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int enroll_course(int UID, String Course_name, String Season, int Year) {
        if (Season.equals("Spring")){
            Season = "SP";
        }
        else if(Season.equals("Summer")){
            Season = "SU";
        }
        else if(Season.equals("Fall")){
            Season = "FA";
        }
        else if(Season.equals("Winter")){
            Season = "WI";
        }
        String sql = "insert into User_take_Course(UID, Course_name, Season, Year) VALUE(?, ? ,?,?)";
        return jdbcTemplate.update(sql, UID,Course_name,Season,Year);
    }

    @Override
    public int drop_course(int UID, String Course_name, String Season, int Year) {
        String sql = "delete from User_take_Course WHERE Course_name = ? AND UID = ? AND Season = ? AND Year= ?";
        return jdbcTemplate.update(sql, Course_name,UID,Season,Year);
    }

    @Override
    public List<Integer> findUIDByCourse(String Course_name, String Season, int Year) {
        String sql = "SELECT UID FROM User_take_Course WHERE Course_name = ? AND Season = ? AND Year = ?";
        return jdbcTemplate.queryForList(sql,Integer.class,Course_name,Season,Year);
    }
}
