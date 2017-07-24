<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="我是标题"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="请问这里出了什么错了。。。。"/>
    </jsp:include>
    <link rel="stylesheet" href="/static/css/index.css">
    <script src="/static/js/index.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<!-- 导航条 -->
<%@include file="staticHtml/nav.jsp"%>


<div class="container">
    <h3 class="text-left">全部问题</h3>
    <a href="/newQuestion" class="text-right">提问问题</a>
    <hr>
    <!-- 问题陈列 -->
    <div class="questions">
    <c:forEach items="${questions}" var="question">
        <div class="question_box">
            <div class="q_title">
                <a href="/question/${question.questionId}/${question.questionTitle}">${question.questionTitle}</a>
            </div>
            <div class="q_language">
                <c:forEach items="${question.questionLanguage}" var="question_language">
                    <a href="/question/tag/${question_language ne 'c#' ? question_language : 'csharp'}">
                        <div class="q_language_box">
                            ${question_language}
                        </div>
                    </a>
                </c:forEach>
            </div>

            <div class="post_time">
             ${question.questionAskedTimeHumanReadableFormat} &middot; <a href="#">${question.userDetail.userNickname}</a>
            </div>
        </div>
        <hr>
    </c:forEach>
    </div>
    <c:if test="${page.pages > 1}">
        <c:if test="${page.currentPage ne 1}">
            <a href="${rurl}${isParam?"&":"?"}page=${page.prePage}" class="a-page">pre</a>
        </c:if>
        <%--当总页数小于5页时--%>
        <c:if test="${page.pages < 5}">
            <c:forEach var="p" begin="1" end="${page.pages}" step="1">
                <a href="${rurl}${isParam?"&":"?"}page=${p}" class="a-page">${p}</a>
            </c:forEach>
        </c:if>
        <%--当总页数等于5页时--%>
        <c:if test="${page.pages == 5}">
            <c:forEach var="p" begin="1" end="5" step="1">
                <a href="${rurl}${isParam?"&":"?"}page=${p}" class="a-page">${p}</a>
            </c:forEach>
        </c:if>
        <%--当总页数大于5页时--%>
        <c:if test="${page.pages > 5}">
            <%--如果当前页加上2页减去5页大于一页，则用省略号省略中间页数--%>
            <c:if test="${page.currentPage + 2 - 5 > 1}">
                <a href="${rurl}${isParam?"&":"?"}page=1" class="a-page">1</a>
                &hellip;
            </c:if>
            <%--如果当前页加上2页减去5页小于等于一页，则显示前5页--%>
            <c:if test="${page.currentPage + 2 - 5 <= 1}">
                <c:forEach var="p" begin="1" end="${page.pages >= 5 ? 5 : page.pages}" step="1">
                    <a href="${rurl}${isParam?"&":"?"}page=${p}" class="a-page">${p}</a>
                </c:forEach>
            </c:if>
            <%--如果当前页加上2页减去5页大于第1页并且当前页减去2页加上5页小于最后一页，则显示中间的5页--%>
            <c:if test="${page.currentPage + 2 - 5 > 1 and page.currentPage -2 + 5 < page.pages}">
                <c:forEach var="p" begin="${page.currentPage - 2}" end="${page.currentPage + 2}" step="1">
                    <a href="${rurl}${isParam?"&":"?"}page=${p}" class="a-page">${p}</a>
                </c:forEach>
            </c:if>
            <%--如果当前页减去2页加上5页大于最后一页，则显示最后5页--%>
            <c:if test="${page.currentPage -2 + 5 >= page.pages}">
                <%--这里所有数字都是由1，2，5组成，但是显示最后5页的时候，要减去4，4，4!!!让我很不爽，所以，我玩英雄联盟去了--%>
                <c:forEach var="p" begin="${page.pages > 5 ? page.pages - 4 : 1}" end="${page.pages}" step="1">
                    <a href="${rurl}${isParam?"&":"?"}page=${p}" class="a-page">${p}</a>
                </c:forEach>
            </c:if>
            <%--如果当前页减去2页加上5页小于最后一页，则用省略号省略中间页数--%>
            <c:if test="${page.currentPage -2 + 5 < page.pages}">
                &hellip;
                <a href="${rurl}${isParam?"&":"?"}page=${page.pages}" class="a-page">${page.pages}</a>
            </c:if>
        </c:if>
        <c:if test="${page.currentPage ne page.pages}">
            <a href="${rurl}${isParam?"&":"?"}page=${page.nextPage}" class="a-page">next</a>
        </c:if>
    </c:if>
</div>
</body>
</html>


