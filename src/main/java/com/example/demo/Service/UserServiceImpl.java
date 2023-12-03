package com.example.demo.Service;

import com.example.demo.DAO.UserDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public int registerByEmail(String Email, String Name, Date Birthday, String Gender, int phone_number){
        return userDAO.registerByEmail(Email, Name, Birthday, Gender,phone_number);
    }


    @Override
    public Integer loginByEmail(String Email) {
        return userDAO.loginByEmail(Email);
    }

    @Override
    public  int updateByUID(int UID, String Email, String Name, Date Birthday, String Gender, int phone_number){
        return userDAO.updateByUID(UID,Email,Name,Birthday,Gender,phone_number);
    }
}
