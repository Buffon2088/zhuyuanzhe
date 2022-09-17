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
        .zaoshang {
            background: linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }

        .imgBackground {
            background: linear-gradient(
                    #4e9510 0%, #FFF 80%);
            height: 100%;
        }

        .box {
            width: 250px;
            height: 450px;
            border-bottom: #1084f6;
            background: darkgrey;
            float: left;
            margin-left: 100px;
            margin-top: 100px;
            background: linear-gradient(
                    #6eac38 0%, #FFF 80%);
        }

        .ziti {
            font-size: 20px;
            font-family: 微软雅黑;
            font-weight: 600;
            color: coral;
        }

        .nowziti {
            font-size: 23px;
            font-family: 微软雅黑;
            font-weight: 600;
            color: #070200;
        }

        .activeImg {
            width: 200px;
            height: 180px;
        }

        .button {
            width: 100px;
            height: 35px;
            background: #a3bd3d;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">
<script>
    function TestchooseActive() {
        alert('触发响应');
        var activeTypeNmae = document.getElementById('activeTypeNmae').innerText;
        alert(activeTypeNmae);
        $.ajax({
            url: '${pageContext.request.contextPath}/Active/findActiveType',
            method: 'post',
            data: {'activeTypeNmae': activeTypeNmae},
            success: function (data) {
                alert('回调成功');
            }
        });
    }
</script>
<div style="text-align: center;padding-top: 100px;">
    <div style="text-align: center;">
        <h2>新冠疫情志愿服务系统</h2>
        <a href="${pageContext.request.contextPath}/User/goHome" onclick="testLogin()">首页</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/news/findAll" onclick="testLogin()">公告</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/Active/findActiveList" onclick="testLogin()">活动列表</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/Active/ActiveList" onclick="testLogin()">组织模块</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}" onclick="testLogin()">个人中心</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}"
           onclick="testLogin()">发送邮件</a>&nbsp;&nbsp;
        <c:choose>
            <c:when test="${sessionScope.userInfo.userId>0}">
                <font>欢迎<font
                        style="color: red;font-family: 仿宋;font-size: 20px;">-${sessionScope.userInfo.userName}-</font></font>
                <a href="${pageContext.request.contextPath}/User/loginOut">退出</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/jsp/userHome/user_login.jsp">登录</a>
                <a href="${pageContext.request.contextPath}/jsp/userHome/add_user.jsp">注册</a>
            </c:otherwise>
        </c:choose>
    </div>
    <h2>活动界面</h2>
    <font class="nowziti">活动总数量：${countNums}</font><br><br>
    <c:forEach items="${activeTypeInfoList}" var="li">
        <c:choose>
            <c:when test="${li.activeTypeState=='已发布'}">
                <a href="${pageContext.request.contextPath}/Active/findActiveType?activeTypeId=${li.activeTypeId}"
                   class="ziti">${li.activeTypeName}</a>
            </c:when>
        </c:choose>
    </c:forEach>
    <div style="margin-left: 150px" id="activePage">
        <c:forEach items="${activeInfoList}" var="li">
            <c:choose>
                <c:when test="${li.activeState=='上线'}">
                    <div class="box">
                        <div>
                            <p id="activeName">活动名称：${li.activeName}</p>
                            <img src="${pageContext.request.contextPath}/img/${li.img}" class="activeImg">
                            <p>开始时间：${li.activeStartTime}</p>
                            <p>结束时间：${li.activeEndTime}</p>
                            <p>活动地点：${li.activeAddress}</p>
                            <p>人数(Now/Max)：${li.activeNum}/${li.activeHighNum}</p>
                            <a href="${pageContext.request.contextPath}/User/findActiveById?activeId=${li.activeId}"><input type="button" value="查看详情" class="button"></a>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </c:forEach>
   </div>
</div>
</body>
</html>
