package com.dao;

import com.model.ViewProductCal;

public interface ViewProductCalMapper {
    int insert(ViewProductCal record);

    int insertSelective(ViewProductCal record);
}