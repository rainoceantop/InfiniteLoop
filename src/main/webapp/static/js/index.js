$(function () {
    //如果a标签的链接和当前页面相同，改变背景颜色
    $(".a-page").each(function () {
        if($(this).html() === "1" && (window.location.pathname + window.location.search === "/" || window.location.pathname + window.location.search === "/questions")){
            $(this).css("background","#FFC125")
        }
        if(window.location.pathname + window.location.search === $(this).attr("href")){
            $(this).css("background","#FFC125")
        }
    })
})