package com.service;

import java.util.List;

public abstract class SuperService {
//    添加内容
    public abstract int add(Object record);
//    查询所有
    public abstract List<?> selectAll();
//    查询个别
    public abstract Object select(String id);
//    删除记录
    public abstract int delete(String id);

}
