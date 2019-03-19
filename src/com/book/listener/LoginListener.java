package com.book.listener;/*
ClassName:${PACKAGE_NAME}
Description:
User: myischenxiaohua@163.com
Date: 2019-03-19
Time: 20:59
*/

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class LoginListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private int count;

    // Public constructor is required by servlet spec
    public LoginListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        Integer count=null;
        Object sessionCount=se.getSession().getServletContext().getAttribute("sessionCount");
        if(sessionCount==null){
            count=0;
        }else {
            count=Integer.parseInt(sessionCount.toString());
        }
        count++;
        se.getSession().getServletContext().setAttribute("sessionCount",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {

        Integer count=null;
        Object sessionCount=se.getSession().getServletContext().getAttribute("sessionCount");
        if(sessionCount==null){
            count=0;
        }else {
            count=Integer.parseInt(sessionCount.toString());
        }
        count--;
        se.getSession().getServletContext().setAttribute("sessionCount",count);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
