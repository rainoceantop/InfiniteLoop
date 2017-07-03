$(function () {
    $("#comment-button").click(function () {
        var form = new FormData($(this).parents("form")[0])
        var content = $("#comment-panel").val()
        var ifNotAnswer = $("p[class='text-center if-not-answer']")
        var ifAnswerCount = $("span[class='answer-count']")
        var answerCount = 1
        $("#comment-panel").val("")
        if(ifNotAnswer.is(":visible")){
            ifNotAnswer.hide()
            $(".answer-count-display").html('<h4><span class="answer-count">1</span>个回答</h4>')
            newComment(content)
        }
        else{
            answerCount = parseInt(ifAnswerCount.text()) + 1
            ifAnswerCount.text(answerCount)
            newComment(content)
        }

        setTimeout(ajx,500)

        function ajx() {
            $.ajax({
                url:"/comments/questionCommentsHandle",
                type:"post",
                async:false,
                data: form,
                processData:false,
                contentType:false,
                success:function (result) {
                    alert(result)
                    if(result === "SUCCESS"){
                        $("#newComment").css("opacity","1")
                    }
                    else{
                        answerCount -= 1
                        ifAnswerCount.text(answerCount)
                        $("#newComment").hide()
                        if(answerCount === 0){
                            $(".answer-count-display").html("")
                            ifNotAnswer.show()
                        }
                    }
                }
            })
        }
    })

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

})
