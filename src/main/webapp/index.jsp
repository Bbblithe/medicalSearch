<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<script type="text/javascript">
  $(function (){
    showRecommendation();
    $("#search").click(function(){
      search()
    })
    $(window).keydown(function (event){
      if(event.keyCode == 13){
        search()
      }
    })
  });

  function search(){
    let string = $.trim($("#search_text").val())
    if(string === "") {
      alert("请输入有效问题")
      return false;
    }
    window.location.href = 'entry/search.do?sentence='+string
  }

  function showRecommendation(){
    $.ajax({
      url:"entry/recommend",
      type:"get",
      dataType:"json",
      success:function(data){
        let html = ""
        $.each(data,function(i,n){
          html += '<a style="text-decoration: none; cursor: pointer;" onclick="window.location.href=\'entry/search.do?sentence='+n+'\';">'+n+'</a>';
          html += '<br> <br>'
        })
        $("#recommendation").html(html)
      }
    })
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
<!-- 边框与Logo -->
<div class="goods Wrapper">
  <div class="TopKuang"></div>
  <div class="LogoPlace" style="background-color: white"> <img src="#" alt=""> </div>
</div>
<!-- 搜索框 -->
<div class="Conteny Wrapper">
  <h3>专注育龄期癫痫女性患者的管理</h3>
  <h4>For management of childbearing-age women with epilepsy</h4>
  <div class="DKuang">
     <img src="img/搜索Logo.png" alt="" class="Pic" onclick="search()">
    <%-- <button  class="glyphicon glyphicon-search"></button> --%>
    <input type="text" id="search_text" class="InputKuang" placeholder="您想搜索什么呢？">
  </div>
</div>
<!-- 导航栏 -->
<div class="DaoHang Wrapper">
  <div class="left">
    <span class="Chinese">你可能想问：</span>
    <span class="English">Ask questions like：</span>
  </div>
  <div class="right" id="recommendation">
  </div>
</div>
<!-- 页脚 -->
<div class="foot Wrapper">
  <span>联系我们/Contact us：leilei_25@126.com | 访问我们的本体/About our ontology：<a href="https://bioportal.bioontology.org/ontologies/CAWWEO">https://bioportal.bioontology.org/ontologies/CAWWEO</a></span>
</div>
</body>
</html>
