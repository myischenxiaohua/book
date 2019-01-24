package com.book.servlet;

import com.book.domian.BookCase;
import com.book.domian.BookCategory;
import com.book.service.impl.ConfigServiceImpl;
import com.book.util.WebUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
ClassName:${PACKAGE_NAME}
Description:配置管理servlet
User: myischenxiaohua@163.com
Date: 2019-01-24
Time: 9:23
*/
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "addBookCase":addBookCase(request,response);break;
            case "bookCaseList":bookCaseList(request,response);break;
        }

    }
    public void addBookCase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String url = "";
        BookCase bookCase=new BookCase();
        bookCase.setName(request.getParameter("name"));
        try {
           if(new ConfigServiceImpl().insertBookCase(bookCase)){
               msg="添加成功";
               url="admin/ReaderServlet/index";
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        request.getRequestDispatcher("/admin/forward.jsp").forward(request,response);
    }
    public void bookCaseList(HttpServletRequest request, HttpServletResponse response){
        try {

            if(WebUtils.validateEmpty(request.getParameter("ajax"))){

                JSONArray jsonArray=new JSONArray();

                for (BookCase bc : new ConfigServiceImpl().getBookCaseList()){

                    jsonArray.put(new JSONObject(bc));
                }
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("status",1);
                jsonObject.put("data",jsonArray);
                response.getWriter().print(jsonObject.toString());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
