package com.book.servlet; /*
 ClassName:com.book.servlet
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-22
 Time: 21:40
 */

import com.book.dao.impl.ReaderDaoImpl;
import com.book.domian.Reader;
import com.book.service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){

            case "add":add(request,response); break;

        }
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String url = "";
        String name=request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        String card=request.getParameter("card");
        short sex=Short.parseShort(request.getParameter("sex"));
        String phone= request.getParameter("phone");
        Reader reader=new Reader();
        reader.setName(name);
        reader.setAge(age);
        reader.setCard(card);
        reader.setSex(sex);
        reader.setPhone(phone);
        try {
            if(new ReaderServiceImpl().insert(reader)){
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



}
