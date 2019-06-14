package com.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.service.SuperService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public abstract class SuperController {
    //    显示列表
    public abstract void showList(HttpServletRequest request, HttpServletResponse response) throws IOException;
    //    显示详细内容
    public abstract void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException;
    //    添加内容
    public abstract void add(HttpServletRequest request, HttpServletResponse response) throws IOException;
    //    修改内容
    public abstract void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException;
    //    刪除内容
    public abstract void delete(HttpServletRequest request, HttpServletResponse response) throws IOException;


    //    查询所有信息
    public void select(HttpServletResponse response, List<?> allInfo) throws IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONArray jsonArr = new JSONArray();
        for(Object item: allInfo){
            jsonArr.add(item);
        }
        out.println(jsonArr);
        out.flush();
    }


    //    查询指定信息
    public void selectSelective(HttpServletResponse response,Object isExist)throws IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(isExist == null) {
            json.put("res", 0);
        }else{
            json.put("res",1);
            json.put("data",isExist);
        }
        out.println(json);
        out.flush();
    }


    //   添加具体内容
    public void insert(HttpServletResponse response, Object isExist,Object insertInfo, SuperService service)throws IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(isExist == null){
            int isSuccess = service.add(insertInfo);
            if(isSuccess == 1){
                json.put("res",1);
            }
        }else{
            json.put("res",0);
        }
        out.println(json);
        out.flush();
    }

    // 修改个别内容
    public void update(HttpServletResponse response,int isUpdate) throws IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(isUpdate== 1) {
            json.put("res", 1);
        }else{
            json.put("res",0);
        }
        out.println(json);
        out.flush();
    }

    // 删除内容
    public void delete(HttpServletResponse response,int isDelete) throws IOException{
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(isDelete== 1) {
            json.put("res", 1);
        }else if(isDelete == 500){
            json.put("res",500);
        }else{
            json.put("res",0);
        }
        out.println(json);
        out.flush();
    }

}
