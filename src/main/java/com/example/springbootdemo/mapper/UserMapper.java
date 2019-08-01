package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified)" +
            " values(#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified})")
    void insert(User user);//mybati会自动将user的name，accountId等属性填充到#后

}
