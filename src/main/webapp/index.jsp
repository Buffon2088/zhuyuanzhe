<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<body>
<h2>Hello World!</h2>
<a href="jsp/adminHome/admin_login.jsp">登录</a>
<a href="${pageContext.request.contextPath}/admin/showAdd">添加</a>
<a href="${pageContext.request.contextPath}/admin/findAll">查看</a>
<a href="email/send_email.jsp">增库发送邮件</a>
</body>
</html>
