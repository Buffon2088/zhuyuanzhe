<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>AddAdmin</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        $(document).ready(function () {
            $("#adminFond").submit(function () {
                var adminCarId=$('#adminCarId').val();
                var adminTel=$('#adminTel').val();
                var adminLoginName=$('#adminLoginName').val();
                var adminPwd=$('#adminPwd').val();
                var adminState=$('#adminState').val();
                var cardFont=$('#CardFont');
                var telFont=$('#TelFont');
                var nameFont=$('#NameFont');
                var pwdFont=$('#PwdFont');
                var stateFont=$('#StateFont');
                if(adminCarId==null || adminCarId==""){
                    cardFont.html("证件号码不能为空！");
                    cardFont.prop("color","red");
                    return false;
                }else if(adminTel==null || adminTel==""){
                    cardFont.html("");
                    telFont.html("电话号码不能为空！");
                    telFont.prop("color","red");
                    return false;
                }else if(adminLoginName==null || adminLoginName==""){
                    telFont.html("");
                    nameFont.html("用户名称不能为空！");
                    nameFont.prop("color","red");
                    return false;
                }else if(adminPwd==null || adminPwd==""){
                    nameFont.html("");
                    pwdFont.html("登陆密码不能为空！");
                    pwdFont.prop("color","red");
                    return false;
                }else if(adminState==null || adminState==""){
                    pwdFont.html("");
                    stateFont.html("用户状态不能为空！");
                    stateFont.prop("color","red");
                    return false;
                }else{
                    cardFont.html("");
                    telFont.html("");
                    nameFont.html("");
                    pwdFont.html("");
                    stateFont.html("");
                    return true;
                }

            })
        });

    </script>
</head>
<body>
<form id="adminFond" action="${pageContext.request.contextPath}/admin/addAdmin" method="post">
    用户身份证：<input type="text" name="adminCarID" id="adminCarId"><font id="CardFont"></font><br>
    用户电话：<input type="text" name="adminTel" id="adminTel"><font id="TelFont"></font><br>
    用户名：<input type="text" name="adminLoginName" id="adminLoginName"><font id="NameFont"></font><br>
    用户密码：<input type="password" name="adminPwd" id="adminPwd"><font id="PwdFont"></font><br>
    用户状态：<input type="text" name="adminState" id="adminState"><font id="StateFont"></font><br>
    <input type="submit" value="add">
</form>


</body>
</html>
