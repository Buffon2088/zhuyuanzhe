<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/5
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
    <title>添加公告</title>

</head>
<style type="text/css">
    .zaoshang{
        background:linear-gradient(
                #1084f6 0%, #FFF 80%);
        height: 100%;
    }
</style>
<body class="zaoshang">
<div style="text-align: center; padding-top: 200px">
    <form action="${pageContext.request.contextPath}/news/addNews" method="post">
        公告标题:<input type="text" name="activeNewsName" ><br>

        咨询内容:<textarea name="activeNewsContext" >

         </textarea><br>

        发布时间:<input type="date" name="activeNewsTime"><br>

        发布人:  <select name="adminInfo.adminId">
        <c:forEach items="${adminList}" var="li">
            <option value="${li.adminId}">${li.adminLoginName}</option>
        </c:forEach>
    </select><br>
        <input type="submit" value="添加">
    </form>
</div>

</body>
</html>
