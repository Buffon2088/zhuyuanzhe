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
    <a href="${pageContext.request.contextPath}">首页</a><br><br>
    <a href="${pageContext.request.contextPath}">公告</a><br><br>
    <a href="${pageContext.request.contextPath}">活动列表</a><br><br>
    <a href="${pageContext.request.contextPath}">组织模块</a><br><br>
    <a href="${pageContext.request.contextPath}">个人中心</a><br><br>
    <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}">发送邮件</a><br><br>
    <button>登录</button>
    <button>注册</button>
</div>
</body>
</html>
