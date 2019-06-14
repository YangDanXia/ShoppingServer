package com.dao;

import com.model.ProductStorage;

public interface ProductStorageMapper {
    int deleteByPrimaryKey(String pId);

    int insert(ProductStorage record);

    int insertSelective(ProductStorage record);

    ProductStorage selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(ProductStorage record);

    int updateByPrimaryKey(ProductStorage record);

    //    修改销售状态
    int updateSell(String pId,Integer isSell);
    int updateQty(String pId,Integer qty);
}