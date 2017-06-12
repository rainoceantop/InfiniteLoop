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
        compile()
        $(this).parents("form").submit()
    })

    $("#upload-question-button").click(function () {
        $("#img-upload-panel").show()
    })
    $("#question-img-button").click(function () {
        var formdata = new FormData($(this).parents("form")[0])
        $.ajax({
            url:"/questionImgHandle",
            type:"post",
            async:false,
            data: formdata,
            processData:false,
            contentType:false,
            success:function (result) {
                if(result != "ERROR"){
                    $("#img-upload-panel").hide()
                    var url = 'http://' + result
                    $("#question-content").val($("#question-content").val() + "\n![](" + url + ")")
                }
                else{
                    alert(result)
                }
            }
        })
    })



    //编译文本域的markdown
    function compile() {
        var questionContent = $("#question-content")
        var text = questionContent.val()
        var converter = new showdown.Converter()
        var html = converter.makeHtml(text)
        questionContent.val(html)
    }
})
