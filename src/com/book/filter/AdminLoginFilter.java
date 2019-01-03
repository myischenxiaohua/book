package com.book.filter; /*
 ClassName:com.book.filter
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-03
 Time: 21:30
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminLoginFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest)request;
        HttpSession session = hRequest.getSession();
        String uid = (String)session.getAttribute("uuid");
        HttpServletRequest req = (HttpServletRequest)request;
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if("login".equals(status) || uid != null){//用户登录操作、用户已经登录可以通过
            chain.doFilter(request, response);
        } else {
            request.setAttribute("msg", "还未登陆，请先登录后操作。");
            request.setAttribute("url", "login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
