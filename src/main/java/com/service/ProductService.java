package com.service;

import com.dao.ProductInfoMapper;
import com.dao.ProductPriceMapper;
import com.dao.ProductStorageMapper;
import com.dao.ViewProductCalMapper;
import com.model.ProductInfo;
import com.model.ProductPrice;
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
    ProductPriceMapper productPriceMapper;
    @Resource
    ProductStorageMapper productStorageMapper;

    @Transactional
    @Override
    public int add(Object record){
        ProductInfo info = (ProductInfo) record;
        productInfoMapper.insert(info);
        ProductPrice productPrice = new ProductPrice();
        productPrice.setpId(info.getpId());
        productPrice.setActual_price(info.getActual_price());
        productPrice.setDiscout(0);
        productPrice.setProfit_price(info.getProfit_price());
        productPrice.setRecommend_prcie(info.getRecommend_prcie());
        productPrice.setUnit_price(info.getUnit_price());
        productPrice.setUnit_priceCode(info.getUnit_priceCode());
        productPriceMapper.insert(productPrice);
        ProductStorage productStorage = new ProductStorage();
        productStorage.setpId(info.getpId());
        productStorage.setSale_totalQty(0);
        productStorage.setRest_qty(info.getRest_qty());
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
        return 0;
    }
}
