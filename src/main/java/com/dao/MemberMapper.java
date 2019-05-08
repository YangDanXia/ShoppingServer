package com.dao;

import com.model.Member;

import java.util.List;

public interface MemberMapper {

//    添加管理者/股东
    int insert(Member record);

//    删除管理者/股东
    int deleteByPrimaryKey(String mTel);

//    修改管理者/股东密码
    int updatePasswd(String mTel);


//    查看管理者/股东信息
//    管理者/股东登录
    Member selectByTel(String mTel);
    List<Member> selectAll();

}