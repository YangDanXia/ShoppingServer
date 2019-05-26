package com.dao;

import com.model.BillSum;

import java.util.List;

public interface BillSumMapper {
    int deleteByPrimaryKey(String bId);

    int insert(BillSum record);

    int insertSelective(BillSum record);

    BillSum selectByPrimaryKey(String bId);

    List<BillSum> selectByTime(String create_time);

    List<BillSum> selectAll();

    int updateByPrimaryKeySelective(BillSum record);

    int updateByPrimaryKey(BillSum record);
}