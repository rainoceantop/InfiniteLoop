$(function () {
    $("#login-button").click(function () {
        $(this).parents("form").submit()
    })
    $("input[type='text'],input[type='password'],input[type='email']").focus(function () {
        $(this).css("box-shadow","0px 1px 0 rgba(0,0,0,0.2)")
    }).blur(function () {
        $(this).css("box-shadow","")
    })
})
