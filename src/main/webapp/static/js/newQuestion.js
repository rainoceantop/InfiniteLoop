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
    //提交问题按钮点击事件
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
    //图片上传按钮点击事件
    $("#file-upload-button").click(function () {
        $("#img").click()
    })
    //上传图片域的值改变事件
    $("#img").on("change",function () {
        $("#file-upload-button").html($(this).val())
    })
    //弹出上传图片的框
    $("#upload-question-button").click(function () {
        $("#img-upload-panel").show()
    })
    //取消上传图片的框
    $("#img-cancel-button").click(function () {
        $("#img-upload-panel").hide()
    })
    //上传至服务器按钮点击事件
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
    //单选按钮选中事件
    $("input[name='editType']").change(function () {
        if($(this).val() != -1)
            $("#w-h-setting").show()
        else
            $("#w-h-setting").hide()
    })

    //监听文本框输入
    $("#question-content").on("focus",function () {
        //如果屏幕大于950，只显示一次,不消失
        if($(window).width() > 950){
            $(".askQuestionBox").css("width","78%").css("-webkit-transition","width 1s").css("margin-right","2%")
            $(".markdown-guide").show().css("width","20%").css("-webkit-transition","width 1s").css("-webkit-transition-delay","0.1s")
            $(".guideBox").delay(1000).slideDown(500)
        }
    }).on("input",function () {
        var text = $(this).val()
        var converter = new showdown.Converter()
        var html = converter.makeHtml(text)
        $(".previewBox").html(html)
    }).on("keydown",function (e) {
        if(e.keyCode == 9){
            $(this).val($(this).val() + "     ")
            e.preventDefault()
        }
    })
    /*on("blur",function () {
        if($(window).width() > 950){
            $(".markdown-guide").css("width","0").css("-webkit-transition","width 1s").hide()
            $(".askQuestionBox").css("width","100%").css("-webkit-transition","width 1s")
        }
    })*/
    //编译文本域的markdown
    function compile() {
        var questionContent = $("#question-content")
        var text = questionContent.val()
        var converter = new showdown.Converter()
        var html = converter.makeHtml(text)
        questionContent.val(html)
    }
})
