package com.example.demo.Service;

import com.example.demo.bean.Coach_teach_course;

import java.util.List;

public interface Course_coachService {
    public int assignCoachToCourse(int Coach_EID, String Course, String Season, int Year);

    public List<Coach_teach_course> ViewTable();
}
