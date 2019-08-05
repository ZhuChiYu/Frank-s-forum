package com.example.springbootdemo.dto;

import lombok.Data;
//dto传输层
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}