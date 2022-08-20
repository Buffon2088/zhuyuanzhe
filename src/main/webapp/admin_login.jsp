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
    <title>adminLogin</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/adminLogin" method="post">
    登录名：<input type="text" name="adminLoginName" id="loginK"><span id="tip">用户名不可为空</span><br>
    密码：<input type="password" name="adminPwd" id="passK">
    <a href="">找回密码</a>
    <input value="login" type="submit">
</form>



<script>
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
</script>
</body>
</html>
