<%@page pageEncoding="UTF-8" %>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand 和 小屏自动切换模式 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="/static/img/infiniteloop.png" style="height: 100%;"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">问题</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">语言 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">python</a></li>
                        <li><a href="#">java</a></li>
                        <li><a href="#">javascript</a></li>
                        <li><a href="#">php</a></li>
                        <li><a href="#">C#</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" action="/question/query" method="get">
                <div class="form-group">
                    <input type="text" name="queryString" class="form-control" placeholder="Search" value="${TagOrString}">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>



            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty sessionScope.userId}">
                    <li><a href="/user/login">登录</a></li>
                    <li><a href="/user/register">注册</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.userId}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:if test="${not empty sessionScope.nickname}">${sessionScope.nickname}</c:if><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/detail">个人资料</a></li>
                            <li><a href="#">。。。</a></li>
                            <li><a href="#">。。。</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/user/logout">注销</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
