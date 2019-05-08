package com.service;

import com.dao.ViewProductCalMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ProductService")
@Repository
public class ProductService {
    @Resource
    ViewProductCalMapper vProductCalMapper;
}
