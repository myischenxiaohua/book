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
                        <td><button type="button" id="editBtn" class="btn btn-primary btn-sm">详情</button>&nbsp;&nbsp;<button type="button" class="btn btn-danger btn-sm"  id="delBtn" >借出</button></td>
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

<jsp:include page="/admin/base/footer.jsp"></jsp:include>
