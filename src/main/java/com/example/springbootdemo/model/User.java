package com.example.springbootdemo.model;

public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreat;
    private long gmtModified;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(long gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    public long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(long gmtModified) {
        this.gmtModified = gmtModified;
    }
}
