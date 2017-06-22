$(function () {
    $("#comment-button").click(function () {
        var form = new FormData($(this).parents("form")[0])
        var content = $("#comment-panel").val()
        $("#comment-panel").val("")
        $("p").css("display","none")
        $("#newComment").css("opacity",".5").html(
            '<div class="comment">'+
            '<div class="comment-content">'+
            content+
            '</div>'+
            '<div class="comment-footer">'+
            '<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>'+
            '<span class="pull-right time-user">0秒前 &middot; ' +
            '<a href="#">'+ $("input[name='userNickname']").val() +'</a></span>'+
            '</div>'+
            '</div>'
        )
        $.ajax({
            url:"/comments/questionCommentsHandle",
            type:"post",
            async:false,
            data: form,
            processData:false,
            contentType:false,
            success:function (result) {
                if(result == "SUCCESS"){
                   $("#newComment").css("opacity","1")
                }
            }
        })
    })
})
