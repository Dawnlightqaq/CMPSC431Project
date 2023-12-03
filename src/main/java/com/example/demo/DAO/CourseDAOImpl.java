package com.example.demo.DAO;

import com.example.demo.bean.Course;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseDAOImpl implements CourseDAO{

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Course> getAllCourse() {
        String sql = "SELECT * FROM Course ORDER BY Year";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
    }

    @Override
    public List<Course> findCourseByName(String Name) {
        String sql = "SELECT * FROM Course WHERE Course_name = ? ORDER BY Year, Season";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Course>(Course.class), Name);
    }

    @Override
    public List<Course> findCourseBySemester(int Year, String Season) {
        String sql = "SELECT * FROM Course WHERE Year = ? AND Season = ? ORDER BY Course_name";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Course>(Course.class), Year, Season);
    }

    @Override
    public Course findCourseByNSY(String Name, int Year, String Season) {
        String sql = "SELECT * FROM Course WHERE Year = ? AND Season = ? AND Course_name = ?";
        return jdbcTemplate.queryForObject(sql,Course.class, Year, Season, Name);
    }

    @Override
    public int insertCourse(String Name, int Year, String Season) {
        String sql = "Insert INTO Course(Course_name, Season, Year)  VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql,Name,Season,Year);
    }



    @Override
    public int deleteCourse(String Name, int Year, String Season) {
        String sql = "DELETE FROM  Course WHERE Course_name = ? AND Year = ? AND Season = ?";
        return jdbcTemplate.update(sql,Name,Year, Season);
    }

}
