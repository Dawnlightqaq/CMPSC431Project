package com.example.demo.DAO;
import com.example.demo.bean.User;

import java.util.Date;
import java.util.List;

public interface UserDAO {
    public int registerByEmail(String Email, String Name, Date Birthday, String Gender, int phone_number);

    public Integer loginByEmail(String Email);

    public  int updateByUID(int UID, String Email, String Name, Date Birthday, String Gender, int phone_number);

    public List<User> getAllUser();

}
