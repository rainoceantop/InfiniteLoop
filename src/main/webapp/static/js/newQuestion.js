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
        var languageCount = 0;
        $("input[name='language']").each(function () {
            if($(this).attr("checked"))
                languageCount += 1
        })
        if(languageCount >=1 && languageCount <= 5){
            compile()
            $(this).parents("form").submit()
        }
        else
            alert("每个问题语言标签不能少于1个或多于5个")
    })
    $("#file-upload-button").click(function () {
        $("#img").click()
    })
    $("#img").on("change",function () {
        $("#file-upload-button").html($(this).val())
    })

    $("#upload-question-button").click(function () {
        $("#img-upload-panel").show()
    })

    $("#img-cancel-button").click(function () {
        $("#img-upload-panel").hide()
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

    $("input[name='editType']").change(function () {
        if($(this).val() != -1)
            $("#w-h-setting").show()
        else
            $("#w-h-setting").hide()
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
