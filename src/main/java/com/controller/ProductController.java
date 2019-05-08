package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.ProductService;
import com.utils.CtxUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
public class ProductController extends SuperController{
    public ProductService productService = CtxUtil.getBean(ProductService.class);

    @RequestMapping(value="/showGoodsList", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品列表")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    @RequestMapping(value="/showGoods", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品信息")
    @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void toJson(JSONObject obj, Object item) {

    }
}
