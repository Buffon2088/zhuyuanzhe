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
            height: 500px;
            border-bottom: #1084f6;
            background: darkgrey;
            float: left;
            margin-left: 100px;
            margin-top: 100px;
            background: linear-gradient(
                    #6eac38 0%, #FFF 80%);
        }

        .boxDown {
            width: 250px;
            height: 500px;
            border-bottom: #a9afb4;
            background: darkgrey;
            float: left;
            margin-left: 100px;
            margin-top: 100px;
            background: linear-gradient(
                    #343832 0%, #FFF 80%);
        }

        .boxWeiHu {
            width: 250px;
            height: 500px;
            border-bottom: #1084f6;
            background: darkgrey;
            float: left;
            margin-left: 100px;
            margin-top: 100px;
            background: linear-gradient(
                    #c90b38 0%, #FFF 80%);
        }

        .ziti {
            font-size: 20px;
            font-family: 微软雅黑;
            font-weight: 600;
            color: #086d29;
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
            background: #367f56;
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
        <a href="${pageContext.request.contextPath}" onclick="testLogin()">查看管理员</a>
        <a href="${pageContext.request.contextPath}/news/findAll" onclick="testLogin()">公告管理</a>
        <a href="${pageContext.request.contextPath}/Active/showAllActive" >活动管理</a>
        <a href="${pageContext.request.contextPath}">组织管理</a>
        <a href="${pageContext.request.contextPath}/admin/ActRequest">审核</a>
        <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}" onclick="testLogin()">发送邮件</a><br><br>
        <c:choose>
            <c:when test="${sessionScope.adminInfo.adminId>0}">
                <font>欢迎<font
                        style="color: red;font-family: 仿宋;font-size: 20px;">-${sessionScope.adminInfo.adminLoginName}-</font></font>
                <a href="${pageContext.request.contextPath}/User/loginOut">退出</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/jsp/userHome/user_login.jsp">登录</a>
                <a href="${pageContext.request.contextPath}/jsp/userHome/add_user.jsp">注册</a>
            </c:otherwise>
        </c:choose>
    </div>
    <h2>类型管理</h2>
    <a href="${pageContext.request.contextPath}/activeType/addPublic?url=/active/add_activeType"><p>新增类型</p></a>
    <a href="${pageContext.request.contextPath}/Active/adminFindType"
       class="ziti">全部</a><br><br>
    <c:forEach items="${activeTypeInfoList}" var="li">
        <a href="${pageContext.request.contextPath}/Active/findActiveTypeAdmin?activeTypeId=${li.activeTypeId}"
           class="ziti">${li.activeTypeName}</a>
        <a href="${pageContext.request.contextPath}/activeType/addPublic?url=/active/add_activeType&state=update&activeTypeId=${li.activeTypeId}"
           style="margin-left: 100px">修改</a>
        <a href="${pageContext.request.contextPath}/activeType/delActiveType?activeTypeId=${li.activeTypeId}">删除</a>
        <c:choose>
            <c:when test="${li.activeTypeState=='已发布'}">
                <a href="#">已发布</a>
            </c:when>
            <c:when test="${li.activeTypeState=='维护中'}">
                <a href="#">维护中</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/activeType/publishActiveType?activeTypeId=${li.activeTypeId}&activeTypeState=已发布">待发布</a>
            </c:otherwise>
        </c:choose>
        <br><br>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/activeType/addPublic?url=/active/add_activeType&state=addActive"><p>
        新增活动</p></a>
    <div style="margin-left: 150px" id="activePage">
        <c:forEach items="${activeInfoList}" var="li">
            <c:choose>
                <c:when test="${li.activeState=='下线'}">
                    <div class="boxDown">
                        <div>
                            <p>活动名称：${li.activeName}</p>
                            <img src="${pageContext.request.contextPath}/img/${li.img}" class="activeImg">
                            <p>开始时间：${li.activeStartTime}</p>
                            <p>结束时间：${li.activeEndTime}</p>
                            <p>活动地点：${li.activeAddress}</p>
                            <p>人数(Now/Max)：${li.activeNum}/${li.activeHighNum}</p>
                            <p style="color: #101047;font-size: 20px;">当前状态：${li.activeState}</p>
                            <a href="${pageContext.request.contextPath}/Active/upDownAct?state=delAct&activeId=${li.activeId}"><input
                                    type="button" value="删除" class="button" style="background: red;"></a>
                            <a href="${pageContext.request.contextPath}/Active/upDownAct?state=upAct&activeId=${li.activeId}"><input
                                    type="button" value="上架" class="button"></a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${li.activeState=='上线'}">
                    <div class="box">
                        <div>
                            <p id="activeName">活动名称：${li.activeName}</p>
                            <img src="${pageContext.request.contextPath}/img/${li.img}" class="activeImg">
                            <p>开始时间：${li.activeStartTime}</p>
                            <p>结束时间：${li.activeEndTime}</p>
                            <p>活动地点：${li.activeAddress}</p>
                            <p>人数(Now/Max)：${li.activeNum}/${li.activeHighNum}</p>
                            <p style="color:green;font-size: 20px;">当前状态：${li.activeState}</p>
                            <a href="${pageContext.request.contextPath}/activeType/addPublic?activeId=${li.activeId}&state=updateAct"><input
                                    type="button" value="修改" class="button"></a>
                            <a href="${pageContext.request.contextPath}/Active/upDownAct?state=DownAct&activeId=${li.activeId}"><input
                                    type="button" value="下架" class="button"></a>
                        </div>
                    </div>
                </c:when>
                <c:when test="${li.activeState=='维护中'}">
                    <div class="boxWeiHu">
                        <div>
                            <p>活动名称：${li.activeName}</p>
                            <img src="${pageContext.request.contextPath}/img/${li.img}" class="activeImg">
                            <p>开始时间：${li.activeStartTime}</p>
                            <p>结束时间：${li.activeEndTime}</p>
                            <p>活动地点：${li.activeAddress}</p>
                            <p>人数(Now/Max)：${li.activeNum}/${li.activeHighNum}</p>
                            <p style="color:red;font-size: 20px;">当前状态：${li.activeState}</p>
                            <a href="${pageContext.request.contextPath}/activeType/addPublic?activeId=${li.activeId}&state=updateAct"><input
                                    type="button" value="修改" class="button"></a>
                            <a href="${pageContext.request.contextPath}/Active/upDownAct?state=upAct&activeId=${li.activeId}"><input
                                    type="button" value="上架" class="button"></a>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </c:forEach>
    </div>
</div>
</body>
</html>
