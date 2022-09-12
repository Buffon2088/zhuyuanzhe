<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        .zaoshang {
            background: linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }
    </style>
    <title>adminLogin</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">

<script>
    function passwordSure() {
        var password = document.getElementById('password').value;
        var againPas = document.getElementById('againPas').value;
        if (password == againPas) {
            document.getElementById('button').disabled = false;
            //到时候里面添加密码规则校验
        } else {
            alert('两次密码不一致');
            document.getElementById('button').disabled = true;
        }
    }
</script>
<script>
    function nameRepeat() {
        var userLoginName = document.getElementById('userLoginName').value;
        $.ajax({
            url: '${pageContext.request.contextPath}/publicAddPeo/isRepeatName',
            method: 'post',
            data: {
                'userLoginName': userLoginName
            },
            //回调值，响应respones
            success: function (date) {
                var obj = JSON.parse(date);
                var arr = obj['res'];
                if (arr == 1) {
                    alert('用户名已被占用');
                    document.getElementById('button').disabled = true;
                } else {
                    document.getElementById('button').disabled = false;
                }
            }
        });
    }
</script>
<script>
    function trueNameTest() {
        var rg = /[\u4e00-\u9fa5]/;
        var trueName = document.getElementById('trueName').value;
        //全部为中文正则
        if (rg.test(trueName)) {
            if (trueName.length >= 6 || trueName.length < 2) {
                alert('姓名不规范,真实姓名不能小于2或者不能超过6');
                document.getElementById('button').disabled = true;
            } else {
                document.getElementById('button').disabled = false;
            }
        } else {
            alert('真实姓名只能为中文');
            document.getElementById('button').disabled = true;
        }

    }

    function idCardTest() {
        //身份证正则
        var idCardGz = /^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X)?/;
        var idCard = document.getElementById('idCard').value;
        if (idCardGz.test(idCard)) {
            document.getElementById('button').disabled = false;
        } else {
            alert('身份证不符合规范');
            document.getElementById('button').disabled = true;
        }
    }
</script>
<div style="text-align: center;padding-top: 100px;">
    <a href="${pageContext.request.contextPath}">返回主界面</a>
    <c:choose>
        <c:when test="${state=='update'}">
            <form action="${pageContext.request.contextPath}/activeType/updateActiveType?activeTypeId=${activeTypeInfo.activeTypeId}" method="post"
                  enctype="multipart/form-data">
                <h2>活动类型修改</h2>
                类型名称：<input type="text" name="activeTypeName" value="${activeTypeInfo.activeTypeName}"><br><br>
                当前状态：<select name="activeTypeState" style="width: 150px;height: 33px;">
                <option value="已发布">上线</option>
                <option value="发布">待发布</option>
                <option value="维护中">维护中</option>
            </select><br><br>
                <input value="修改" type="submit" style="width: 100px;">
                <input value="重填" type="reset"  style="width: 100px;">
            </form>
        </c:when>
        <c:otherwise>
            <form action="${pageContext.request.contextPath}/activeType/addActiveType" method="post"
                  enctype="multipart/form-data">
                <h2>活动类型添加</h2>
                类型名称：<input type="text" name="activeTypeName"><br><br>
                当前状态：<select name="activeTypeState" style="width: 150px;height: 33px;">
                <option value="已发布">上线</option>
                <option value="发布">待发布</option>
                <option value="维护中">维护中</option>
            </select><br><br>
                <input value="添加" type="submit" id="button" style="width: 100px;">
                <input value="重填" type="reset"  style="width: 100px;">
            </form>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
