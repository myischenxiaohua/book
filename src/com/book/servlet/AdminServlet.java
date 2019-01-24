package com.book.servlet;

import com.book.dao.impl.AdminDaoImpl;
import com.book.domian.Admin;
import com.book.service.impl.AdminServiceImpl;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.book.util.MD5Code;
import com.book.util.WebUtils;
import org.json.JSONObject;


public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        switch (status){
            case "login":try {
                    login(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "logout":logout(request,response); break;
            case "reg":reg(request,response); break;
            case "index" :
                try {
                    index(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "del":del(request,response);break;
            case "edit" :edit(request,response);break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception {
        int status=0;
        JSONObject jsonObject=new JSONObject();

        //获取页面中传递过来的数据
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String cheackCode=request.getParameter("code");

        String code=(String) request.getSession().getAttribute("code");
        if(cheackCode.equals(code)) {
            Admin admin=new Admin();
            admin.setName(user);
            admin.setPassword(new MD5Code().getMD5ofStr(user+password));
            if (new AdminServiceImpl().login(admin)) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("userId", admin.getId());
                request.getSession().setAttribute("lastdate", admin.getLastDate());
                request.getSession().setAttribute("flag", admin.getFlag());
                status = 1;
                jsonObject.put("url", "/book/admin/index.jsp");//跳转后台
                jsonObject.put("data", user);
            } else {
                //登录失败
                jsonObject.put("msg", "用户名或者密码错误");


            }
        }else {
            jsonObject.put("msg", "验证码错误");
        }


        jsonObject.put("status",status);
        response.getWriter().print(jsonObject.toString());

    }

    public void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String msg = "已经成功退出系统，请重新登录！";
        String url = "login.jsp";

        request.getSession().invalidate();//表示session失效

        request.setAttribute("msg", msg);
        request.setAttribute("url", url);

        request.getRequestDispatcher("/admin/forward.jsp").forward(request,response);


    }

    public void reg(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String url = "";
        String user=request.getParameter("user");
        String pwd=request.getParameter("password");
        String phone=request.getParameter("phone");
        short flag=Short.parseShort( request.getParameter("flag"));
        if(WebUtils.validateEmpty(user)&&WebUtils.validateEmpty(pwd)){
            Admin admin =new Admin();
            admin.setName(user);
            admin.setPassword(new MD5Code().getMD5ofStr(user+pwd));
            admin.setPhone(phone);
            admin.setFlag(flag);
            try {
                if(new AdminServiceImpl().insert(admin)){
                    msg = "添加成功";
                    url = "admin/AdminServlet/index";
                }else{
                    msg = "添加失败";
                    url = "/admin/user/add.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            msg = "用户名或密码不能为空！";
            url = "/admin/user/add.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        System.out.print(url);
        request.getRequestDispatcher("/admin/forward.jsp").forward(request,response);
    }

    public void index(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Integer currentPage = Integer.parseInt(request.getParameter("cp") == null ? "1" : request.getParameter("cp"));
        Integer lineSize = Integer.parseInt(request.getParameter("ls") == null ? "5" : request.getParameter("ls"));
        String keyWord = request.getParameter("key")==null?"":request.getParameter("key");
        String column = request.getParameter("col")==null?"name":request.getParameter("col");
        Map<String,Object> map = new AdminServiceImpl().listBySplit(column, keyWord, currentPage, lineSize);
        request.setAttribute("admins", map.get("admins"));
        request.setAttribute("allRecorders", map.get("recordSize"));
        request.setAttribute("url", "/book/admin/AdminServlet/index");
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("keyWord", keyWord);
        request.getRequestDispatcher("/admin/user/index.jsp").forward(request,response);
    }
    public void del(HttpServletRequest request,HttpServletResponse response){
        int status=0;
        Integer id=Integer.parseInt(request.getParameter("id"));
        JSONObject jsonObject=new JSONObject();
        try {
            if(new AdminServiceImpl().delById(id)){
                jsonObject.put("url","/book/admin/user/index.jsp");
                jsonObject.put("msg","删除成功");
                status=1;
            }else {
                jsonObject.put("msg","删除失败");
            }
            jsonObject.put("status",status);
            System.out.println(status);
            response.getWriter().print(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void edit(HttpServletRequest request,HttpServletResponse response){
        int status=0;
        Admin admin=new Admin();
        Integer id=Integer.parseInt(request.getParameter("id"));
        admin.setId(id);
        admin.setName(request.getParameter("user"));
        admin.setPassword(request.getParameter("pwd"));
        admin.setPhone(request.getParameter("phone"));
        admin.setFlag(Short.parseShort(request.getParameter("flag")));
        admin.setStatus(Short.parseShort(request.getParameter("status")));

        JSONObject jsonObject=new JSONObject();
        try {
            if(new AdminServiceImpl().edit(admin)){
                jsonObject.put("url","/book/admin/AdminServlet/index");
                jsonObject.put("msg","编辑成功");
                status=1;
            }else {
                jsonObject.put("msg","编辑失败");
            }
            jsonObject.put("status",status);
            System.out.println(status);
            response.getWriter().print(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }






}
