package com.service;

import com.dao.BillInfoMapper;
import com.dao.BillSumMapper;
import com.model.BillInfo;
import com.model.BillSum;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BillService")
@Repository
public class BillService extends SuperService{
    @Resource
    BillSumMapper billSumMapper;

    @Override
    public int add(Object record) { return billSumMapper.insert((BillSum) record); }

    public List<BillSum> selectAll(){ return billSumMapper.selectAll(); }

    public BillSum select(String bId){
        return billSumMapper.selectByPrimaryKey(bId);
    }

    @Override
    public int delete(String id) { return 0; }

    //    修改賬單信息
    public int update(BillSum bill){
        return billSumMapper.updateByPrimaryKey(bill);
    }


}
