package com.example.demo.DAO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface Course_userDAO {
    public int enroll_course(int UID, String Course_name, String Season, int Year);
    public int drop_course(int UID, String Course_name, String Season, int Year);

    public List<Integer> findUIDByCourse(String Course_name, String Season, int Year);
}
