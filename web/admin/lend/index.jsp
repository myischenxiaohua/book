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
                    <%--<th>编号</th>--%>
                    <th>书籍名称</th>
                    <th>分类</th>
                    <th>书架</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>版次</th>
                    <th>出版时间</th>
                    <th>可借</th>
                    <th>库存</th>
                    <th>添加人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${books }" var="book">
                    <tr>
                        <%--<td>${book.isbn}</td>--%>
                        <td>${book.name}</td>
                        <td>${book.bookCategory.name}</td>
                        <td>${book.bookCase.name}</td>
                        <td>${book.author}</td>
                        <td>${book.publish}</td>
                        <td>第${book.edition}版</td>
                        <td><fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${book.extant}</td>
                            <td>${book.inventory}</td>
                        <td>${book.admin.name}</td>
                        <td><button type="button" id="detailBtn" class="btn  btn-info btn-sm">详情</button>&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-sm"  id="lendBtn" extant="${book.extant}" isbn="${book.isbn}" >借出</button></td>
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
                <h4 class="modal-title" id="myModalLabel">借出</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="txt_ISBN">ISBN</label>
                    <input type="text" class="form-control" id="txt_ISBN" disabled placeholder="用户名">
                </div>
                <div class="form-group">
                    <label for="txt_name">书籍书名</label>
                    <input type="text" class="form-control" id="txt_name" disabled placeholder="用户名">
                </div>
                <div class="form-group">
                    <label for="txt_reader">读者</label>
                    <select class="form-control" id="txt_reader">
                        <option value="-1">请选择</option>
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
    var extant=0;
    $(function () {
        $.ajaxAction("/book/admin/ReaderServlet/all","get",{ajax:true},[setOption]);
    });
    function setOption(data){
        if(data.status){
            for (var op of data.data)
            $("#txt_reader").append("<option value=\""+op.id+"\">"+op.name+"</option>");
        }else {
            console.log(data);
        }

    }
    $("#table #lendBtn").click(function () {
        extant=$(this).attr("extant")
        $("#txt_ISBN").val($(this).attr("isbn"));
        $("#txt_name").val($(this).parent().parent().children().get(0).innerText)
        $('#myModal').modal();

    });
    $("#btn_submit").click(function () {
        $.ajaxAction("/book/admin/LendServlet/add","post",{isbn:$("#txt_ISBN").val(),reader:$("#txt_reader").val(),extant:extant},[reloadData])
    })
    function reloadData(data,prm){
        if(data.status){
          $.dialog().alert({message:data.msg})
            location.reload();
        }

    }
    
</script>

<jsp:include page="/admin/base/footer.jsp"></jsp:include>
