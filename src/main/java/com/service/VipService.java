package com.service;

import com.dao.UserMapper;
import com.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("UserService")
@Repository
public class VipService extends SuperService{
    @Resource
    UserMapper userMapper;


    @Override
    public int add(Object record) { return userMapper.insert((User)record); }

    public User select(String uTel){ return userMapper.selectByPrimaryKey(uTel); }

    public List<User> selectAll(){ return userMapper.selectAll(); }

    @Override
    public int delete(String id) { return 0; }

    //    修改會員密码
    public int updatePasswd(String tel){
        return userMapper.updatePasswd(tel);
    }

    //    修改會員積分
    public int updateCredit(String tel,Integer credit){
        return userMapper.updateCredit(tel,credit);
    }


}
