<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#search").click(function () {
            search()
        })
        $(window).keydown(function (event) {
            if (event.keyCode == 13) {
                search()
            }
        })
    });

    function search() {
        let string = $.trim($("#search_text").val())
        if (string === "") {
            alert("请输入有效问题")
            return false;
        }
        window.location.href = 'entry/search.do?sentence=' + string
    }

</script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QuestionPage</title>
    <link rel="stylesheet" href="jquery/Website.css">
</head>
<body>
<div class="Conteny">
    <img style="transform: rotate(315deg)" src="${pageContext.request.contextPath}/img/logo.jpg"
         alt="" class="Logo">
    <h3>育龄期女性癫痫患者全程管理问答系统</h3>
    <h4>Question answering system for management of women with epilepsy of child-bearing age</h4>
    <div class="DKuang">
        <img src="${pageContext.request.contextPath}/img/SearchLogo.png" alt="" class="Pic"
             onclick="search()">
        <%-- <button  class="glyphicon glyphicon-search"></button> --%>
        <input type="text" id="search_text" class="InputKuang" placeholder="您想搜索什么呢？">
    </div>
</div>
<!-- 导航栏 -->
<div class="DaoHang Wrapper">
    <div class="left">
        <span class="Chinese">问题示例：</span>
        <span class="English">Sample Questions:</span>
    </div>
    <div class="right" id="recommendation">
        <br><br>
        <a style="text-decoration: none; cursor: pointer;"
           onclick="window.location.href='entry/search.do?sentence=妊娠期抗癫痫治疗的注意事项'">妊娠期抗癫痫治疗的注意事项</a>
        <a style="text-decoration: none; cursor: pointer; font-size: 14px"
           onclick="window.location.href='entry/search.do?sentence=Anti-epileptic treatment during Pregnancy'">Anti-epileptic
            treatment during pregnancy</a>
        <br>
        <a style="text-decoration: none; cursor: pointer;"
           onclick="window.location.href='entry/search.do?sentence=哺乳期是否可以服用左乙拉西坦'">哺乳期是否可以服用左乙拉西坦</a>
        <a style="text-decoration: none; cursor: pointer; font-size: 14px"
           onclick="window.location.href='entry/search.do?sentence=Can patients take Levetiracetam while breastfeeding'">Can
            patients take levetiracetam while breastfeeding</a>
        <br>
        <br>
    </div>
</div>
<!-- 页脚 -->
<div class="foot Wrapper" style="position: fixed;bottom: 0">
    联系我们/Contact us：leilei_25@126.com | 访问我们的本体/About our ontology：<a
        href="https://bioportal.bioontology.org/ontologies/CAWWEO">https://bioportal.bioontology.org/ontologies/CAWWEO</a>
</div>
</body>
</html>
