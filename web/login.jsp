<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-03
  Time: 21:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <script type="text/javascript" src="assets/js/jquery-3.3.1.js" ></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="assets/js/login.js" ></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/login.css" />
</head>
<body>
<div class="container login">
    <div class="login_l"></div>
    <div class="login_r">

        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <div class="col-md-9">
                    <div class="form-group"> <i class="fa glyphicon glyphicon-user"></i> <input class="form-control" type="text" placeholder="用户名" id="username" autofocus="autofocus" maxlength="20" /> </div>
                    <div class="form-group"> <i class="fa glyphicon glyphicon-lock"></i> <input class="form-control" type="password" placeholder="密码" id="password"  maxlength="8" /> </div>
                    <div class="form-group"><i class="fa glyphicon glyphicon-pencil"></i> <input class="form-control" type="text" placeholder="验证码" id="code"  maxlength="8" /><img src="/book/IdentityServlet/IdentifyingCode"> </div>
                    <div class="form-group col-md-offset-9">
                        <button type="button" class="btn btn-primary">登录</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!---->

</div>







</body>
</html>
