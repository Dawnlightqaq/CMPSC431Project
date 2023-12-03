package com.example.demo.DAO;


import java.util.List;

public interface CommentDAO {
    public int leaveComment(int UID, String Content);

    public List<String> seeAllComments();
}
