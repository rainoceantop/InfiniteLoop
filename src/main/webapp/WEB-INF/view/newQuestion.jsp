<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="提问问题"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<%@include file="staticHtml/nav.jsp"%>
<form action="/newQuestionHandle" method="post" name="newQuestionForm">
    <input type="hidden" name="userId" value="${sessionScope.userId}">
    题目：<input type="text" name="questionTitle"><br>
    内容：<textarea cols="50" rows="20" name="questionContent"></textarea><br>
    语言：<c:forEach items="${questionLanguage}" var="language">
            <input type="checkbox" name="language" title="${language}" value="${language}">${language}
         </c:forEach>
    <input type="submit" value="提交">
</form>
</body>
</html>
