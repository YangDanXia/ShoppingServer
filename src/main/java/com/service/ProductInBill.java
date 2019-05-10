package com.service;

import com.dao.BillInfoMapper;
import com.dao.ProductStorageMapper;
import com.model.BillInfo;
import com.model.ProductStorage;

import javax.annotation.Resource;
import java.util.List;

public class ProductInBill extends SuperService {
    @Resource
    BillInfoMapper billInfoMapper;
    @Resource
    ProductStorageMapper productStorageMapper;

    @Override
    public int add(Object record) {
        BillInfo info = (BillInfo) record;
        billInfoMapper.insert(info);
        //        更新库存表
        ProductStorage productStorage = new ProductStorage();
        productStorage.setpId(info.getpId());
        productStorage.setSale_totalQty(info.getSale_totalQty());
        productStorage.setRest_qty(info.getRest_qty());
        return productStorageMapper.updateByPrimaryKey(productStorage);
    }


    @Override
    public List<?> selectAll() {
        return null;
    }

    @Override
    public Object select(String id) {
        return null;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    //    商品是否存在
    public BillInfo isExist(String bId, String pId){
        return billInfoMapper.selectByPrimaryKey(bId,pId);
    }
}
