<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-14
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>图书管理系统</title>
</head>
<body>
<script type="text/javascript">
    alert("${requestScope.msg}");
    window.location = "<%=basePath%>${requestScope.url}";
</script>
</body>
</html>
