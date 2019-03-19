$(function () {
    //点击图片获取验证码
    $("input[id=\"code\"]").next().click(function () {
        $(this).attr('src','/book/IdentityServlet/IdentifyingCode?tm='+new Date());

    })

    //点击按钮登录
   $("button[type=\"button\"]").click(function () {
       var name=$("#username").val();
       var pwd=$("#password").val();
       var code=$("#code").val();
       var url='/book/admin/AdminServlet/login';
       $.ajaxAction(url,"post",{user:name,password:pwd,code:code},[cheackLogin]);

   })



})

function cheackLogin(data,parm) {
    if(data.status){
        location.href=data.url
    }else {
       alert(data.msg)
    }
    console.log(data)

}
