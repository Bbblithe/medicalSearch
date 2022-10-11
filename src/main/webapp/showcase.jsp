<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#back").click(function(){
                window.location.href = "index.jsp"
            })
        })
    </script>
</head>
<body>
<h3>
    your question:${question}
</h3>
<div style="width: 800px; margin: 0 auto">
    <c:if test="${map.count!=0}">
        <h4>
            possible answer:
        </h4>
        <c:forEach items="${map.showcaseList}" var="a">
            <div style="border: #0f0f0f solid ;width: 800px">
                <p style="color: slategrey">${a.chinese}/${a.english}</p> <p style="color: grey">(${a.tag}):</p>${a.content}
            </div>
            <br>
        </c:forEach>
        <button id="back">返回查询</button>
    </c:if>
    <c:if test="${map.count==0}">
        <h3 style="color: lightslategrey">没有相关解答/no related answer</h3>
    </c:if>
</div>
</body>
</html>