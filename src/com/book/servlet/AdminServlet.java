package com.book.servlet;

import com.book.dao.impl.AdminDaoImpl;
import com.book.domian.Admin;
import com.book.service.impl.AdminServiceImpl;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.System.out;

public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "login":
                try {
                    login(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception {
        int status=0;
        JSONObject jsonObject=new JSONObject();
        Admin admin=new Admin();
        //获取页面中传递过来的数据
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String cheackCode=request.getParameter("code");
        admin.setName(user);
        admin.setPassword(password);
        String code=(String) request.getSession().getAttribute("code");
        if(cheackCode.equals(code)) {

            if (new AdminServiceImpl().login(admin)) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("lastdate", admin.getLastDate());
                request.getSession().setAttribute("flag", admin.getFlag());
                status = 1;
                jsonObject.put("url", "/book/admin/index.jsp");//跳转后台
                jsonObject.put("data", user);
            } else {
                //登录失败
                jsonObject.put("msg", "用户名或者密码错误");


            }
        }else {
            jsonObject.put("msg", "验证码错误");
        }


        jsonObject.put("status",status);
        response.getWriter().print(jsonObject.toString());

    }
}
