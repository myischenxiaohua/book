$(function () {
    $("input[name=\"code\"]").next().click(function () {
        $(this).attr('src','/book/IdentityServlet/IdentifyingCode?tm='+new Date());

    })

   $("button[type=\"button\"]").click(function () {
       var name=$("#username").val();
       var pwd=$("#password").val();
       var code=$("#code").val();
       var url='http://localhost:8080/book/admin/AdminServlet/login';
       ajaxAction(url,"post",{user:name,password:pwd,code:code});

   })

})

function ajaxAction(url,type,data,callBack,dataType="json"){

    $.ajax({
        url:url, //提交地址
        type:type, //提交方式 post/get
        data:data,//{参数名称1:‘值1’,参数名称2:‘值2’,....}
        dataType:dataType,//提交数据类型 如果跨域提交用jsonp
        async:true,
        //jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
        //jsonpCallback:"ts",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
        success:function(data){ //提交成功后返回数据执行
            console.log(data);
        },
        eerror:function(){//提交失败返回的
            //错误信息
            console.log('错误');
        }


    });

}
