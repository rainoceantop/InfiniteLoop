<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/29
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="Register"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="无限循环官方网站用户注册"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<form method="post" action="/user/registerHandle">
    用户名：<input type="text" name="userUsername" title="用户名">
    密码：<input type="password" name="userPassword" title="密码">
    名称：<input type="text" name="userNickname" title="名称">
    电子邮箱：<input type="text" name="userEmail" title="电子邮箱">
    <input type="submit" value="注册">
</form>

</body>
</html>
