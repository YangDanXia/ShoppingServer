package com.service;

import com.dao.BillInfoMapper;
import com.dao.ProductStorageMapper;
import com.dao.ViewBillDayMapper;
import com.dao.ViewSaleMapper;
import com.model.BillInfo;
import com.model.ProductStorage;
import com.model.ViewBillDay;
import com.model.ViewSale;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProductInBillService")
public class ProductInBillService extends SuperService {
    @Resource
    BillInfoMapper billInfoMapper;
    @Resource
    ProductStorageMapper productStorageMapper;
    @Resource
    ViewSaleMapper viewSaleMapper;
    @Resource
    ViewBillDayMapper viewBillDayMapper;

    @Override
    public int add(Object record) {
        BillInfo info = (BillInfo) record;
        billInfoMapper.insert(info);
        //        更新库存表
        ProductStorage productStorage = new ProductStorage();
        productStorage.setpId(info.getpId());
        productStorage.setSale_totalQty(info.getSale_totalQty());
        productStorage.setRest_qty(info.getRest_qty());
        productStorage.setIsSelling(info.getIsSelling());
        return productStorageMapper.updateByPrimaryKey(productStorage);
    }


    @Override
    public List<?> selectAll() {
        return null;
    }

    @Override
    public List<ViewBillDay> select(String id) {
        return viewBillDayMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    //    商品是否存在
    public BillInfo isExist(String bId, String pId){
        return billInfoMapper.selectByPrimaryKey(bId,pId);
    }

//    查看商品销售情况
    public List<ViewSale> selectBrandSale(){
        return viewSaleMapper.selectAllBrand();
    }

    public List<ViewSale> selectTypeSale(){
        return viewSaleMapper.selectAllType();
    }
}
