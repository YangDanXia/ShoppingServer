package com.dao;

import com.model.ViewProductShow;

import java.util.List;

public interface ViewProductShowMapper {
    List<ViewProductShow> selectByType(String type);
}