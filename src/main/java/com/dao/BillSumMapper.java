package com.dao;

import com.model.BillSum;


public interface BillSumMapper {
    int deleteByPrimaryKey(String bId);

    int insert(BillSum record);

    int insertSelective(BillSum record);

    BillSum selectByPrimaryKey(String bId);
//
//    List<BillSum> selectByTime(Date create_time);
//
//    List<BillSum> selectAll();
}