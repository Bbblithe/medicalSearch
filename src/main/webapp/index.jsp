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
    <br><br>
    <a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='entry/search.do?sentence=妊娠期抗癫痫治疗的注意事项'">妊娠期抗癫痫治疗的注意事项</a>
    <a style="text-decoration: none; cursor: pointer; font-size: 15px" onclick="window.location.href='entry/search.do?sentence=Anti-epileptic treatment during Pregnancy'" >Anti-epileptic treatment during pregnancy</a>
    <br>
    <a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='entry/search.do?sentence=哺乳期是否可以服用左乙拉西坦'">哺乳期是否可以服用左乙拉西坦</a>
    <a style="text-decoration: none; cursor: pointer; font-size: 15px" onclick="window.location.href='entry/search.do?sentence=Can patients take Levetiracetam while breastfeeding'" >Can patients take levetiracetam while breastfeeding</a>
    <br>
    <a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='entry/search.do?sentence=可能导致肥胖的抗癫痫药物'">可能导致肥胖的抗癫痫药物</a>
    <a style="text-decoration: none; cursor: pointer; font-size: 15px" onclick="window.location.href='entry/search.do?sentence=Antiseizure medications  causing obesity'" >Anti-epileptic drugs causing obesity</a>
    <br>
    <a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='entry/search.do?sentence=丙戊酸钠是否有致畸性'">丙戊酸钠是否有致畸性</a>
    <a style="text-decoration: none; cursor: pointer; font-size: 15px" onclick="window.location.href='entry/search.do?sentence=Sodium valproate'" >Does Sodium valproate have teratogenicity</a>
    <br>
    <a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='entry/search.do?sentence=了解更多：卡马西平'">了解更多：卡马西平</a>
    <a style="text-decoration: none; cursor: pointer; font-size: 15px" onclick="window.location.href='entry/search.do?sentence=Learn more about Carbamazepine'" >Learn more about Carbamazepine</a>
    <br>
  </div>
</div>
<!-- 页脚 -->
<div class="foot Wrapper" style="position: fixed;bottom: 0">
  <span>联系我们/Contact us：leilei_25@126.com | 访问我们的本体/About our ontology：<a href="https://bioportal.bioontology.org/ontologies/CAWWEO">https://bioportal.bioontology.org/ontologies/CAWWEO</a></span>
</div>
</body>
</html>
