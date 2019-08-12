package com.example.springbootdemo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试～"),
    TARGET_PARAM_NOT_FOUND(2002,"未选择任何问题或评论进行回复"),
    NO_LOGIN(2003,"未登陆不能进行评论，请登录～"),
    SYS_ERROR(2004,"服务冒烟了，要不你稍后再试试～"),
    TYPE_PARAM_ERROR(2005,"评论类型错误，或不存在～"),
    COMMENT_NOT_ERROR(2006,"回复的评论不存在，要不换个试试～")
    ;

     ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;

    private Integer code;
    CustomizeErrorCode(Integer code, String message){

        this.message=message;
        this.code=code;
    }


}
