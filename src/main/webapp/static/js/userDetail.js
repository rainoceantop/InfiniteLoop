$(function () {
    $("input[name='avatar']").on("change",function () {
        var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#user_image").attr("src",objUrl).show(); //将图片路径存入src中，显示出图片
        }
    })
    $("#form-update-button").click(function () {
        var avatar = $("input[name='avatar']");
        var form = $("#detail-update-form");
        if (avatar.val()){
            if (avatar[0].files[0].size > 1024 * 1024){
                alert("图片过大")
            }
            else {
                form.submit();
            }
        }
        else {
            form.submit();
        }
    })

})


function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}


