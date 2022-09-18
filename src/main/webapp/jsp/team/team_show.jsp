<%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2022/9/5
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>团队列表</title>
</head>
<style type="text/css">
    .zaoshang{
        background:linear-gradient(
                #1084f6 0%, #FFF 80%);
        height: 100%;
    }
    table{

        width: 800px;
        text-align: center;
        border-collapse: collapse;
        margin-left: 400px;
        padding-top: 200px;
    }
    table caption{

        font-size: 2em;

        font-weight: bold;

        margin: 1em 0;}
    th,td{
        border: 1px solid #999;

        text-align: center;

        padding: 10px 0;}
    table thead tr{

        background-color: #008c8c;

        color: #fff;}
    table tbody tr:nth-child(odd){

        background-color: #eee;}
    table tbody tr:hover{

        background-color: #ccc;}
    table tbody tr td:first-child{

        color: darkgray;}
    table tfoot tr td{

        text-align: right;

        padding-right: 20px;}
</style>
<body class="zaoshang">
<table>
    <div style="text-align: center;">
        <h2>新冠疫情志愿服务系统</h2>
        <a href="${pageContext.request.contextPath}/admin/goHome" onclick="testLogin()">首页</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/news/findAll" onclick="testLogin()">公告</a>&nbsp;&nbsp;
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
    <div style="text-align: center">
        <h3>团队组织列表</h3>
        <c:forEach items="${teamTypeInfoList}" var="ty">
            <a href="${pageContext.request.contextPath}/Team/findTeamType?teamTypeId=${ty.teamTypeId}">${ty.teamTypeName}</a>
        </c:forEach>
    </div>
    <div style="text-align: center; ">
        <a href="${pageContext.request.contextPath}/Team/showAdd">创建组织</a>
        <thead>
          <tr>
            <td>组织名称</td>
            <td style="width: 100px">当前人数</td>
              <td style="width: 100px">最大人数</td>
            <td style="width: 100px">操作</td>
          </tr><br>
        </thead>
        <c:forEach items="${teamInfoList}" var="tl">
           <tbody>
             <tr>
               <td>${tl.teamName}</td>
               <td style="width: 100px">${tl.teamPeopleNum}</td>
                 <td style="width: 100px">200</td>
                 <td style="width: 100px">
                   <a href="${pageContext.request.contextPath}">查看详情</a>
               </td>
             </tr><br>
           </tbody>
        </c:forEach>
    </div>
</table>

</body>
</html>
