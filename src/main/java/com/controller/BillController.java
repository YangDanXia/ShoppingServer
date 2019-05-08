package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.BillSum;
import com.service.BillService;
import com.utils.CtxUtil;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@ResponseBody
@Api(tags = "賬單管理接口",description = "賬單管理相關操作说明")
public class BillController extends SuperController {
    public BillService billService = CtxUtil.getBean(BillService .class);


    @RequestMapping(value="/addBill", method= RequestMethod.POST)
    @ApiOperation(value = "添加賬單")
    @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //   獲取時間
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(new Date());
        String bId = request.getParameter("bId");
        BillSum insertInfo = new BillSum(bId,0,0,0,date);
        BillSum isExist = billService.select(bId);
        insert(response,isExist,insertInfo,billService);
    }


    @RequestMapping(value="/addBillInfo", method= RequestMethod.POST)
    @ApiOperation(value = "添加賬單的商品內容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query")
    })
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void addBillInfo(){

    }


    @RequestMapping(value="/addBillSum", method= RequestMethod.POST)
    @ApiOperation(value = "汇总賬單的收益")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "price",value="账单总收入",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name = "profit",value="账单总利润",dataType="Integer",paramType = "query"),
            @ApiImplicitParam(name = "qty",value="商品总数",dataType="Integer",paramType = "query")
    })
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void addBillSum(){

    }


    @RequestMapping(value="/showBill", method= RequestMethod.GET)
    @ApiOperation(value = "顯示賬單列表")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    @RequestMapping(value="/showBillDetail", method= RequestMethod.GET)
    @ApiOperation(value = "顯示賬單詳情")
    @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void toJson(JSONObject obj, Object item) {

    }
}
