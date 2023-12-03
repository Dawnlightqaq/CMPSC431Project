package com.example.demo.Service;

import com.example.demo.DAO.EmployeeDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    EmployeeDAO employeeDAO;
    @Override
    public int registerByEmail(String Email, String Name, Date Birthday, int phone_number) {
        return employeeDAO.registerByEmail(Email,Name,Birthday,phone_number);
    }

    @Override
    public Integer loginByEmail(String Email) {
        return employeeDAO.loginByEmail(Email);
    }
    @Override
    public int AssignCoach(int EID, String Field, String Gender){
        return employeeDAO.AssignCoach(EID,Field,Gender);
    };
}
