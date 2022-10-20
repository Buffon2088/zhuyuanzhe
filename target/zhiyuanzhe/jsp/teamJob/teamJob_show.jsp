<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <a href="${pageContext.request.contextPath}/TeamJob/showAdd">添加</a>
  <tr>
    <td>职位名称</td>
    <td>职位状态</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${teamJobList}" var="teamJ">
    <tr>
      <td>${teamJ.teamJobName}</td>
      <td>${teamJ.teamJobState}</td>
      <td>
        <a href="${pageContext.request.contextPath}/TeamJob/showById?teamJobId=${teamJ.teamJobId}">修改</a>
        <a href="${pageContext.request.contextPath}/TeamJob/deleteTeamJob?teamJobId=${teamJ.teamJobId}">删除</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
