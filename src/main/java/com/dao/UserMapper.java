package com.dao;

import com.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String uTel);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uTel);

    List<User> selectAll();


    int updatePasswd(String uTel);

    int updateCredit(String uTel,Integer credit);
}