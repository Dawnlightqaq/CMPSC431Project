package com.example.demo.DAO;

import java.util.Date;

public interface EmployeeDAO {
    public int registerByEmail(String Email, String Name, Date Birthday, int phone_number);

    public Integer loginByEmail(String Email);

    public int AssignCoach(int EID, String Field, String Gender);
}
