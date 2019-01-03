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
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="assets/validate/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="assets/validate/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="assets/validate/js/additional-methods.min.js"></script>
    <script type="text/javascript" src="assets/validate/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="assets/validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="assets/validate/login.js"></script>
</head>
<body style="background-color: #E2E2E2;">
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <h2>图书管理系统</h2>
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form id="loginForm" role="form" action="admin/AdminServlet/login" method="post">
                    <hr />

                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                        <input type="text" id="aid" name="aid" value="admin" class="form-control" placeholder="Your Username " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" id="password" name="password" value="admin123" class="form-control"  placeholder="Your Password" />
                    </div>

                    <!-- <a href="index.html" class="btn btn-primary col-md-offset-7">Login Now</a> -->
                    <input type="submit" value="登 录" class="btn btn-primary col-md-offset-5"/>

                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
