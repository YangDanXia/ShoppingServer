package com.dao;

import com.model.ViewSale;

import java.util.List;

public interface ViewSaleMapper {
    List<ViewSale> selectAllType();
    List<ViewSale> selectAllBrand();
}