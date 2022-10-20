<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/5
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告栏</title>
    <%--    <script>
            // 使用方式一
            confirm("这样写可以直接显示,不接收返回值。")
            // 使用方式二
            var x;
            var r=confirm("请按下按钮!");
            if (r==true){
                x="你按下的是\"确定\"按钮。";
            }
            else{
                x="你按下的是\"取消\"按钮。";
            }
            document.write(x)
        </script>--%>
    <%--    <script>
            //方式一
            prompt("开心吗?"); // 这个显示内容也可以不写，但就没有交互的意义了。

            //方式二
            var x;
            var name=prompt("请输入你的名字","Keafmd");
            var name=prompt("请输入你的密码","Keafmd"); //显示默认文本 "Keafmd"
            if (name!=null && name!=""){
                x="你好! " + name + "。";
                document.write(x)
            *}
        </script>--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<style type="text/css">
    .zaoshang {
        background: linear-gradient(
                #1084f6 0%, #FFF 80%);
        height: 100%;
    }

    table {

        width: 1500px;
        text-align: center;
        border-collapse: collapse;
        margin-left: 200px;
    }

    table caption {

        font-size: 2em;

        font-weight: bold;

        margin: 1em 0;
    }

    th, td {
        border: 1px solid #999;

        text-align: center;

        padding: 10px 0;
    }

    table thead tr {

        background-color: #008c8c;

        color: #fff;
    }

    table tbody tr:nth-child(odd) {

        background-color: #eee;
    }

    table tbody tr:hover {

        background-color: #ccc;
    }

    table tbody tr td:first-child {

        color: darkgray;
    }

    table tfoot tr td {

        text-align: center;

        padding-right: 20px;
    }

    .ziti {
        font-size: 20px;
    }


</style>

<body class="zaoshang">
<script>
    function sendEmail(state, userId, adminId, activeId) {
        $.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/admin/adminSendEmail',
            method: 'post',
            data: {
                'state': state,
                'userId': userId,
                'adminId': adminId,
                'activeId': activeId
            },
            //回调值，响应respones
            success: function (date) {
                alert('邮件发送成功');
            }
        })
    }
</script>
<div style="padding-top: 100px;text-align: center;">
    <table>
        <div style="text-align: center;">
            <h2>新冠疫情志愿服务系统</h2>
            <a href="${pageContext.request.contextPath}" onclick="testLogin()">查看管理员</a>
            <a href="${pageContext.request.contextPath}/news/findAll" onclick="testLogin()">公告管理</a>
            <a href="${pageContext.request.contextPath}/Active/showAllActive">活动管理</a>
            <a href="${pageContext.request.contextPath}">组织管理</a>
            <a href="${pageContext.request.contextPath}/admin/ActRequest">审核</a>
            <a href="${pageContext.request.contextPath}/admin/goSendEmail?key=${sessionScope.adminInfo.key}"
               onclick="testLogin()">发送邮件</a><br><br>
            <c:choose>
                <c:when test="${sessionScope.adminInfo.adminId>0}">
                    <font>欢迎<font
                            style="color: red;font-family: 仿宋;font-size: 20px;">-${sessionScope.adminInfo.adminLoginName}-</font></font>
                    <a href="${pageContext.request.contextPath}/admin/loginOut">退出</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">登录</a>
                    <a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">注册</a>
                </c:otherwise>
            </c:choose>
        </div>
        <div style="text-align: center;padding-top: 20px;">
            <a class="ziti" href="${pageContext.request.contextPath}/admin/ActRequest">全部</a>&nbsp;&nbsp;
            <a class="ziti" href="${pageContext.request.contextPath}/admin/findActRequestByState?activeJoinInState=申请中">申请中</a>&nbsp;&nbsp;
            <a class="ziti" href="${pageContext.request.contextPath}/admin/findActRequestByState?activeJoinInState=已通过">已通过</a>&nbsp;&nbsp;
            <a class="ziti" href="${pageContext.request.contextPath}/admin/findActRequestByState?activeJoinInState=已拒绝">已拒绝</a>&nbsp;&nbsp;<br><br>
            查询申请: <input type="text" style="width: 200px;">
            <button>搜索</button>
            <thead>
            <tr>
                <td>申请人</td>
                <td>照片</td>
                <td>证件号</td>
                <td>联系电话</td>
                <td>所属组织/职位</td>
                <td>志愿时长</td>
                <td>活动类型</td>
                <td>活动名称</td>
                <td>活动地址</td>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>操作</td>
            </tr>
            </thead>
            <c:forEach items="${activeJoinInInfoList}" var="nl">
                <tbody>
                <tr>
                    <td>${nl.userInfo.userName}</td>
                    <td><img src="${pageContext.request.contextPath}/img/${nl.userInfo.img}"
                             style="width: 50px;height:50px"></td>
                    <td>${nl.userInfo.userCardId}</td>
                    <td>${nl.userInfo.userTel}</td>
                    <td>${nl.userInfo.teamJobInfo.teamJobName}</td>
                    <td>${nl.userInfo.userHelpTime}h</td>
                    <td>${nl.activeTypeInfo.activeTypeName}</td>
                    <td>${nl.activeInfo.activeName}</td>
                    <td>${nl.activeInfo.activeAddress}</td>
                    <td>${nl.activeInfo.activeStartTime}</td>
                    <td>${nl.activeInfo.activeEndTime}</td>
                    <c:choose>
                        <c:when test="${nl.activeJoinInState=='已通过'}">
                            <td>
                                <a href="#" style="color: darkgreen" id="agree">已通过</a>
                                <a href="#" style="color: darkgreen"
                                   onclick="  sendEmail('已通过',${nl.userInfo.userId},${sessionScope.adminInfo.adminId},${nl.activeInfo.activeId})">发送邮件提醒</a>
                            </td>
                        </c:when>
                        <c:when test="${nl.activeJoinInState=='已拒绝'}">
                            <td>
                                <a href="#" style="color: red" id="refuse">已拒绝</a>
                                <a href="#" style="color:red" onclick="sendEmail()">发送邮件提醒</a>
                            </td>
                        </c:when>
                        <c:when test="${nl.activeJoinInState=='申请中'}">
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/ActRequestResult?activeJoinInId=${nl.activeJoinInId}&updateState=0"
                                   style="color: darkgreen">同意</a>
                                <a href="${pageContext.request.contextPath}/admin/ActRequestResult?activeJoinInId=${nl.activeJoinInId}&updateState=1"
                                   style="color: red">拒绝</a>
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
                <br>
                </tbody>
            </c:forEach>
        </div>
    </table>
</div>
</body>
</html>
