<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TeamJob/updateTeamJob" method="post">
  <input name="teamJobId" type="hidden" value="${teamJobInfo.teamJobId}"><br>
  职位名称:<input name="teamJobName" type="text" value="${teamJobInfo.teamJobName}"><br>
  职位状态:<input name="teamJobState" type="text" value="${teamJobInfo.teamJobState}"><br>
  <input type="submit" value="修改">
</form>
</body>
</html>
