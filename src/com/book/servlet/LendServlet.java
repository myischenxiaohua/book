package com.book.servlet;

import com.book.service.impl.BooksServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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


    public void  index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer currentPage = Integer.parseInt(request.getParameter("cp") == null ? "1" : request.getParameter("cp"));
        Integer lineSize = Integer.parseInt(request.getParameter("ls") == null ? "5" : request.getParameter("ls"));
        String keyWord = request.getParameter("key")==null?"":request.getParameter("key");
        String column = request.getParameter("col")==null?"name":request.getParameter("col");
        Map<String,Object> map = null;
        try {
            map = new BooksServiceImpl().listBySplit(column, keyWord, currentPage, lineSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("books", map.get("books"));
        request.setAttribute("allRecorders", map.get("recordSize"));
        request.setAttribute("url", "/book/admin/LendServlet/index");
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("keyWord", keyWord);
        request.getRequestDispatcher("/admin/lend/index.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response){

    }

}
