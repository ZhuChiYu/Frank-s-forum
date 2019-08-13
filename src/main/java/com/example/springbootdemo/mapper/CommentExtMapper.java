package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.Comment;

public interface CommentExtMapper {
    Long incCommentCount(Comment comment);

}