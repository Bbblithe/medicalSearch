<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>showcase</title>
  <link rel="stylesheet" href="jquery/show.css">
</head>
<body>
<!-- 边框与Logo -->
<div class="goods Wrapper">
  <div class="TopKuang"></div>
  <div class="LogoPlace" style="background-color: white"> <img src="#" alt=""> </div>
</div>
<!-- Title标题 -->
<div class="Title Middle">
  <div>
    <span class="Question">您的问题/Your Question：</span><span class="Question">${question}</span>
  </div>

  <div class="AnswerTitle">
    <span style="font-size: 25px" id="possible">
      可能的答案：
    </span>
    <br>
    <span id="e_Possible">
      Possible answer:
    </span>
  </div>
</div>

<!-- 解答内容 -->
<c:if test="${map.count!=0}">
  <div class="Content Middle">
      <c:forEach items="${map.showcaseList}" var="a">
        <div class="Answer">
          <p style="color: slategrey">${a.chinese}/${a.english}</p> <p style="color: grey">(${a.tag}):</p>${a.content}
        </div>
           <br>
      </c:forEach>
    <br><br>
  </div>
</c:if>
<c:if test="${map.count==0}">
  <script type="text/javascript">
    $("#possible").append('<span style="color: lightslategrey">暂时没有相关解答</span>')
    $("#e_Possible").append('<span style="color: lightslategrey">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' +
            ' no relevant answer</span>')
  </script>
</c:if>

<div class="foot" style="position: fixed;bottom: 0">
  <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    联系我们/Contact us：leilei_25@126.com | 访问我们的本体/About our ontology：<a href="https://bioportal.bioontology.org/ontologies/CAWWEO">https://bioportal.bioontology.org/ontologies/CAWWEO</a></span>
</div>
<div class="bottom_right">
  <img src="img/search_button.png" onclick="window.location.href = 'index.jsp'">
</div>
</body>
</html>