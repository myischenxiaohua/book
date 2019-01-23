<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-22
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="/admin/base/header.jsp"></jsp:include>
<jsp:include page="/admin/base/nav.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!-- 此处编写内容  -->
<div id="page-wrapper">
    <div id="page-inner">

        <%-- 编写数据增加表单 --%>
        <form action="/book/admin/ReaderServlet/add" method="post" class="form-horizontal" id="insertForm" >
            <%-- 读者姓名 --%>
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">姓名</label>
                <div class="col-md-6">
                    <input type="text" name="name" id="name" class="form-control input-sm"/>
                </div>
            </div>
            <%-- 读者年龄 --%>
            <div class="form-group">
                <label for="age" class="col-md-3 control-label">年龄</label>
                <div class="col-md-6">
                    <input type="text" name="age" id="age" class="form-control input-sm"/>
                </div>
            </div>
            <%-- 读者身份证 --%>
            <div class="form-group">
                <label for="card" class="col-md-3 control-label">身份证号码</label>
                <div class="col-md-6">
                    <input type="text" name="card" id="card" class="form-control input-sm"/>
                </div>
            </div>
            <%-- 读者性别 --%>
            <div class="form-group">
                <label for="sex" class="col-md-3 control-label">性别</label>
                <div class="col-md-6">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="sex" value="0"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="sex" value="1"> 女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-md-3 control-label">联系电话</label>
                <div class="col-md-6">
                    <input type="text" name="phone" id="phone" class="form-control input-sm"/>
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