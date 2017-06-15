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
    <div class="questionBox">
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
        <div class="markdown-guide" style="display: none">
            <div class="guideBox" style="display: none">
                <h4 style="margin: 5px 0;">markdown常用指南</h4>
                <hr>
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel">
                                <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    标题
                                </a>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <p>标题有两种表示方法(类Setext和类atx形式)</p>
                            <p>类Setext形式是用底线的形式，利用=(最高阶标题)和-(第二阶标题)，且任何数量的=和-都可以有效果</p>
                            <code>我是最高阶标题H1
                                <br>
                                ===============
                                <br>
                                我是第二阶标题H2
                                <br>
                                ---------------
                            </code>

                            <p>类Atx形式则是在行首插入1到6个#，对应到标题1到6阶</p>
                            <code># 这是 H1
                                <br>
                                ## 这是 H2
                                <br>
                                ###### 这是 H6
                            </code>
                        </div>
                    </div>
                    <div class="panel">
                                <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    代码(区块/行)
                                </a>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <p>代码区块有两种表示方式（tab或波浪键）</p>
                            <p>只要按一下tab键(或五个空格键)即可进入代码区块，但要为该行前面空出一行才能触发(如果是第一行则不需要)</p>
                            <code>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我是代码区块
                            </code>
                            <p>前后按三下波浪键(tab键上面)，两行中间填入任何文字，即可触发代码区块，该方式不需要前面为其空出一行</p>
                            <code>
                                ```<br>
                                我是代码区块<br>
                                ```<br>
                            </code>
                            <hr>
                            <p>同一行中前后按波浪键，中间填入任何文字，即可触发代码行，代码行可嵌在文字中</p>
                            <code>
                                我后面有代码行`我是代码行`我前面有代码行
                            </code>
                        </div>
                    </div>
                    <div class="panel">
                                <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    区块
                                </a>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                            <p>区块可用&gt;表示</p>
                            <code>
                                &gt;我是区块
                            </code>
                            <p>区块可嵌套markdown，包括区块</p>
                            <code>
                                &gt;我是区块<br>
                                &gt;&gt;我是被嵌套区块`我是区块里的代码行`
                            </code>
                        </div>
                    </div>
                    <div class="panel">
                                <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                    链接
                                </a>
                        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                            <p>自动链接比较简单，只需要用&lt;&gt;包裹住</p>
                            <code>&lt;http://baidu.com&gt;</code>
                            <p>行内式链接，只要在方块括号后面紧接着圆括号并插入网址链接即可，如果你还想要加上链接的title(鼠标悬疑一秒的提示)，只要在网址后面，用双引号把 title 文字包起来即可</p>
                            <code>这是[行内式链接](http://example.com/ "Title")</code>
                            <p>参考式链接，在链接文字的括号后面再接上另一个方括号，而在第二个方括号里面要填入用以辨识链接的标记</p>
                            <code>
                                前往[百度首页] [1]<br>
                                前往[google首页] [2]<br>
                                [1]: http://baidu.com/  "百度"<br>
                                [2]: http://google.com/  "Google"
                            </code>
                            <p>如果第二个方括号不填，则第一个方括号的文字要和下面的链接方括号中的文字相同</p>
                            <code>
                                [百度][]<br>
                                [百度]: http://baidu.com/
                            </code>
                        </div>
                    </div>
                    <div class="panel">
                                <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                    列表
                                </a>
                        <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
                            <p>无序列表有三种表示方法，在每一项前面加(星号/加号/减号)+空格都可以识别为无序列表</p>
                            <code>
                                *&nbsp;first<br>
                                +&nbsp;second<br>
                                -&nbsp;third
                            </code>
                            <p>有序列表在每一项的前面加数字+点号+空格就可以识别为有序列表，其中数字有没有序都无所谓</p>
                            <code>
                                1.&nbsp;first<br>
                                2.&nbsp;second<br>
                                3.&nbsp;third
                            </code>
                        </div>
                    </div>
                    <div class="panel">
                        <a class="collapsed a-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                            其他
                        </a>
                        <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
                            <p><strong>分隔线：</strong>在一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西</p>
                            <code>
                                ***<br>
                                <br>
                                -------<br>
                                _____<br>
                            </code>
                            <p><strong>加粗：</strong>前后两个星号包围起来</p>
                            <code>
                                **我会被加粗**
                            </code>
                            <p><strong>斜体：</strong>前后一个星号包围起来</p>
                            <code>
                                *我是斜体*
                            </code>
                            <p><strong>转义字符：</strong>用反斜杠来插入一些在语法中有其它意义的符号</p>
                            <code>
                                \*我不会变成斜体\*
                                \*\*我不会被加粗\*\*
                            </code>
                            <hr>
                            <p>markdown兼容html，所以如果有必要，部分可以用html代替，如表格tabel</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="previewBox">

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
<style>
    .panel{
        border-radius: 10px;
        background: none;
    }
    .panel>.a-btn{
        display: block;
        border-radius: 20px;
        background: black;
        opacity: .6;
    }
    .panel>div{
        padding: 3px 5px;
        word-wrap: break-word;
    }
</style>
</html>
