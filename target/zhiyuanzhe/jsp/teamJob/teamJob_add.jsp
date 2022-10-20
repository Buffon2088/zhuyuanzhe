<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <title>Title</title>
</head>
<script>
    $(document).ready(function () {
        $("#JobForm").submit(function () {
            var name = $('#teamJobName').val();
            var state = $('#teamJobState').val();
            var nameFont = $('#nameFont');
            var stateFont = $('#stateFont');
            if (name==null || name==""){
                nameFont.html("类型名称不能为空！");
                nameFont.prop("color","red");
                return false;
            }else if(state==null || state==""){
                nameFont.html("");
                stateFont.html("职位状态不能为空！");
                stateFont.prop("color","red");
                return false;
            }else{
                nameFont.html("");
                stateFont.html("");
                return true;
            }
        });

    });
</script>
<script>
    function resName(){
        var name = document.getElementById('teamJobName').value;
        var nameFont = $('#nameFont');
        $.ajax({
            url:'${pageContext.request.contextPath}/TeamJob/resName',
            method:'post',
            data:{'teamJobName':name},
            success:function (data){
                var X = JSON.parse(data)['res'];
                if(X == 0){
                    nameFont.html("职位名称已存在");
                    nameFont.prop("color","red");
                    document.getElementById('submit').disabled = true;
                }else{
                    nameFont.html("");
                    document.getElementById('submit').disabled = false;
                }
            }
        })
    }
</script>


<body>
<form id="JobForm" action="${pageContext.request.contextPath}/TeamJob/addTeamJob" method="post">
  职位名称:<input name="teamJobName" type="text" id="teamJobName" onblur="resName()"><font id="nameFont"></font><br>
  职位状态:<input name="teamJobState" type="text" id="teamJobState"><font id="stateFont"></font><br>
  <input id="submit" type="submit" value="添加">
</form>
</body>
</html>
