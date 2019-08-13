package com.example.springbootdemo.dto;

import com.example.springbootdemo.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long parentID;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
