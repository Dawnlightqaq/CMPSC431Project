package com.example.demo.Service;

import com.example.demo.DAO.CommentDAO;
import com.example.demo.DAO.CourseDAO;
import com.example.demo.bean.Course;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Resource
    private CourseDAO courseDAO;


    @Override
    public List<Course> getAllCourse() {
        return courseDAO.getAllCourse();
    }

    @Override
    public List<Course> findCourseByName(String Name) {
        return courseDAO.findCourseByName(Name);
    }

    @Override
    public List<Course> findCourseBySemester(int Year, String Season) {
        return courseDAO.findCourseBySemester(Year,Season);
    }

    @Override
    public Course findCourseByNSY(String Name, int Year, String Season) {
        return courseDAO.findCourseByNSY(Name,Year,Season);
    }

    @Override
    public int insertCourse(String Name, int Year, String Season) {
        return courseDAO.insertCourse(Name,Year,Season);

    }


    @Override
    public int deleteCourse(String Name, int Year, String Season) {
        return courseDAO.deleteCourse(Name,Year,Season);

    }
}
