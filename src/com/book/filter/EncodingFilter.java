package com.book.filter; /*
 ClassName:com.book.filter
 Description:
 User: myischenxiaohua@163.com
 Date: 2019-01-03
 Time: 21:26
 */

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);	//放行


    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}
