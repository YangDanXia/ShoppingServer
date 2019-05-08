package com.dao;

import com.model.BillInfo;

public interface BillInfoMapper {
    int insert(BillInfo record);

    int insertSelective(BillInfo record);
}