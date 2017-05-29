<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/29
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="Login"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="登陆啊 啊啊啊啊啊啊啊啊啊"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<form method="post" action="/user/loginHandle">
    用户名：<input type="text" name="userUsername" title="用户名">
    密码：<input type="password" name="userPassword" title="密码">
    <input type="submit" value="登陆">
</form>
</body>
</html>
