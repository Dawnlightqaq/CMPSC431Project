package com.example.demo.DAO;

import com.example.demo.bean.Announcement;

import java.util.Date;
import java.util.List;

public interface AnnouncementDAO {
    public List<Announcement> viewALL();


    public int publishAnn(int Manager_EID, String Content, String Title);

    public int updateAnn(int Manager_EID, String Content, String Title, Date date);
    public int deleteAnn(int Manager_EID, String Title, Date date);
}
