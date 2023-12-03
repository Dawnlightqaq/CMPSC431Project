package com.example.demo.Service;

import com.example.demo.bean.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourse();

    public List<Course> findCourseByName(String Name);

    public List<Course> findCourseBySemester(int Year, String Season);

    public Course findCourseByNSY(String Name, int Year, String Season);

    public int insertCourse(String Name, int Year, String Season);


    public int deleteCourse(String Name, int Year, String Season);
}
