<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-15
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>

    <jsp:include page="/admin/base/header.jsp"></jsp:include>
    <jsp:include page="/admin/base/nav.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">

            <%-- 编写数据增加表单 --%>
            <form action="/book/admin/AdminServlet/reg" method="post" class="form-horizontal" id="insertForm" >
                <%-- 管理员账号 --%>
                <div class="form-group">
                    <label for="user" class="col-md-3 control-label">管理员账号</label>
                    <div class="col-md-6">
                        <input type="text" name="user" id="user" class="form-control input-sm"/>
                    </div>
                </div>

                <%-- 密码 --%>
                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">管理员密码</label>
                    <div class="col-md-6">
                        <input type="password" name="password" id="password" class="form-control input-sm"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-md-3 control-label">联系电话</label>
                    <div class="col-md-6">
                        <input type="text" name="phone" id="phone" class="form-control input-sm"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="flag" class="col-md-3 control-label">管理员类型</label>
                    <div class="col-md-6">
                        <select class="form-control" id="flag" name="flag">
                            <option value="1">超级管理员</option>
                            <option value="0">后台管理员</option>
                        </select>
                    </div>
                </div>

                <div class="from-group">
                    <div class="col-md-5 col-md-offset-3">
                        <button type="submit" class="btn btn-success c">提交</button>
                        <button type="reset" class="btn btn-success">重置</button>
                    </div>
                </div>


            </form>
        </div>
    </div>




<jsp:include page="/admin/base/footer.jsp"></jsp:include>


