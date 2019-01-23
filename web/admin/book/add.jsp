<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-01-23
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/admin/base/header.jsp"></jsp:include>
<jsp:include page="/admin/base/nav.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<!-- 此处编写内容  -->
<div id="page-wrapper">
    <div id="page-inner">

        <%-- 编写数据增加表单 --%>
        <form action="/book/admin/BookServlet/add" method="post" class="form-horizontal" id="insertForm" >
            <%-- 图书名称 --%>
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">图书名称</label>
                <div class="col-md-6">
                    <input type="text" name="name" id="name" class="form-control input-sm"/>
                </div>
            </div>

            <%-- 图书分类 --%>
            <div class="form-group">
                <label for="category" class="col-md-3 control-label">分类</label>
                <div class="col-md-6">
                    <select class="form-control" id="category" name="category">
                        <option value="-1">请选择</option>

                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="bookcase" class="col-md-3 control-label">书架</label>
                <div class="col-md-6">
                    <select class="form-control" id="bookcase" name="bookcase">

                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="author" class="col-md-3 control-label">作者</label>
                <div class="col-md-6">
                    <input type="text" name="author" id="author" class="form-control input-sm"/>
                </div>
            </div>
            <div class="form-group">
                <label for="publish" class="col-md-3 control-label">出版社</label>
                <div class="col-md-6">
                    <input type="text" name="publish" id="publish" class="form-control input-sm"/>
                </div>
            </div>
            <div class="form-group">
                <label for="edition" class="col-md-3 control-label">版次</label>
                <div class="col-md-6">
                    <input type="text" name="edition" id="edition" class="form-control input-sm"/>
                </div>
            </div>
            <div class="form-group">
                <label for="publishdate" class="col-md-3 control-label">出版日期</label>
                <div class="col-md-6">
                    <input type="text" name="publishdate" id="publishdate" class="form-control input-sm"/>
                </div>
            </div>
            <div class="form-group">
                <label for="unitprice" class="col-md-3 control-label">单价</label>
                <div class="col-md-6">
                    <input type="text" name="unitprice" id="unitprice" class="form-control input-sm"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inventory" class="col-md-3 control-label">数量</label>
                <div class="col-md-6">
                    <input type="text" name="inventory" id="inventory" class="form-control input-sm"/>
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
<script>
    var url="/book/admin/BookCategoryServlet/list";
    $.ajaxAction(url,"get",{ajax:true},[setCategory]);
    function setCategory(data) {
        console.log(data.status);
        if(data.status){
            for (var op of data.data){

                $("#category").append(" <option value=\""+op.id+"\">"+op.name+"</option>");
            }


        }
    }
</script>



<jsp:include page="/admin/base/footer.jsp"></jsp:include>