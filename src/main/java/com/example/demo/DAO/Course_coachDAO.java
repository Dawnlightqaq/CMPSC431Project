package com.example.demo.DAO;

import com.example.demo.bean.Coach_teach_course;

import java.util.List;

public interface Course_coachDAO {
    public int assignCoachToCourse(int Coach_EID, String Course, String Season, int Year);

    public List<Coach_teach_course> ViewTable();
}
