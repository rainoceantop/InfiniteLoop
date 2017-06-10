$(function () {
    //语言选取框判定及动画
    $(".languageSelect").each(function () {
        if($(this).children("input").attr("checked"))
            $(this).css("background","#1C86EE").css("color","aliceblue")
    }).click(function () {
        if($(this).children("input").attr("checked")){
            $(this).children("input").attr("checked",false)
            $(this).fadeOut(200,function () {
                $(this).css("background","aliceblue").css("color","#333333")
            }).fadeIn(500)
        }
        else {
            $(this).children("input").attr("checked",true)
            $(this).fadeOut(200,function () {
                $(this).css("background","#1C86EE").css("color","aliceblue")
            }).fadeIn(500)
        }
    })
    $("#new-question-button").click(function () {
        $(this).parents("form").submit()
    })
})
