package com.dao;

import com.model.ProductInfo;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(String pId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}