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
    <script src="/static/js/showdown.min.js"></script>
    <link rel="stylesheet" href="/static/css/newQuestion.css">
    <script src="/static/js/newQuestion.js"></script>
</head>

<body>
<%@include file="staticHtml/nav.jsp"%>

<div class="container">
    <form action="/newQuestionHandle" method="post" name="newQuestionForm">
        <input type="hidden" name="userId" value="${sessionScope.userId}">
        <div class="form-group">
            <label for="question-title">题目</label>
            <input id="question-title" type="text" class="form-control" name="questionTitle">
        </div>
        <div class="form-group">
            <label for="question-content">内容</label>
            <textarea id="question-content" class="form-control" name="questionContent"></textarea>
        </div>
        <div class="form-group">
            <label for="language-tag">标签</label>
            <div id="language-tag">
                <c:forEach items="${languagesMap}" var="language">
                    <div class="languageSelect">
                        <input type="checkbox" name="language" title="${language.value}" value="${language.value}">${language.value}
                    </div>
                </c:forEach>
            </div>
        </div>
        <hr style="clear: both">
        <a href="javascript:void(0);" class="a-btn" id="upload-question-button">发表</a>
        <a href="javascript:void(0);" class="a-btn" id="new-question-button">发表</a>
    </form>
    <div id="img-upload-panel">
        <form action="/questionImgHandle" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="img">上传图片</label>
                <input type="file" class="form-control" id="img" name="questionContentImg"/>
            </div>
            <div class="form-group">
                <label for="img-w">宽度</label>
                <input type="text" class="form-control" id="img-w" name="imgWidth"/>
            </div>
            <div class="form-group">
                <label for="img-h">高度</label>
                <input type="text" class="form-control" id="img-h" name="imgHeight"/>
            </div>
            <a href="javascript:void(0);" class="a-btn" id="question-img-button">发表</a>
        </form>
    </div>
</div>
</body>
</html>
