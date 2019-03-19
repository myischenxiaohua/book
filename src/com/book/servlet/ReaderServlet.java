package com.book.servlet; /*
 ClassName:com.book.servlet
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-22
 Time: 21:40
 */

import com.book.domian.Reader;
import com.book.service.impl.ReaderServiceImpl;
import com.book.util.WebUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
            case "index":index(request,response); break;
            case "all":all(request,response); break;

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
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer currentPage = Integer.parseInt(request.getParameter("cp") == null ? "1" : request.getParameter("cp"));
        Integer lineSize = Integer.parseInt(request.getParameter("ls") == null ? "5" : request.getParameter("ls"));
        String keyWord = request.getParameter("key")==null?"":request.getParameter("key");
        String column = request.getParameter("col")==null?"name":request.getParameter("col");
        Map<String,Object> map = null;
        try {
            map = new ReaderServiceImpl().listBySplit(column, keyWord, currentPage, lineSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("readers", map.get("readers"));
        request.setAttribute("allRecorders", map.get("recordSize"));
        request.setAttribute("url", "/book/admin/ReaderServlet/index");
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("keyWord", keyWord);
        request.getRequestDispatcher("/admin/reader/index.jsp").forward(request,response);

    }

    public void all(HttpServletRequest request,HttpServletResponse response){

        try {

            if(WebUtils.validateEmpty(request.getParameter("ajax"))){
                JSONArray jsonArray=new JSONArray();
                for (Reader reader : new ReaderServiceImpl().list()){

                    jsonArray.put(new JSONObject(reader));

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
