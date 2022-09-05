<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <style type="text/css">
        .zaoshang{
            background:linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }
    </style>
    <title>adminLogin</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">
<div style="text-align: center;padding-top: 300px;">
    <form action="${pageContext.request.contextPath}/User/userLogin" method="post">
        <h2>用户登录</h2>
        <h5><a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">管理员登录</a></h5>
        账号：<input type="text" name="userLoginName" id="loginK"><span id="tip"></span><br><br>
        密码：<input type="password" name="userPwd" id="passK"><br><br>

        <input value="login" type="submit">
        <a href="">找回密码</a>
    </form>
</div>




<%--<script>
var tip=document.getElementById('tip');
var loginK=document.getElementById('loginK');
var loginName=$('#logink').val();
loginK.onblur=function (){
    alert(loginName);
    if (loginName==''){
        alert('用户名不可为空!');
    }else{
        alert(loginName);
        alert('有密码')
    }
}
</script>--%>
</body>
</html>
