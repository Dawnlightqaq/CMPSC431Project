package com.example.demo.DAO;

import com.example.demo.bean.Announcement;
import com.example.demo.bean.Course;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AnnouncementDAOImpl implements  AnnouncementDAO{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Announcement> viewALL() {
        String sql = "SELECT * FROM Announcement ORDER BY Date";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Announcement>(Announcement.class));
    }

    @Override
    public int publishAnn(int Manager_EID, String Content, String Title) {
        String sql = "Insert INTO Announcement(Title, Date, Content, EID) VALUES(?,DATE (NOW()), ?, ?)";
        return jdbcTemplate.update(sql,Title,Content,Manager_EID);
    }

    @Override
    public int updateAnn(int Manager_EID, String Content, String Title, Date date) {
        String sql = "UPDATE Announcement SET Content = ? WHERE Title = ? AND EID = ? AND Date = ?";
        return jdbcTemplate.update(sql,Content,Title,Manager_EID, date);
    }

    @Override
    public int deleteAnn(int Manager_EID,  String Title, Date date) {
        String sql = "DELETE FROM  Announcement WHERE Title = ? AND EID = ? AND Date = ?";
        return jdbcTemplate.update(sql,Title,Manager_EID, date);
    }

}
