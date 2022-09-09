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
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TeamJob/addTeamJob" method="post">
  职位名称:<input name="teamJobName" type="text"><br>
  职位状态:<input name="teamJobState" type="text"><br>
  <input type="submit" value="添加">
</form>
</body>
</html>
