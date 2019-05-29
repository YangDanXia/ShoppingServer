package com.dao;

import com.model.BillInfo;

import java.util.List;

public interface BillInfoMapper {
    int insert(BillInfo record);

    int insertSelective(BillInfo record);

    BillInfo selectByPrimaryKey(String bId,String pId);
    List<BillInfo> selectByPId(String pId);

    int deleteByPrimaryKey(String bId);
}