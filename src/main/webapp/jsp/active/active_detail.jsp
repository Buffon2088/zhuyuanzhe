<%--
  Created by IntelliJ IDEA.
  User: wujun
  Date: 2022/9/10
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>活动详情</title>
    <style type="text/css">
        body {
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            background: linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }

        .allDiv {
            width: 80%;
            height: 300px;
            margin: 0 auto;
            padding-left: 220px;
            padding-top: 50px;
        }

        .imgDiv {
            width: 40%;
            height: 240px;
            float: left;
            text-align: left;

        }

        .fontDiv {
            width: 30%;
            height: 240px;
            float: left;
            text-align: center;
            margin-left: 100px;
        }

        .detailDiv {
            width: 100%;
            height: 33px;
            text-align: left;
        }
        .detailButton2 {
            background: darkgray;
            width: 20%;
            height: 28px;
            float: left;
        }
        .detailButton {
            background: darkgray;
            width: 20%;
            height: 28px;
            float: left;
            margin-left: 20px;
        }

        .introduceDiv {
            height: 30px;
            width: 100%;
            text-align: center;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            $('#rel').click(function () {
                window.location.href = "${pageContext.request.contextPath}//";
            })
            $('#back').click(function () {
                window.location.href = "${pageContext.request.contextPath}/Active/findActiveList";
            })
        })
    </script>
</head>
<body>
<div class="allDiv">
    <div style="padding-top: 200px; text-align: center">
        <div class="imgDiv">
            <img src="${pageContext.request.contextPath}/img/${activeInfo.img}" width="100%" height="345px">
            <h2>活动介绍</h2>
            <p>${activeInfo.activeContext}</p>
        </div>
        <input type="hidden" id="activeId" value="${activeInfo.activeId}">

        <div class="fontDiv">
            <div class="detailDiv"><h3>${activeInfo.activeName}</h3></div>
            <div class="detailDiv">活动类型：${activeInfo.activeTypeInfo.activeTypeName}</div>
            <div class="detailDiv">开始时间：${activeInfo.activeStartTime}</div>
            <div class="detailDiv">结束时间：${activeInfo.activeEndTime}</div>
            <div class="detailDiv">活动地点：${activeInfo.activeAddress}</div>
            <div class="detailDiv">活动发起人：${activeInfo.adminInfo.adminLoginName}</div>
            <div class="detailDiv">活动状态：${activeInfo.activeState}</div>
            <div class="detailDiv">活动最多人数：${activeInfo.activeHighNum}</div>
            <div class="detailDiv">活动当前参与人数：${activeInfo.activeJoinNum}</div>
            <c:choose>
                <c:when test="${activeState=='立即报名'}">
                    <a href="${pageContext.request.contextPath}/Active/findActiveList" class="detailButton2">${activeState}</a>
                </c:when>
                <c:otherwise>
                    <a href="#" class="detailButton2">${activeState}</a>
                </c:otherwise>
            </c:choose>

            <a href="${pageContext.request.contextPath}" class="detailButton">返回</a>
        </div>
    </div>
</div>


</body>
</html>
