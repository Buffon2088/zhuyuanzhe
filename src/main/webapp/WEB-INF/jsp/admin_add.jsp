<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>AddAdmin</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/addAdmin" method="post">
    用户身份证：<input type="text" name="adminCarID"><br>
    用户电话：<input type="text" name="adminTel"><br>
    用户名：<input type="text" name="adminLoginName"><br>
    用户密码：<input type="password" name="adminPwd"><br>
    用户状态：<input type="text" name="adminState"><br>
    <input type="submit" value="add">
</form>
</body>
</html>
