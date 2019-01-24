package com.book.servlet;

import com.book.domian.Admin;
import com.book.domian.Books;
import com.book.service.impl.AdminServiceImpl;
import com.book.service.impl.BooksServiceImpl;
import com.book.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

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
            case "index" :index(request,response);break;
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
        books.setAdminId((Integer) request.getSession().getAttribute("userId"));
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
            }else {
                msg="添加失败";
                url="admin/BookServlet/add";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        request.getRequestDispatcher("/admin/forward.jsp").forward(request,response);

    }
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("url", "/book/admin/BookServlet/index");
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("keyWord", keyWord);
        request.getRequestDispatcher("/admin/book/index.jsp").forward(request,response);
    }
}
