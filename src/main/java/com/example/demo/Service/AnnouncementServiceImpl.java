package com.example.demo.Service;

import com.example.demo.DAO.AnnouncementDAO;
import com.example.demo.bean.Announcement;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    @Resource
    AnnouncementDAO announcementDAO;


    @Override
    public List<Announcement> viewALL() {
        return announcementDAO.viewALL();
    }

    @Override
    public int publishAnn(int Manager_EID, String Content, String Title) {
        return announcementDAO.publishAnn(Manager_EID,Content,Title);
    }

    @Override
    public int updateAnn(int Manager_EID, String Content, String Title, Date date) {
        return announcementDAO.updateAnn(Manager_EID,Content,Title, date);
    }

    @Override
    public int deleteAnn(int Manager_EID, String Title, Date date) {
        return announcementDAO.deleteAnn(Manager_EID,Title,date);
    }
}
