package com.book.servlet;

import com.book.dao.impl.AdminImpl;
import com.book.domian.Admin;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp";	//定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "login":path=login(request);break;
        }
        request.getRequestDispatcher(path).forward(request, response);//转发jsp页面
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    public String login(HttpServletRequest request) {
        String msg = ""; //表示提示信息
        String url = ""; //表示跳转路径
        Admin admin=new Admin();
        //获取页面中传递过来的数据
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        admin.setName(user);
        admin.setPassword(password);
        AdminImpl adminImpl=new AdminImpl();
        try {
            admin=adminImpl.login(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Objects.nonNull(admin.getPassword())){
            url="/index.jsp";
        }
        System.out.println(url);
        return url;
    }
}
