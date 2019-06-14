package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.*;
import com.service.BillService;
import com.service.ProductInBillService;
import com.utils.CtxUtil;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@Api(tags = "账单管理接口",description = "账单管理相关操作说明")
public class BillController extends SuperController {
    public BillService billService = CtxUtil.getBean(BillService .class);
    public ProductInBillService productInBillService = CtxUtil.getBean(ProductInBillService.class);


    @RequestMapping(value="/addBill", method= RequestMethod.POST)
    @ApiOperation(value = "添加賬單")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "bDate",value="账单錄入時間",dataType="String",paramType = "query")
    })
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //   獲取時間
        try{
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date date = df.parse(request.getParameter("bDate"));
            String bId = request.getParameter("bId");
            BillSum insertInfo = new BillSum(bId,date);
            BillSum isExist = billService.select(bId);
            insert(response,isExist,insertInfo,billService);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }


    @RequestMapping(value="/addBillInfo", method= RequestMethod.POST)
    @ApiOperation(value = "添加賬單的商品內容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "saleQty",value="售出数量",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "actualPrice",value="实际售价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "totalPrice",value="总收入",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "totalProfit",value="总利润",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "saleTotalQty",value="售出总数量",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "restQty",value="商品库存",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "isSelling",value="商品上架",dataType="int",paramType = "query")
    })
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void addBillInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String bId = request.getParameter("bId");
        String pId = request.getParameter("pId");
        Integer saleQty = Integer.parseInt(request.getParameter("saleQty"));
        Integer totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
        Integer totalProfit = Integer.parseInt(request.getParameter("totalProfit"));
        Integer actualPrice = Integer.parseInt(request.getParameter("actualPrice"));
        Integer saleTotalQty = Integer.parseInt(request.getParameter("saleTotalQty"));
        Integer restQty = Integer.parseInt(request.getParameter("restQty"));
        Integer isSelling = Integer.parseInt(request.getParameter("isSelling"));
        BillInfo insertInfo = new BillInfo(bId,pId,saleQty,totalPrice,totalProfit,actualPrice);
        insertInfo.setSale_totalQty(saleTotalQty);
        insertInfo.setRest_qty(restQty);
        insertInfo.setIsSelling(isSelling);
        BillInfo isExist = productInBillService.isExist(bId,pId);
        insert(response,isExist,insertInfo,productInBillService);
    }



    @RequestMapping(value="/showBill", method= RequestMethod.GET)
    @ApiOperation(value = "顯示賬單列表")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ViewBillSum> allInfo = billService.selectAll();
        select(response,allInfo);
    }


    @RequestMapping(value="/showBillDetail", method= RequestMethod.GET)
    @ApiOperation(value = "顯示賬單詳情")
    @ApiImplicitParam(name = "bId",value="賬單編號",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bId = request.getParameter("bId");
        List<ViewBillDay> isExist = productInBillService.select(bId);
        select(response,isExist);
    }

    @RequestMapping(value="/showBillByTime", method= RequestMethod.GET)
    @ApiOperation(value = "顯示賬單詳情")
    @ApiImplicitParam(name = "content",value="查询日期",dataType="String",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void showBillByTime(HttpServletRequest request, HttpServletResponse response) throws IOException,ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date content = df.parse(request.getParameter("content"));
        List<ViewBillSum> isExist = billService.selectByTime(content);
        select(response,isExist);
    }

    @RequestMapping(value="/showMonthBill", method= RequestMethod.GET)
    @ApiOperation(value = "顯示每月賬單")
    @ApiImplicitParam(name = "content",value="查询日期",dataType="Integer",paramType = "query")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void showMonthBill(HttpServletRequest request, HttpServletResponse response) throws IOException,ParseException {
        Integer content = Integer.parseInt(request.getParameter("content"));
        List<MonthBill> isExist = billService.selectByMonth(content);
        select(response,isExist);
    }



    @RequestMapping(value="/showTypeSale", method= RequestMethod.GET)
    @ApiOperation(value = "显示商品销售情况")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void showTypeSale(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ViewSale> typeInfo = productInBillService.selectTypeSale();
        select(response,typeInfo);
    }

    @RequestMapping(value="/showBrandSale", method= RequestMethod.GET)
    @ApiOperation(value = "显示品牌销售情况")
    @ApiResponse(response = BillController.class,code=200,message = "返回对象参数")
    public void showBrandSale(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ViewSale> brandInfo = productInBillService.selectBrandSale();
        select(response,brandInfo);
    }

    @RequestMapping(value="/deleteBill", method= RequestMethod.POST)
    @ApiOperation(value = "删除账单信息")
    @ApiImplicitParam(name = "bId",value="账单編號",dataType="String",paramType = "query")
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bId = request.getParameter("bId");
        int isDelete = billService.delete(bId);
        delete(response,isDelete);
    }


    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
