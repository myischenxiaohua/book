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
    private String encoding=null;
    @Override
    public void destroy() {
        encoding=null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

            request.setCharacterEncoding(this.encoding);
            response.setCharacterEncoding(this.encoding);
            chain.doFilter(request, response);	//放行

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
       String encoding= config.getInitParameter("encoding");
       if(this.encoding==null) {
           this.encoding = encoding;
       }

    }
}
