<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TeamType/updateTeamType" method="post">
    <input type="hidden" name="teamTypeId" value="${teamTypeInfo.teamTypeId}">
    修改团队类型名称:<input type="text" name="teamTypeName" value="${teamTypeInfo.teamTypeName}"><br>
    修改团队类型状态:<input type="text" name="teamTypeState" value="${teamTypeInfo.teamTypeState}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
