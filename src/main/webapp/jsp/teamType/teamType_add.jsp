<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TeamType/addTeamType" method="post">
    团队类型名称:<input type="text" name="teamTypeName"><br>
    团队类型状态:<input type="text" name="teamTypeState"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
