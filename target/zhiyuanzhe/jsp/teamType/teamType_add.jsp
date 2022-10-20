<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <title>Title</title>
    <script>

        function checkName(){
            var name = document.getElementById('teamTypeName').value;
            var nameFont = $('#nameFont');
            $.ajax({
                url: '${pageContext.request.contextPath}/TeamType/checkName',
                method: 'post',
                data: {'teamTypeName': name},
                success:function (data) {
                    var A = JSON.parse(data)['res'];
                    if (A==0){
                        nameFont.html("类型名已存在");
                        document.getElementById('submit').disabled = true;
                    }else{
                        document.getElementById('submit').disabled = false;
                    }
                }
            })
        }
        $(document).ready(function () {
            $('#teamTypeName').blur(function () {
                //定义需要校验的变量
                var name = $('#teamTypeName').val();
                var nameFont = $('#nameFont')
                var sub = $('#submit');
                $.ajax({
                    url: '${pageContext.request.contextPath}/TeamType/checkName',
                    method: 'post',
                    data: {'teamTypeName': name},
                    success: function (data) {

                        if (data.res != "1") {
                            nameFont.html("名称已经存在！");
                            nameFont.prop("color", "red");
                            sub.prop("disabled", true);
                        } else {
                            nameFont.html("");
                            sub.prop("disabled", false);
                        }
                    }
                });
            });
        });
    </script>
</head>

<script>
    $(document).ready(function () {
        $("#form").submit(function () {
            var name = $('#teamTypeName').val();
            var state = $('#teamTypeState').val();
            var nameFont = $('#nameFont');
            var stateFont = $('#stateFont');
            if (name == null || name == "") {
                nameFont.html("类型名称不能为空！");
                nameFont.prop("color", "red");
                return false;
            } else if (state == null || state == "") {
                nameFont.html("");
                stateFont.html("类型状态不能为空！");
                stateFont.prop("color", "red");
                return false;
            } else {
                nameFont.html("");
                stateFont.html("");
                return true;
            }
        });


    });
</script>


<body>
<form id="form" action="${pageContext.request.contextPath}/TeamType/addTeamType" method="post">
    团队类型名称:<input type="text" name="teamTypeName" id="teamTypeName"><font id="nameFont"></font><br>
    团队类型状态:<input type="text" name="teamTypeState" id="teamTypeState"><font id="stateFont"></font><br>
    <input id="submit" type="submit" value="添加">
</form>
</body>
</html>
