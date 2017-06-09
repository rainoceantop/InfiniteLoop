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
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <link rel="stylesheet" href="/static/css/fileinput.min.css"/>
    <link rel="stylesheet" href="/static/css/userDetail.css">
    <script src="/static/js/fileinput.min.js"></script>
    <script src="/static/js/zh.js"></script>
    <script src="/static/js/userDetail.js"></script>
</head>
<body>
<!-- 导航条 -->
<%@include file="staticHtml/nav.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-3 text-center">
            <img src="${userDetail.userAvatar}" class="img-responsive user-image center-block"/>
            <p class="text-info">
                <strong>${userDetail.userNickname}</strong>
            </p>
        </div>
        <div class="col-md-9 user-detail-display text-overflow">
            <dl class="dl-horizontal">
                <dt>用户性别：</dt>
                <dd><c:if test="${userDetail.userSex eq 1}">男</c:if><c:if test="${userDetail.userSex eq 0}">女</c:if></dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>用户生日：</dt>
                <dd>${userDetail.userBirthday}</dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>用户职业：</dt>
                <dd>${userDetail.userProfession}</dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>现居城市：</dt>
                <dd>${userDetail.userLivingCity}</dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>关注语言：</dt>
                <dd>
                    <div class="u_language">
                        <c:forEach items="${userDetail.userLanguagesAttention}" var="user_language">
                            <div class="u_language_box">
                                ${user_language}
                            </div>
                        </c:forEach>
                    </div>
                </dd>
            </dl>
            <dl class="dl-horizontal">
                <dt>箴言/座右铭：</dt>
                <dd>${userDetail.userMotto}</dd>
            </dl>
            <button type="button" class="btn btn-primary btn-md" style="margin-left: 20%" data-toggle="modal" data-target="#detail-update">
                修改
            </button>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="detail-update" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">修改个人资料</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/user/detailHandle" id="detail-update-form" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="userId" value="${userDetail.userId}">
                            <div class="form-group">
                                <img src="#" style="display: none;" class="img-responsive user-image center-block" id="user_image">
                                <label>头像(只支持jpg,png,gif大小不超过1M)</label>
                                <input type="file" name="avatar" class="form-control" value="${userDetail.userAvatar}">
                            </div>
                            <div class="form-group">
                                <label for="nickname">名称</label>
                                <input id="nickname" class="form-control" name="userNickname" value="${userDetail.userNickname}">
                            </div>
                            <div class="form-group">
                                <label for="sex">性别</label>
                                <div id="sex" class="form-control">
                                    <input id="man" type="radio" name="userSex" value="1" <c:if test="${userDetail.userSex eq 1}">checked = "checked"</c:if>><label
                                        for="man">男</label>
                                    &emsp;
                                    <input id="women" type="radio" name="userSex" value="0" <c:if test="${userDetail.userSex eq 0}">checked = "checked"</c:if>><label
                                        for="women">女</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="birthday">生日</label>
                                <input id="birthday" type="date" class="form-control" name="userBirthday" value="${userDetail.userBirthday}">
                            </div>
                            <div class="form-group">
                                <label for="profession">职业</label>
                                <input id="profession" type="text" class="form-control" name="userProfession" value="${userDetail.userProfession}">
                            </div>
                            <div class="form-group">
                                <label for="city">城市</label>
                                <input id="city" type="text" class="form-control" name="userLivingCity" value="${userDetail.userLivingCity}">
                            </div>
                            <div class="form-group">
                                <label for="language">语言</label>
                                <div id="language" class="form-control" style="height: auto;float: left;">
                                    <c:forEach items="${languagesMap}" var="language">
                                        <span class="languagebind"><input type="checkbox" name="language" title="${language.value}" value="${language.value}"<c:forEach items="${userDetail.userLanguagesAttention}" var="user_language"> <c:if test="${language.value eq user_language}">checked="checked"</c:if></c:forEach>>${language.value}</span>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="motto">箴言/座右铭</label>
                                <textarea id="motto" class="form-control" name="userMotto">${userDetail.userMotto}</textarea>
                            </div>
                        </form>
                        <script>
                            $("input[name=avatar]").fileinput({
                                language:"zh",
                                uploadUrl:"#",
                                maxFileSize:1024,
                                maxFileCount:1,
                                showPreview:false,
                                showRemove:false,
                                showUpload:false,
                                autoReplace:true,
                                allowedFileExtensions:["jpg","png","gif"]
                            })
                        </script>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-success" id="form-update-button">修改</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
