<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-24
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/admin/base/header.jsp"></jsp:include>
<jsp:include page="/admin/base/nav.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://www.cxh.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://www.cxh.com/jstl/fmt" %>
<!-- 此处编写内容  -->
<div id="page-wrapper">
    <div id="page-inner">
        <c:if test="${books != null}">
            <table class="table table-bordered table-hover " id="table">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>书籍名称</th>
                    <th>分类</th>
                    <th>书架</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>版次</th>
                    <th>出版时间</th>
                    <th>添加人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${books }" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.name}</td>
                        <td>${book.bookCategory.name}</td>
                        <td>${book.bookCase.name}</td>
                        <td>${book.author}</td>
                        <td>${book.publish}</td>
                        <td>第${book.edition}版</td>
                        <td><fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${book.admin.name}</td>
                        <td><button type="button" id="detailBtn" class="btn  btn-info btn-sm">详情</button>&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-sm"  id="lendBtn" >借出</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="col-md-5 col-md-offset-3">
                <jsp:include page="/admin/base/splitPage.jsp"/>
            </div>
        </c:if>
    </div>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">编辑</h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <label for="txt_user">用户名</label>
                    <input type="text" class="form-control" id="txt_user" disabled placeholder="用户名">
                </div>
                <div class="form-group">
                    <label for="txt_pwd">密码</label>
                    <input type="text" class="form-control" id="txt_pwd" placeholder="密码">
                </div>
                <div class="form-group">
                    <label for="txt_phone">电话</label>
                    <input type="text" class="form-control" id="txt_phone">
                </div>
                <div class="form-group">
                    <label for="txt_type">类型</label>
                    <select class="form-control" id="txt_type">
                        <option value="1">超级管理员</option>
                        <option value="0">管理员</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="txt_status">状态</label>
                    <select class="form-control" id="txt_status">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                <button type="button" id="btn_submit"  class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
            </div>
        </div>
    </div>
</div>
<script>
$("#lendBtn").click(function () {


});
</script>

<jsp:include page="/admin/base/footer.jsp"></jsp:include>
