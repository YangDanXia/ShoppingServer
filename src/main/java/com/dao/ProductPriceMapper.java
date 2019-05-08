package com.dao;

import com.model.ProductPrice;

public interface ProductPriceMapper {
    int deleteByPrimaryKey(String pId);

    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    ProductPrice selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(ProductPrice record);

    int updateByPrimaryKey(ProductPrice record);
}