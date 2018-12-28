package com.book.servlet;

import java.io.IOException;
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
    public String login(HttpServletRequest request){
        String msg = ""; //表示提示信息
        String url = ""; //表示跳转路径

        //获取页面中传递过来的数据
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        return url;
    }
}
