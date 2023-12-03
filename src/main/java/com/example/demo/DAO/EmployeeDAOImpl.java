package com.example.demo.DAO;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int registerByEmail(String Email, String Name, Date Birthday, int phone_number) {
        return jdbcTemplate.update("insert into Employee(Email,Login_time, Name, Birthday, Phone_number) " +
                "values (?, DATE (NOW()), ?,?,?)", Email, Name, Birthday, phone_number);
    }

    @Override
    public Integer loginByEmail(String Email) {
        String sql = "UPDATE Employee SET Login_time = DATE (now()) WHERE Email = ?";
        jdbcTemplate.update(sql, Email);
        String sql2 = "SELECT EID FROM Employee WHERE Email = ?";
        return jdbcTemplate.queryForObject(sql2,Integer.class,Email);
    }

    @Override
    public int AssignCoach(int EID, String Field, String Gender) {
        String sql = "INSERT into  Coach(Coach_EID, Field, Gender) VALUES(?,?,?)";
        return jdbcTemplate.update(sql,EID,Field,Gender);
    }

}
