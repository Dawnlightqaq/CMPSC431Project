package com.example.demo.Service;

import com.example.demo.DAO.CommentDAO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Resource
    private CommentDAO commentDAO;


    @Override
    public int leaveComment(int UID, String Content) {
        return commentDAO.leaveComment(UID, Content);
    }

    @Override
    public List<String> seeAllComments() {
        return commentDAO.seeAllComments();
    }
}
