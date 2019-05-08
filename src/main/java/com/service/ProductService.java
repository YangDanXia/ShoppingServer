package com.service;

import com.dao.ViewProductCalMapper;
import com.model.ViewProductCal;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProductService")
@Repository
public class ProductService extends SuperService{
    @Resource
    ViewProductCalMapper vProductCalMapper;

    @Override
    public int add(Object record) {
        return 0;
    }

    @Override
    public List<?> selectAll() {
        return null;
    }

    public ViewProductCal select(String id) {
        return vProductCalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
