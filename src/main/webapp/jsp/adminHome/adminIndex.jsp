<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<style type="text/css">
    .zaoshang{
        background:linear-gradient(
                #1084f6 0%, #FFF 80%);
        height: 100%;
    }
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<body class="zaoshang">

<div style="text-align: center;padding-top: 200px;">
    <h2>新冠疫情志愿服务后台管理系统</h2>
    <a href="${pageContext.request.contextPath}" onclick="testLogin()">查看管理员</a><br><br>
    <a href="${pageContext.request.contextPath}/news/findAll" onclick="testLogin()">公告管理</a><br><br>
    <a href="${pageContext.request.contextPath}/Active/showAllActive" >活动管理</a><br><br>
    <a href="${pageContext.request.contextPath}">组织管理</a><br><br>
    <a href="${pageContext.request.contextPath}">审核</a><br><br>
    <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}" onclick="testLogin()">发送邮件</a><br><br>
    <c:choose>
        <c:when test="${sessionScope.adminInfo.adminId>0}">
            <p>欢迎<font style="color: red;font-family: 仿宋;font-size: 20px;">-${sessionScope.adminInfo.adminLoginName}-</font>登录</p><br>
            <a href="${pageContext.request.contextPath}/admin/loginOut">退出</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">登录</a>
            <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">注册</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
<script>
    function testLogin(){
        var loginName="${sessionScope.adminInfo.adminLoginName}";
        if (loginName==""){
            window.location = '${sessionScope.adminInfo.adminLoginName}/jsp/adminHome/adminIndex.jsp';
            alert('请您先登录');
        }
    }
</script>
</html>
