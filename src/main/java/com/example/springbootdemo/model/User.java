package com.example.springbootdemo.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreat;
    private long gmtModified;
    private String avatarUrl;
}