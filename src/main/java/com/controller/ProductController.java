package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.ProductInfo;
import com.model.ViewProductCal;
import com.service.ProductService;
import com.utils.CtxUtil;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@ResponseBody
@Api(tags = "商品管理接口",description = "商品相关操作说明")
public class ProductController extends SuperController{
    public ProductService productService = CtxUtil.getBean(ProductService.class);

    @RequestMapping(value="/showGoodsList", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品列表")
    @ApiImplicitParam(name = "from",value="商品类型",dataType="int",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer from = Integer.parseInt(request.getParameter("from"));
        List<ViewProductCal> allInfo = productService.selectAll(from);
        select(response,allInfo);
    }


    @RequestMapping(value="/showGoods", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品信息")
    @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pId = request.getParameter("pId");
        ViewProductCal isExist = productService.select(pId);
        selectSelective(response,isExist);
    }



    @RequestMapping(value="/addProduct", method= RequestMethod.POST)
    @ApiOperation(value = "添加商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pId",value="商品编号",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "name",value="商品名称",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "type",value="商品种类",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "brand",value="商品品牌",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "supplier",value="商品供应商",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "year",value="商品年份",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "image",value="商品图片",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "from",value="商品货源",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "priceCode",value="进价代码",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "unitPrice",value="进价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "recommendPrice",value="推荐售价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "actual_price",value="实际售价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "profit_price",value="利润",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "rest_qty",value="库存",dataType="int",paramType = "query")
    })
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pId = request.getParameter("pId");
        String name= request.getParameter("name");
        String type= request.getParameter("type");
        String brand= request.getParameter("brand");
        String supplier= request.getParameter("supplier");
        String year= request.getParameter("year");
        String image = request.getParameter("image");
        Integer from = Integer.parseInt(request.getParameter("from"));
//        String fromName = request.getParameter("fromName");
        String priceCode= request.getParameter("priceCode");
        Integer unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
        Integer recommendPrice = Integer.parseInt(request.getParameter("recommendPrice"));
        Integer actual_price= Integer.parseInt(request.getParameter("actual_price"));
        Integer profit_price= Integer.parseInt(request.getParameter("profit_price"));
        Integer rest_qty= Integer.parseInt(request.getParameter("rest_qty"));
        ProductInfo insertInfo = new ProductInfo(pId,name,type,brand,supplier,year,image,from,"");
        insertInfo.setUnit_priceCode(priceCode);
        insertInfo.setUnit_price(unitPrice);
        insertInfo.setRecommend_prcie(recommendPrice);
        insertInfo.setProfit_price(profit_price);
        insertInfo.setActual_price(actual_price);
        insertInfo.setRest_qty(rest_qty);
        ProductInfo isExist = productService.isExist(pId);
        insert(response,isExist,insertInfo,productService);
    }

    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}
