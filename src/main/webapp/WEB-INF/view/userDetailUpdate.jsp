<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/30
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="userDetailUpdate"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="修改个人资料"/>
    </jsp:include>
</head>
<body>
<form action="/user/detailHandle" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="${userDetail.userId}">
    头像：<input type="file" name="avatar"  value="${userDetail.userAvatar}">
    性别：<input type="radio" name="userSex" value="1">男
         <input type="radio" name="userSex" value="0">女
    生日：<input type="datetime" name="userBirthday" value="${userDetail.userBirthday}">
    职业：<input type="text" name="userProfession" value="${userDetail.userProfession}">
    城市：<input type="text" name="userLivingCity" value="${userDetail.userLivingCity}">
    语言：<input type="text" name="userLanguagesAttention" value="${userDetail.userLanguagesAttention}">
    <input type="submit" value="提交">
</form>
</body>
</html>
