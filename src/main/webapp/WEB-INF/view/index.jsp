<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="我是标题"/>
    </jsp:include>
</head>
<body>
<%@include file="staticHtml/nav.jsp"%>
</body>

</html>


