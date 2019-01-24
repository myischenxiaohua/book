package com.book.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
ClassName:${PACKAGE_NAME}
Description:借阅
User: myischenxiaohua@163.com
Date: 2019-01-24
Time: 16:38
*/
public class LendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "index" : index(request,response);break;
            case "add":add(request,response);break;
        }



    }


    public void  index(HttpServletRequest request, HttpServletResponse response){
    
    }
    public void add(HttpServletRequest request, HttpServletResponse response){

    }

}
