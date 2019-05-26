package com.service;

import com.dao.BillInfoMapper;
import com.dao.BillSumMapper;
import com.model.BillInfo;
import com.model.BillSum;
import com.model.ViewBillDay;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BillService")
@Repository
public class BillService extends SuperService{
    @Resource
    BillSumMapper billSumMapper;
    @Resource
    BillInfoMapper billInfoMapper;

    @Override
    public int add(Object record) { return billSumMapper.insert((BillSum) record); }

    public List<BillSum> selectAll(){ return billSumMapper.selectAll(); }

    public BillSum select(String bId){
        return billSumMapper.selectByPrimaryKey(bId);
    }

    public List<BillSum> selectByTime(String content){
        return billSumMapper.selectByTime(content);
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

    //    修改賬單信息
    public int update(BillSum bill){
        return billSumMapper.updateByPrimaryKey(bill);
    }


}
