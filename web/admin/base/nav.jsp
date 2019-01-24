<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-14
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <a class="active-menu" href="pages/back/index.jsp"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            <!-- 管理员flag为1 -->
            <!--超级管理员操作-->
            <li>
                <a href="#" data-toggle="collapse" data-target="#nav1"><i class="fa glyphicon glyphicon-align-justify "></i>超级管理员操作 <span class="fa arrow glyphicon glyphicon-menu-left"></span></a>
                <ul class="nav nav-second-level collapse" id="nav1">
                    <li>
                        <a href="/book/admin/AdminServlet/index"><i class="fa glyphicon glyphicon-record"></i>管理员列表</a>
                    </li>
                    <li>
                        <a href="/book/admin/user/add.jsp"><i class="fa glyphicon glyphicon-record"></i>增加管理员</a>
                    </li>
                </ul>
            </li>
            <!--配置管理-->
            <li>
                <a href="#" data-toggle="collapse" data-target="#nav2"><i class="fa glyphicon glyphicon-align-justify "></i>配置管理<span class="fa arrow glyphicon glyphicon-menu-left"></span></a>
                <ul class="nav nav-second-level collapse" id="nav2">
                    <li>
                        <a href="/book/admin/AdminServlet/index"><i class="fa glyphicon glyphicon-record"></i>书籍分类</a>
                    </li>
                    <li>
                        <a href="/book/admin/user/add.jsp"><i class="fa glyphicon glyphicon-record"></i>书架</a>
                    </li>
                </ul>
            </li>


            <!--读者管理-->
            <li>
                <a href="#" data-toggle="collapse" data-target="#nav3"><i class="fa glyphicon glyphicon-align-justify "></i>读者管理 <span class="fa arrow glyphicon glyphicon-menu-left"></span></a>
                <ul class="nav nav-second-level collapse" id="nav3">
                    <li>
                        <a href="/book/admin/ReaderServlet/index"><i class="fa glyphicon glyphicon-record"></i>读者列表</a>
                    </li>
                    <li>
                        <a href="/book/admin/reader/add.jsp"><i class="fa glyphicon glyphicon-record"></i>读者录入</a>
                    </li>
                </ul>
            </li>
            <!--图书管理-->
            <li>
                <a href="#" data-toggle="collapse" data-target="#nav4"><i class="fa glyphicon glyphicon-align-justify "></i>图书管理 <span class="fa arrow glyphicon glyphicon-menu-left"></span></a>
                <ul class="nav nav-second-level collapse" id="nav4">
                    <li>
                        <a href="/book/admin/BookServlet/index"><i class="fa glyphicon glyphicon-record"></i>图书列表</a>
                    </li>
                    <li>
                        <a href="/book/admin/book/add.jsp"><i class="fa glyphicon glyphicon-record"></i>添加图书</a>
                    </li>

                </ul>
            </li>
            <!--借阅管理-->
            <li>
                <a href="#" data-toggle="collapse" data-target="#nav5"><i class="fa glyphicon glyphicon-align-justify "></i>借阅管理 <span class="fa arrow glyphicon glyphicon-menu-left"></span></a>
                <ul class="nav nav-second-level collapse" id="nav5">
                    <li>
                        <a href="/book/admin/LendServlet/index"><i class="fa glyphicon glyphicon-record"></i>借书</a>
                    </li>
                    <li>
                        <a href="/book/admin/book/add.jsp"><i class="fa glyphicon glyphicon-record"></i>借阅信息</a>
                    </li>

                </ul>
            </li>

        </ul>
    </div>
</nav>
