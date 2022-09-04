<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/3
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>活动列表</title>
    <style type="text/css">
        .zaoshang{
            background:linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }
        .box{
            width: 250px;height: 250px;border-bottom: #1084f6;background: darkgrey;float: left;margin-left:100px;margin-top: 100px;
        }
        .ziti{
           font-size: 20px;
            font-family: 微软雅黑;
            font-weight: 600;
            color: coral;
        }
        .nowziti{
            font-size: 23px;
            font-family: 微软雅黑;
            font-weight: 600;
            color: #070200;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">
<script>
    function TestchooseActive(){
        alert('触发响应');
        var activeTypeNmae=document.getElementById('activeTypeNmae').innerText;
        alert(activeTypeNmae);
        $.ajax({
            url: '${pageContext.request.contextPath}/Active/findActiveType',
            method: 'post',
            data: {'activeTypeNmae' : activeTypeNmae},
            success: function (data) {
                alert('回调成功');
            }
        });
    }
</script>
<div style="text-align: center;padding-top: 100px;">
    <div style="text-align: center;">
        <h2>新冠疫情志愿服务系统</h2>
        <a href="${pageContext.request.contextPath}/admin/goHome" onclick="testLogin()">首页</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}" onclick="testLogin()">公告</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/Active/findActiveList" onclick="testLogin()">活动列表</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/Active/ActiveList" onclick="testLogin()">组织模块</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}" onclick="testLogin()">个人中心</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}" onclick="testLogin()">发送邮件</a>&nbsp;&nbsp;
        <c:choose>
            <c:when test="${sessionScope.adminInfo.adminId>0}">
                <font>欢迎<font style="color: red;font-family: 仿宋;font-size: 20px;">-${sessionScope.adminInfo.adminLoginName}-</font></font>
                <a href="${pageContext.request.contextPath}/admin/loginOut">退出</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">登录</a>
                <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">注册</a>
            </c:otherwise>
        </c:choose>
    </div>
    <h2>活动界面</h2>
    <font class="nowziti">活动数量：${countNums}</font>
    <c:forEach items="${activeTypeInfoList}" var="li">
       <a href="${pageContext.request.contextPath}/Active/findActiveType?activeTypeId=${li.activeTypeId}" class="ziti">${li.activeTypeName}</a>
    </c:forEach>
    <div style="margin-left: 150px" id="activePage">
        <div class="box">
            <div><p id="activeName">活动名称：@@@</p></div>
        </div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
    </div>
</div>
</body>
</html>
