package com.example.demo.Service;

import java.util.List;

public interface CommentService {
    public int leaveComment(int UID, String Content);

    public List<String> seeAllComments();
}
