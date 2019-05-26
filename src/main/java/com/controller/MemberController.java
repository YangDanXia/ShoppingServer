package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.Member;
import java.util.List;
import com.service.MemberService;
import com.utils.CtxUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@ResponseBody
@Api(tags = "管理員/股東相關操作接口",description = "管理員/股東相關操作说明")
public class MemberController extends SuperController{
    private static Logger log = LoggerFactory.getLogger(MemberController.class);
    private MemberService memService = CtxUtil.getBean(MemberService.class);


    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ApiOperation(value = "管理者/股东登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel",value="手机号",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "passwd",value="密码",dataType="String",paramType = "query")
    })
    @ApiResponse(response = MemberController.class,code=200,message = "返回对象参数")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        String passwd = request.getParameter("passwd");
        Member mem = memService.select(tel);
        //    返回数据
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        JSONObject mInfo = new JSONObject();
        if(mem == null){
            mInfo.put("res",0);
            mInfo.put("error","該手機號不存在");
        }else if(passwd.equals(mem.getmPasswd())){
            mInfo.put("res",1);
            mInfo.put("data",mem);
        }else{
            mInfo.put("res",0);
            mInfo.put("error","密碼錯誤");
        }
        out.println(mInfo);
        out.flush();
    }


    @RequestMapping(value="/showMem", method= RequestMethod.GET)
    @ApiOperation(value = "查看所有管理者/股东信息")
    @ApiResponse(response = MemberController.class,code=200,message = "返回对象参数")
    @Override
    public void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Member> allInfo = memService.selectAll();
        select(response,allInfo);
    }


    @RequestMapping(value="/addMem", method= RequestMethod.POST)
    @ApiOperation(value = "添加管理者/股东")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel",value="手机号",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "passwd",value="密码",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "name",value="姓名",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "privi",value="身份",dataType="String",paramType = "query")
    })
    @ApiResponse(response = MemberController.class,code=200,message = "返回对象参数")
    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");
        Integer privi =Integer.parseInt(request.getParameter("privi"));
        Member insertInfo = new Member(tel,passwd,name,privi);
//        查詢該編號是否存在
        Member isExist = memService.select(tel);
        insert(response,isExist,insertInfo,memService);
    }


    @RequestMapping(value="/alterPasswd", method= RequestMethod.POST)
    @ApiOperation(value = "管理者/股东修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel",value="手机号",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "passwdOld",value="原密码",dataType="String",paramType = "query"),
            @ApiImplicitParam(name = "passwdNew",value="新密码",dataType = "String",paramType = "query")
    })
    @ApiResponse(response = MemberController.class,code=200,message = "返回对象参数")
    public void alterPasswd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tel = request.getParameter("tel");
        String passwdOld = request.getParameter("passwdOld");
        String passwdNew = request.getParameter("passwdNew");
        Member mem = memService.select(tel,passwdOld);
        //    返回数据
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        JSONObject mInfo = new JSONObject();
        if(mem == null){
            mInfo.put("res",0);
            mInfo.put("error","手機號或原密碼錯誤");
        }else{
            int isChanged = memService.updatePasswd(tel,passwdNew);
            if(isChanged == 0){
                mInfo.put("res",0);
                mInfo.put("error","操作失敗");
            }else{
                mInfo.put("res",1);
                mInfo.put("error","修改成功");
            }

        }
        out.println(mInfo);
        out.flush();

    }
    @Override
    public void showSelective(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }




    @Override
    public void rewrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
