package com.dao;

import com.model.ViewProductCal;

import java.util.List;

public interface ViewProductCalMapper {

    ViewProductCal selectByPrimaryKey(String pId);

    List<ViewProductCal> selectAll();

    List<ViewProductCal> selectAllByFrom(int from);
}