package com.book.servlet;

import com.book.domian.Books;
import com.book.domian.LendBook;
import com.book.domian.Reader;
import com.book.service.impl.BooksServiceImpl;
import com.book.service.impl.LendServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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

        Reader reader=new Reader();
        reader.setId(Integer.parseInt(request.getParameter("reader")));
        Books book=new Books();
        book.setIsbn(request.getParameter("isbn"));
        book.setExtant(Integer.parseInt(request.getParameter("extant"))-1);
        LendBook lendBook=new LendBook();
        lendBook.setBook(book);
        lendBook.setReader(reader);
        lendBook.setCredate(new Timestamp(new Date().getTime()));
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH,5);
        lendBook.setRetdate(new Timestamp(c.getTime().getTime()));
        JSONObject jsonObject=new JSONObject();
        String msg="";
        int status=0;
        try {
            if(new LendServiceImpl().insert(lendBook)){
                new BooksServiceImpl().updateExtant(book);
                status=1;
                msg="借阅成功";


            }else {
                msg="借阅失败";
            }
            jsonObject.put("status",status);
            jsonObject.put("msg",msg);
            response.getWriter().print(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
