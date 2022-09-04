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
<body class="zaoshang">

<div style="text-align: center;padding-top: 200px;">
    <h2>新冠疫情志愿服务系统</h2>
    <a href="${pageContext.request.contextPath}/admin/goHome" onclick="testLogin()">首页</a><br><br>
    <a href="${pageContext.request.contextPath}" onclick="testLogin()">公告</a><br><br>
    <a href="${pageContext.request.contextPath}" onclick="testLogin()">活动列表</a><br><br>
    <a href="${pageContext.request.contextPath}" onclick="testLogin()">组织模块</a><br><br>
    <a href="${pageContext.request.contextPath}" onclick="testLogin()">个人中心</a><br><br>
    <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}" onclick="testLogin()">发送邮件</a><br><br>
    <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">登录</a>
    <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">注册</a>
</div>
</body>
<script>
    function testLogin(){
        var loginName="${sessionScope.adminInfo.adminLoginName}";
        if (loginName==""){
            alert('请您先登录');
        }
    }
</script>
<script>
    function login(){
        var loginName="${sessionScope.adminInfo.adminLoginName}";
        if (loginName!=""){
        }else {

        }
    }
</script>
</html>
