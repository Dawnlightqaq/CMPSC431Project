package com.example.demo.Service;

import java.util.List;

public interface Course_userService {
    public int enroll_course(int UID, String Course_name, String Season, int Year);
    public int drop_course(int UID, String Course_name, String Season, int Year);

    public List<Integer> findUIDByCourse(String Course_name, String Season, int Year);
}
