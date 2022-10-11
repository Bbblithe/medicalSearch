<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        $(function (){
            $("#search_button").click(function(){
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
            // $.ajax({
            //     url:"entry/search.do",
            //     data:{
            //         "sentence":string
            //     },
            //     type:"get",
            //     dataType:"json",
            //     success:function(result){
            //         let html = ""
            //         $.each(result.showcaseList,function (i,n){
            //             html += '<tr>'
            //             html += '	<td>'+n.chinese+'</td>'
            //             html += '	<td>'+n.english+'</td>'
            //             html += '	<td>'+n.content+'</td>'
            //             html += '	<td>'+n.tag+'</td>'
            //             html += '</tr>'
            //         })
            //         $("#ContentBody").html(html)
            //     }
            // })
        }
    </script>
</head>
<body>
    <h2 style="margin: 0 auto;text-align: center">CaWWE：For management of childbearing-age women with epilepsy
        <br>专注育龄期癫痫女性患者的管理
    </h2>
    <br>
    <br>
    <br>
    <br>
    <div style="width: 800px; margin: 0 auto">
        <img width="50px" src="img/bar.png">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
         <input id="search_text" type="text" class="glyphicon-search" style="width: 500px;" placeholder="请输入你的问题?/Please enter your question?">
         <button id="search_button" class="btn btn-default">搜索/search</button>
    </div>
</body>
</html>