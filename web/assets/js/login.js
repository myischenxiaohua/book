
$(function () {
    $("#identifyingCode").click(function () {
        $(this).attr("src","/book/IdentityServlet/IdentifyingCode?ts="+new Date().getTime());

    })
})

