package com.dao;

import com.model.ViewBillDay;

import java.util.List;

public interface ViewBillDayMapper {
    List<ViewBillDay> selectByPrimaryKey(String bId);
}