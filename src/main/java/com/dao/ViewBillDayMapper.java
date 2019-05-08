package com.dao;

import com.model.ViewBillDay;

public interface ViewBillDayMapper {
    int insert(ViewBillDay record);

    int insertSelective(ViewBillDay record);
}