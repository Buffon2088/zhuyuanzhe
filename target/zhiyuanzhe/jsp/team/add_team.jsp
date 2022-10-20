<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/18
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Team/addTeam" method="post">
    请输入组织名称：<input name="teamName" type="text"><br>
    请输入组织介绍：<input name="teamState" type="text"><br>
    <input type="submit" value="确认创建">
</form>
</body>
</html>
