package com.service;

import com.dao.ProductInfoMapper;
import com.dao.ProductStorageMapper;
import com.dao.ViewProductCalMapper;
import com.model.ProductInfo;
import com.model.ProductStorage;
import com.model.ViewProductCal;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("ProductService")
@Repository
public class ProductService extends SuperService{
    @Resource
    ViewProductCalMapper vProductCalMapper;
    @Resource
    ProductInfoMapper productInfoMapper;
    @Resource
    ProductStorageMapper productStorageMapper;

    @Transactional
    @Override
    public int add(Object record){
        ProductInfo info = (ProductInfo) record;
        productInfoMapper.insert(info);
        ProductStorage productStorage = new ProductStorage();
        productStorage.setpId(info.getpId());
        productStorage.setSale_totalQty(0);
        productStorage.setRest_qty(info.getRest_qty());
        productStorage.setIsSelling(1);
        return productStorageMapper.insert(productStorage);
    }


    public List<ViewProductCal> selectAll() {
        return vProductCalMapper.selectAll();
    }

    public List<ViewProductCal> selectAll(int from) {
        return vProductCalMapper.selectAllByFrom(from);
    }

//    商品是否存在
    public ProductInfo isExist(String id){
        return productInfoMapper.selectByPrimaryKey(id);
    }

//    查询商品详情
    public ViewProductCal select(String id) {
        return vProductCalMapper.selectByPrimaryKey(id);
    }



    @Override
    public int delete(String id) {
        int flag = 0;
        if(productStorageMapper.deleteByPrimaryKey(id)!=0){
                if(productInfoMapper.deleteByPrimaryKey(id)!=0){
                    flag = 1;
                }
        }
        return flag;
    }
}
