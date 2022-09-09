<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/9
  Time: 19:56
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
    <a href="${pageContext.request.contextPath}/TeamType/showTypeAdd">添加</a>
    <tr>
        <td>团队类型名称</td>
        <td>团队类型状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${teamTypeList}" var="teamT">
        <tr>
            <td>${teamT.teamTypeName}</td>
            <td>${teamT.teamTypeState}</td>
            <td>
                <a href="${pageContext.request.contextPath}/TeamType/showById?teamTypeId=${teamT.teamTypeId}">修改</a>
                <a href="${pageContext.request.contextPath}/TeamType/deleteTeamType?teamTypeId=${teamT.teamTypeId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
