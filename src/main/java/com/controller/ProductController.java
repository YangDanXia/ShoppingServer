package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.ViewProductCal;
import com.service.ProductService;
import com.utils.CtxUtil;
import io.swagger.annotations.Api;
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
@Api(tags = "商品管理接口",description = "商品相關操作说明")
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
        String pId = request.getParameter("pId");
        ViewProductCal isExist = productService.select(pId);
        selectSelective(response,isExist);
    }

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void toJson(JSONObject obj, Object item) {
        ViewProductCal product = (ViewProductCal) item;
        obj.put("pId", product.getpId());
        obj.put("type", product.getpType());
        obj.put("brand", product.getpBrand());
        obj.put("supplier",product.getpSupplier());
        obj.put("year",product.getpYear());
        obj.put("priceCode",product.getUnit_priceCode());
        obj.put("actualPrice",product.getActual_price());
        obj.put("profit",product.getProfit_price());
        obj.put("saleQty",product.getSale_totalQty());
        obj.put("restQty",product.getRest_qty());
    }
}
