<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>adminUpdate</title>
    <style type="text/css">
        .zaoshang{
            background:linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">
<%--<script >
    function getObjectURL(file) {
        var url = null;
        if (window.createObjcectURL != undefined) {
            url = window.createOjcectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
</script>--%>
<script>
    function sendEmail() {
        alert('开始发送');
        var consignee = document.getElementById("consignee").value;
        var addressOr = document.getElementById("addressOr").value;
        var otherInformation = document.getElementById("otherInformation").value;
        var information = document.getElementById("information").value;
        var imgInformationUrl = document.getElementById('imgInformation').value;
        var txtInformation = document.getElementById("txtInformation").value;
        $.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/admin/sendEmail',
            method: 'post',
            data: {
                'consignee': consignee,
                'addressOr': addressOr,
                'otherInformation': otherInformation,
                'information': information,
                'imgInformation': imgInformationUrl,
                'txtInformation': txtInformation
            },
            //回调值，响应respones
            success: function (date) {
                alert('发送成功');
                window.location = '../admin_login.jsp';
            },
            error: function (data) {
                alert('发送失败');
            }
        });
    }
</script>
<div style="text-align: center;padding-top: 230px;">
    <input type="hidden" name="adminId" value=""><br>
    <h2>-Email-</h2>
    发件:<input type="text" id="consignee"><br>
    收件:<input type="text" id="addressOr"><br>
    标题:<input type="text" id="otherInformation"><br>
    内容:<input type="text" id="information"><br><br>
    <font style="margin-left: 80px;">图片:<input type="file" id="imgInformation"></font><br>
    <font style="margin-left: 80px;">附件:<input type="file" id="txtInformation"></font><br><br>
    <button onclick="sendEmail()">发送</button>
    <button onclick="window.location = '../admin_login.jsp';">返回</button>
</div>

</body>
</html>
