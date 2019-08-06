package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified},#{avatarUrl})")
    void insert(User user);//mybati会自动将user的name，accountId等属性填充到#后, 前提是类
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);//String不是类，需要在前加注解
    @Select("select * from user where id=#{id}")
    User findById(@Param("id")Integer creator);
    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId")String accountId);
    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
