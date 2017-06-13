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
    <div class="askQuestionBox">
        <form action="/newQuestionHandle" method="post" name="newQuestionForm">
            <input type="hidden" name="userId" value="${sessionScope.userId}">
            <div class="form-group">
                <label for="question-title">题目</label>
                <input id="question-title" type="text" name="questionTitle">
            </div>
            <div class="form-group">
                <label for="question-content">内容</label>
                <textarea id="question-content" contenteditable="true" name="questionContent"></textarea>
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
            <a href="javascript:void(0);" class="a-btn" id="upload-question-button">图片</a>
            <a href="javascript:void(0);" class="a-btn" id="new-question-button">发表</a>
        </form>
    </div>

    <div id="img-upload-panel">
        <form action="/questionImgHandle" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <input type="file" class="form-control" id="img" name="questionContentImg" style="display: none"/>
                <label for="file-upload-button">上传图片</label>
                <a href="javascript:void(0);" class="a-btn" style="display:block;background: #4A708B;margin-bottom: 15px;word-break: break-all" id="file-upload-button">点此上传</a>
            </div>
            <div class="form-group">
                <label for="imgEditType">图片编辑</label>
                <div id="imgEditType" class="form-control" style="height: auto">
                    <input type="radio" name="editType" id="type0" value="-1" checked><label for="type0">原图</label>
                    <input type="radio" name="editType" id="type1" value="0"><label for="type1">限制最长边，按等比例缩放</label>
                    <input type="radio" name="editType" id="type2" value="1"><label for="type2">按宽和高数值居中裁剪</label>
                </div>
            </div>
            <div class="form-group" id="w-h-setting" style="display: none">
                <label for="img-w">宽度</label>
                <input type="number" placeholder="默认500px" class="form-control" id="img-w" name="imgWidth" width="25" required="required">
                <label for="img-h">高度</label>
                <input type="number" placeholder="默认300px" class="form-control" id="img-h" name="imgHeight" width="25" required="required">
            </div>
            <a href="javascript:void(0);" class="a-btn" id="img-cancel-button" style="background: lightgray">取消</a>
            <a href="javascript:void(0);" class="a-btn pull-right" id="question-img-button">上传至服务器</a>
        </form>
    </div>
</div>
</body>
</html>
