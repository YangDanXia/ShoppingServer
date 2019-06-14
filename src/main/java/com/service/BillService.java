package com.service;

import com.dao.BillInfoMapper;
import com.dao.BillSumMapper;
import com.dao.ViewBillSumMapper;
import com.model.BillSum;
import com.model.MonthBill;
import com.model.ViewBillSum;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("BillService")
@Repository
public class BillService extends SuperService{
    @Resource
    BillSumMapper billSumMapper;
    @Resource
    ViewBillSumMapper viewBillSumMapper;
    @Resource
    BillInfoMapper billInfoMapper;

    @Override
    public int add(Object record) { return billSumMapper.insert((BillSum) record); }

    public List<ViewBillSum> selectAll(){ return viewBillSumMapper.selectAll(); }

    public BillSum select(String bId){
        return billSumMapper.selectByPrimaryKey(bId);
    }

    public List<ViewBillSum> selectByTime(Date content){
        return viewBillSumMapper.selectByTime(content);
    }

    public List<MonthBill> selectByMonth(Integer content){
        return viewBillSumMapper.selectByMonth(content);
    }

    @Override
    public int delete(String id) {
        int flag = 0;
        billInfoMapper.deleteByPrimaryKey(id);
        if(billSumMapper.deleteByPrimaryKey(id)!=0){
            flag = 1;
        }
        return flag;
    }



}
