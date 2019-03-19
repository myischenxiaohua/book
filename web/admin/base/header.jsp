<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-14
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://www.cxh.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://www.cxh.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>图书管理系统</title>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
<nav class="navbar navbar-default navbar-cls-top "  style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">图书管理系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="pages/back/index.jsp">图书管理系统</a>
    </div>
    <!--顶部-->
    <div class="header-center">

        管理员:${user}

        <small>上次登录日期:<fmt:formatDate value="${lastdate}" pattern="yyyy-MM-dd HH:mm:ss"/></small>
        <small>当前登录统计：${sessionCount}</small>

    </div>
    <div class="header-right">




        <a href="/book/admin/AdminServlet/logout" class="btn btn-danger" title="Logout"> 退出系统</a>
    </div>
</nav>