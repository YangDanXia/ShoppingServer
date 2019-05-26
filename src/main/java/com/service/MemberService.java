package com.service;

import com.dao.MemberMapper;
import com.model.Member;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("MemberService")
@Repository
public class MemberService extends SuperService {
    @Resource
    MemberMapper memMapper;

    @Override
    public int add(Object record) { return memMapper.insert((Member) record); }

    public List<Member> selectAll(){
        return memMapper.selectAll();
    }

    public Member select(String mTel){
        return memMapper.selectByTel(mTel);
    }

    public Member select(String mTel,String mPasswd ){
        return memMapper.selectByTelAndPasswd(mTel,mPasswd);
    }

    public int delete(String mTel){ return memMapper.deleteByPrimaryKey(mTel); }

    //    修改管理者/股东密码
    public int updatePasswd(String mTel,String mPasswd){
        return memMapper.updatePasswd(mTel,mPasswd);
    }




}