package com.book.servlet;

import com.book.domian.Admin;
import com.book.domian.Books;
import com.book.service.impl.BooksServiceImpl;
import com.book.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/*
ClassName:${PACKAGE_NAME}
Description:
User: myischenxiaohua@163.com
Date: 2019-01-23
Time: 15:17
*/

public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "add" :add(request,response);break;
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String url = "";

        Books books=new Books();
        books.setIsbn(WebUtils.getUUID());
        books.setName(request.getParameter("name"));
        books.setCategoryId(Integer.parseInt(request.getParameter("category")));
        books.setBookcaseId(Integer.parseInt(request.getParameter("bookcase")));
        books.setAdminId(((Admin)request.getSession().getAttribute("user")).getId());
        books.setAuthor(request.getParameter("author"));
        books.setPublish(request.getParameter("publish"));
        books.setEdition(Integer.parseInt(request.getParameter("edition")));
        books.setPublishDate(WebUtils.formatDate(request.getParameter("publishdate")));
        books.setUnitprice(Double.parseDouble(request.getParameter("unitprice")) );
        books.setInventory(Integer.parseInt(request.getParameter("inventory")) );
        try {
            if(new BooksServiceImpl().insert(books)){
                msg="添加成功";
                url="admin/BookServlet/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        request.getRequestDispatcher("/admin/forward.jsp").forward(request,response);

    }
}
