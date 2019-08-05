package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified},#{avatarUrl})")
    void insert(User user);//mybati会自动将user的name，accountId等属性填充到#后, 前提是类
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);//String不是类，需要在前加注解
    @Select("select * from user where id=#{id}")
    User findById(@Param("id")Integer creator);
}
