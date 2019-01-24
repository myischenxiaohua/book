$("#main-menu").children().first().siblings().children("a").click(function(){
    $(this).find("span").toggleClass("glyphicon-menu-down")
    $(this).parent().siblings().children("a").find("span").removeClass("glyphicon-menu-down")
    $(this).parent().siblings().children("ul").collapse('hide')
});




