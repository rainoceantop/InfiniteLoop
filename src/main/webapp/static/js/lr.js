$(function () {
    //当所有检查都为1的时候表单才可提交
    var usernameCheck = 0
    var passwordCheck = 0
    var userCheck = 0
    var emailCheck = 0

    $("#register-button").click(function () {
        if(usernameCheck + passwordCheck + userCheck + emailCheck === 4)
            $(this).next().click()
        else
            alert("信息填写错误，请检查")
    })
    $("#login-button").click(function () {
        $(this).next().click()
    })
    $("input[type='text'],input[type='password'],input[type='email']").focus(function () {
        $(this).css("box-shadow","0px 1px 0 rgba(0,0,0,0.2)")
    }).blur(function () {
        $(this).css("box-shadow","")
    })

    //注册预处理
    $("#username").blur(function () {
        var username = $(this)
        var l = username.val().replace(" ","").length
        var reg = /\w{6,15}/
        if(l >= 6 && l <= 15 && reg.test(username.val()))
            preHandle(username,"username",username.val())
    })
    $("#password").blur(function () {
        var password = $(this)
        var l = password.val().replace(" ","").length
        if(l >= 6 && l <= 15){
            password.css("box-shadow","0px 1px 0 #98FB98")
            passwordCheck = 1
        }
        else{
            password.css("box-shadow","0px 1px 0 #FF3030")
            passwordCheck = 0
        }
    })
    $("#user").blur(function () {
        var user = $(this)
        var l = user.val().replace(" ","").length
        if(l >= 1 && l <= 15)
            preHandle(user,"user",user.val())
    })
    $("#email").blur(function () {
        var email = $(this)
        var l = email.val().replace(" ","").length
        var reg = /^[\w-]+@[\w-]+(\.[\w-]+)+$/
        if(reg.test(email.val()))
            preHandle(email,"email",email.val())
    })
    function preHandle(object,key,val) {
        var data
        if(key === "username")
            data = {username:val}
        if(key === "user")
            data = {user:val}
        if(key === "email")
            data = {email:val}
        setTimeout(function () {
            $.ajax({
                url:"/user/registerPreHandle",
                async:false,
                method:"POST",
                data:data,
                success:function (result) {
                    if (result === "SUCCESS"){
                        object.css("box-shadow","0px 1px 0 #98FB98")
                        if(key === "username")
                            usernameCheck = 1
                        if(key === "user")
                            userCheck = 1
                        if(key === "email")
                            emailCheck = 1
                    }
                    else{
                        object.css("box-shadow","0px 1px 0 #FF3030")
                        if(key === "username")
                            usernameCheck = 0
                        if(key === "user")
                            userCheck = 0
                        if(key === "email")
                            emailCheck = 0
                    }
                }
            })
        },500)
    }
})
