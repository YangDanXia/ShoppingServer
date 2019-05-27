package com.controller;

import com.alibaba.fastjson.JSONArray;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@Controller
@ResponseBody
@Api(tags = "商品管理接口",description = "商品相关操作说明")
public class ProductController extends SuperController{
    public ProductService productService = CtxUtil.getBean(ProductService.class);

    @RequestMapping(value="/showGoodsList", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品列表")
    @ApiImplicitParam(name = "from",value="商品类型",dataType="int",paramType = "query")
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer from = Integer.parseInt(request.getParameter("from"));
        List<ViewProductCal> allInfo = productService.selectAll(from);
        select(response,allInfo);
    }


    @RequestMapping(value="/showGoods", method= RequestMethod.GET)
    @ApiOperation(value = "顯示商品信息")
    @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query")
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
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
            @ApiImplicitParam(name = "unitPrice",value="进价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "recommend_price",value="实际售价",dataType="int",paramType = "query"),
            @ApiImplicitParam(name = "rest_qty",value="库存",dataType="int",paramType = "query")
    })
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
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
        Integer unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
        Integer recommend_price= Integer.parseInt(request.getParameter("recommend_price"));
        Integer rest_qty= Integer.parseInt(request.getParameter("rest_qty"));
        ProductInfo insertInfo = new ProductInfo(pId,name,type,brand,supplier,year,image,from,"",unitPrice,recommend_price);
        insertInfo.setRest_qty(rest_qty);
        ProductInfo isExist = productService.isExist(pId);
        insert(response,isExist,insertInfo,productService);
    }

    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @RequestMapping(value="/deleteProduct", method= RequestMethod.POST)
    @ApiOperation(value = "顯示商品信息")
    @ApiImplicitParam(name = "pId",value="商品編號",dataType="String",paramType = "query")
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pId = request.getParameter("pId");
        int isDelete = productService.delete(pId);
        delete(response,isDelete);
    }

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * 上传数据及保存文件
     */
    @RequestMapping(value="/upLoadImage", method= RequestMethod.POST)
    @ApiOperation(value = "上传图片")
    @ApiResponse(response = ProductController.class,code=200,message = "返回对象参数")
    public void uoLoadImage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        // 检测是否为多媒体上传

        PrintWriter w = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getSession().getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            JSONObject json = new JSONObject();
            JSONArray jsonArr = new JSONArray();
            if (formItems != null && formItems.size() > 0) {
                json.put("code", 0);
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        jsonArr.add(filePath);
                    }
                }
                json.put("data",jsonArr);
                w.print(json);
            }
        } catch (Exception ex) {
            w.print(ex.getMessage());
        }
    }


}
