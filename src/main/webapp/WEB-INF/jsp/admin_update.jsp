<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>adminUpdate</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/updateAdmin" method="post">
    <input type="hidden" name="adminId" value="${adminInfo.adminId}"><br>
    修改用户证件：<input type="text" name="adminCarID" value="${adminInfo.adminCarID}"><br>
    修改用户电话：<input type="text" name="adminTel" value="${adminInfo.adminTel}"><br>
    修改用户名：<input type="text" name="adminLoginName" value="${adminInfo.adminLoginName}"><br>
    修改用户密码：<input type="password" name="adminPwd" value="${adminInfo.adminPwd}"><br>
    修改用户状态：<input type="text" name="adminState" value="${adminInfo.adminState}"><br>
    <input type="submit" value="update">
</form>
</body>
</html>
