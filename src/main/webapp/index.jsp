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
            $.ajax({
                url:"entry/search.do",
                data:{
                    "sentence":string
                },
                type:"get",
                dataType:"json",
                success:function(result){
                    let html = ""
                    $.each(result.showcaseList,function (i,n){
                        html += '<tr>'
                        html += '	<td>'+n.chinese+'</td>'
                        html += '	<td>'+n.english+'</td>'
                        html += '	<td>'+n.content+'</td>'
                        html += '	<td>'+n.tag+'</td>'
                        html += '</tr>'
                    })
                    $("#ContentBody").html(html)
                }
            })
        }
    </script>
</head>
<body>
    <div class="input-group">
        <input type="text" class="form-control" id="search_text" placeholder="搜索问题（支持中文/Eng）">
        <span class="input-group-btn">
        <button class="btn btn-default" id="search_button" type="button" data-dismiss="alert">Go!</button>
      </span>
    </div>
    <table class="table table-hover">
        <thead>
        <tr style="color: #B3B3B3;">
            <td>中文</td>
            <td>英文</td>
            <td>内容</td>
            <td>标签</td>
        </tr>
        </thead>
        <tbody id="ContentBody">
        </tbody>
    </table>
</body>
</html>