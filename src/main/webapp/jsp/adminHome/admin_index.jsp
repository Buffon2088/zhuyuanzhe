<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>adminList</title>
</head>
<body>
<table>
    <tr>
        <td>证件号码</td>
        <td>电话号码</td>
        <td>用户名称</td>
        <td>用户密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${adminList}" var="li">
        <tr>
            <td>${li.adminCarID}</td>
            <td>${li.adminTel}</td>
            <td>${li.adminLoginName}</td>
            <td>${li.adminPwd}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/showById?adminId=${li.adminId}">修改</a>
                <a href="${pageContext.request.contextPath}/admin/deleteAdmin?adminId=${li.adminId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
