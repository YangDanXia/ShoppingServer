package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.service.VipService;
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
@Api(tags = "會員相關操作接口",description = "會員相關操作说明")
public class VipController extends SuperController {
    private VipService vipService = CtxUtil.getBean(VipService.class);

    @RequestMapping(value = "/showVip", method = RequestMethod.GET)
    @ApiOperation(value = "查看所有會員信息")
    @ApiResponse(response = MemberController.class, code = 200, message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> allInfo = vipService.selectAll();
        select(response, allInfo);
    }

    @RequestMapping(value = "/showVipSelective", method = RequestMethod.GET)
    @ApiOperation(value = "查詢指定會員信息")
    @ApiImplicitParam(name = "tel", value = "手机号", dataType = "String", paramType = "query")
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        User isExist = vipService.select(tel);
        selectSelective(response, isExist);
    }


    @RequestMapping(value = "/addVip", method = RequestMethod.POST)
    @ApiOperation(value = "添加會員")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "passwd", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "credit", value = "積分", dataType = "String", paramType = "query")
    })
    @ApiResponse(response = MemberController.class, code = 200, message = "返回对象参数")
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");
        Integer credit = Integer.parseInt(request.getParameter("credit"));
        User insertInfo = new User(tel, passwd, name, credit);
//        查詢該編號是否存在
        User isExist = vipService.select(tel);
        insert(response, isExist, insertInfo, vipService);
    }


    @RequestMapping(value = "/updateVipCredit", method = RequestMethod.POST)
    @ApiOperation(value = "更新指定會員積分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "credit", value = "積分", dataType = "int", paramType = "query")
    })
    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        Integer credit = Integer.parseInt(request.getParameter("credit"));
        int isUpdate = vipService.updateCredit(tel, credit);
        update(response, isUpdate);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


}
