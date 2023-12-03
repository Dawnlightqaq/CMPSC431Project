package com.example.demo.Service;

import com.example.demo.DAO.Course_userDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_userServiceImpl implements Course_userService{
    @Resource
    Course_userDAO courseUserDAO;
    @Override
    public int enroll_course(int UID, String Course_name, String Season, int Year) {
        return courseUserDAO.enroll_course(UID,Course_name,Season,Year);
    }

    @Override
    public int drop_course(int UID, String Course_name, String Season, int Year) {
        return courseUserDAO.drop_course(UID,Course_name,Season,Year);
    }

    @Override
    public List<Integer> findUIDByCourse(String Course_name, String Season, int Year) {
        return courseUserDAO.findUIDByCourse(Course_name,Season,Year);
    }
}
