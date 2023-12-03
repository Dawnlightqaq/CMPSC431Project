package com.example.demo.Service;

import com.example.demo.DAO.Course_coachDAO;
import com.example.demo.bean.Coach_teach_course;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_coachServiceImpl implements Course_coachService{
    @Resource
    Course_coachDAO courseCoachDAO;

    @Override
    public int assignCoachToCourse(int Coach_EID, String Course, String Season, int Year) {
        return courseCoachDAO.assignCoachToCourse(Coach_EID,Course,Season,Year);
    }

    @Override
    public List<Coach_teach_course> ViewTable() {
        return courseCoachDAO.ViewTable();
    }
}
