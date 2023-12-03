package com.example.demo.DAO;
import com.example.demo.bean.Course;
import com.example.demo.bean.User;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public int registerByEmail(String Email, String Name, Date Birthday, String Gender, int phone_number){
        if (Gender.equals("Male")){
            Gender = "M";
        }
        else {
            Gender = "F";
        }
        return jdbcTemplate.update("insert into User(Email,Login_time, registration_date, Name, Birthday, Gender, Phone_number) " +
                "values (?, DATE (NOW()),DATE(NOW()), ?,?,?,?)", Email, Name, Birthday, Gender, phone_number);
    }

    @Override
    public Integer loginByEmail(String Email){
        String sql = "UPDATE User SET Login_time = DATE (now()) WHERE Email = ?";
        jdbcTemplate.update(sql, Email);
        String sql2 = "SELECT UID FROM User WHERE Email = ?";

        return jdbcTemplate.queryForObject(sql2,Integer.class,Email);
    }

    @Override
    public  int updateByUID(int UID, String Email, String Name, Date Birthday, String Gender, int phone_number){
            if (Gender.equals("Male") ){
                Gender = "M";
            }
            else {
                Gender = "F";
            }
            String sql = "UPDATE User SET Email = ?, Name = ?, Birthday = ?, Gender = ?, Phone_number = ? WHERE UID = ?";
            return jdbcTemplate.update(sql, Email, Name, Birthday, Gender, phone_number, UID);

    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));

    }


}
