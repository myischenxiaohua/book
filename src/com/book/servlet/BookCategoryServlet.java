package com.book.servlet;

import com.book.domian.BookCategory;
import com.book.service.impl.BookCategoryServiceImpl;
import com.book.util.WebUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
ClassName:${PACKAGE_NAME}
Description:
User: myischenxiaohua@163.com
Date: 2019-01-23
Time: 17:14
*/
public class BookCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        System.out.println(status);
        switch (status){
            case "add":add(request,response);break;
            case "list":list(request,response);break;
        }

    }
    public void add(HttpServletRequest request, HttpServletResponse response){}
    public void list(HttpServletRequest request, HttpServletResponse response){

        try {

            if(WebUtils.validateEmpty(request.getParameter("ajax"))){


            JSONArray jsonArray=new JSONArray();

                //response.getWriter().print(jsonArray.toString());
//                String jsonStr="";
//
                for (BookCategory bc : new BookCategoryServiceImpl().list()){

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
