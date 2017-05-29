<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/29
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="userDetail"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="个人资料"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
用户id：${userDetail.userId}<br>
用户头像：<img src="${userDetail.userAvatar}"/><br>
用户性别：${userDetail.userSex}<br>
用户生日：${userDetail.userBirthday}<br>
用户职业：${userDetail.userProfession}<br>
现居城市：${userDetail.userLivingCity}<br>
关注语言：${userDetail.userLanguagesAttention}<br>
</body>
</html>
