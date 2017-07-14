$(function () {
    //发表评论按钮点击事件
    $("#comment-button").click(function () {
        var form = new FormData($(this).parents("form")[0])
        var content = $("#comment-panel").val()
        $("#comment-panel").val("")
        var acd = $("div[class='answer-count-display']")
        var ac = $("span[class='answer-count']")
        if(acd.css("display") === "none" && parseInt(ac.text()) === 0){
            acd.show()
            ac.text(1)
            newComment(content)
            setTimeout(ajx,500)
        }
        else{
            ac.text(parseInt(ac.text()) + 1)
            newComment(content)
            setTimeout(ajx,500)
        }

        function ajx() {
            $.ajax({
                url:"/comments/questionCommentsHandle",
                type:"post",
                async:false,
                data: form,
                processData:false,
                contentType:false,
                success:function (result) {
                    if(result === "SUCCESS"){
                        $("#newComment").css("opacity","1")
                    }
                    else{
                        ac.text(parseInt(ac.text()) - 1)
                        $("#newComment").hide()
                        if(parseInt(ac.text()) === 0){
                            acd.hide()
                        }
                    }
                }
            })
        }
    })

    //发表回答的内容
    function newComment(content) {
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
    }

    //rank按钮点击事件
    $(".question-rank-button").click(function () {
        ajx($(this).data("rank"),$(this).data("question_id"),$(this).data("user_id"))
        function ajx(rank,questionId,userId) {
            $.ajax({
                url:"/question/likesHandle",
                type:"post",
                async:false,
                data:"questionId=" + questionId + "&" + "rank=" + rank + "&" + "userId=" + userId,
                success:function (result) {
                    if(result === "SUCCESS"){
                        if(rank === "up"){
                            $(".rank-count").text(parseInt($(".rank-count").text()) + 1)
                        }
                        else
                            $(".rank-count").text(parseInt($(".rank-count").text()) - 1)
                    }
                    if(result === "ERROR"){
                        alert("您已操作过此问题的排位，不可重复操作")
                    }
                }
            })
        }
    })



})
