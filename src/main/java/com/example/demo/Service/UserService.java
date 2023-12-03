package com.example.demo.Service;
import java.util.Date;

public interface UserService {
    public int registerByEmail(String Email, String Name, Date Birthday, String Gender, int phone_number);

    public Integer loginByEmail(String Email);

    public  int updateByUID(int UID, String Email, String Name, Date Birthday, String Gender, int phone_number);
}
