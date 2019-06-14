package com.dao;

import com.model.MonthBill;
import com.model.ViewBillSum;

import java.util.Date;
import java.util.List;

public interface ViewBillSumMapper {
    List<ViewBillSum> selectByTime(Date create_time);

    List<MonthBill> selectByMonth(Integer year);

    List<ViewBillSum> selectAll();

}