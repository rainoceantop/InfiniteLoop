$(function () {
    $("input[name='avatar']").on("change",function () {
        var objUrl = getObjectURL(this.files[0]) //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#user_image").attr("src",objUrl).show() //将图片路径存入src中，显示出图片
        }
    })
    $("#form-update-button").click(function () {
        var avatar = $("input[name='avatar']")
        var form = $("#detail-update-form")
        if (avatar.val()){
            if (avatar[0].files[0].size > 1024 * 1024){
                alert("图片过大")
            }
            else {
                form.submit()
            }
        }
        else {
            form.submit()
        }
    })
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

})

//获取文件相对路径
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file)
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file)
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file)
    }
    return url ;
}


