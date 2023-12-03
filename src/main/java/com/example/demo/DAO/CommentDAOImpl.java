package com.example.demo.DAO;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    //user
    @Override
    public int leaveComment(int UID, String Content){
        return jdbcTemplate.update("insert into Comments(UID, Comment_Content) " +
                "values (?, ?)", UID, Content);
    }

    //admin
    @Override
    public List<String> seeAllComments() {
        String sql = "SELECT Comment_Content FROM Comments";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
