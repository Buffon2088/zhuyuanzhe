<%--
  Created by IntelliJ IDEA.
  User: 冯浩宇
  Date: 2022/8/18
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <style type="text/css">
        .zaoshang{
            background:linear-gradient(
                    #1084f6 0%, #FFF 80%);
            height: 100%;
        }
    </style>
    <title>adminLogin</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body class="zaoshang">
<div style="text-align: center;padding-top: 300px;">
    <form action="${pageContext.request.contextPath}/User/userLogin" method="post">
        <h2>用户登录</h2>
        <h5><a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">管理员登录</a></h5>
        账号：<input type="text" name="userLoginName" id="loginK"><span id="tip"></span><br><br>
        密码：<input type="password" name="userPwd" id="passK"><br><br>
        <input value="login" type="submit">
        <a href="">找回密码</a>
    </form>

    <form action="${pageContext.request.contextPath}/User/oldUserLogin" method="post">
        <h2>用户登录（测试）</h2>
        <h5><a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp">管理员登录</a></h5>
        账号：<input type="text" name="userLoginName" ><span></span><br><br>
        密码：<input type="password" name="userPwd" i><br><br>
        <input value="login" type="submit">
        <a href="">找回密码</a>
    </form>
</div>
<div>
    <table id="errTable">
        <thead>
        <tr>
            <th>排名</th>
            <th>等级</th>
            <th>标志</th>
        </tr>
        </thead>
        <tbody id="tbodyId">
        <td>1</td>
        <td>2</td>
        <td>3</td>
        </tbody>
    </table>
    <button onclick="addTableRows()">添加</button>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script>
    //增加table行
    function addTableRows(){
        var tables = $("#tbodyId");
        var td = $("<tr>" +
            "<td>4</td>" +
            "<td>5</td>" +
            "<td>6</td>" +
            "</tr>");
        td.appendTo(tables);
    }
</script>
<script>
    setInterval(time,1000) //定时器
    function time(){ //定义方法 time
        let time = new Date();  //实例化日期对象

        let year=time.getFullYear()+"年" //获取年

        let month=time.getMonth()+1+"月" //获取月

        let day=time.getDate()+"日"      //获取日

        let h=time.getHours()+':'        //获取时

        let m=time.getMinutes()+":"      //获取分

        let s=time.getSeconds()          //获取秒

        if(s<10){                        //判定秒 是否小于10秒

            s="0"+time.getSeconds()      //小于是 在其前加0 01，02，03...

        }

        if(time.getMinutes()<10){        //判定分 是否小于10分

            m="0"+time.getMinutes()+":"  //小于是 在其前加0 01，02，03...

        }
        id.innerHTML='当前时间：'+year+month+day+h+m+s  //显示当前时间
    }
</script>
<script>
        var selectStyle=document.getElementById('activeTypePage');
        $.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/User/reasonEmail',
            method: 'post',
            data: {
                'chooseType': '01'
            },
            //回调值，响应respones
            success: function (date) {
                var obj = JSON.parse(date);
                var jsonLength=getJsonLength(obj);
                var optionTags = '';
                for (var i=0;i<jsonLength;i++){
                    var activeType=obj[i];
                    var optionChoose='<option value="'+obj[i]+'">'+obj[i]+'</option>';
                    optionTags=optionTags+optionChoose;
                }
                // 将下拉框中除了第一个选项，全部移除
                $('#activeTypePage option:gt(0)').remove();
                // 为下拉框拼接子标签
                $('#activeTypePage').append(optionTags);
            }
        });
        //获取json的长度
        function getJsonLength(jsonData) {
            var length=0;
            for(var ever in jsonData) {
                length++;
            }
            return length;
        }

</script>
<%--根据活动类型查询活动--%>
<script>
    function activeByType(activeType){
        alert('111');
        alert(activeType);
    }
</script>

<%--<script>
var tip=document.getElementById('tip');
var loginK=document.getElementById('loginK');
var loginName=$('#logink').val();
loginK.onblur=function (){
    alert(loginName);
    if (loginName==''){
        alert('用户名不可为空!');
    }else{
        alert(loginName);
        alert('有密码')
    }
}
</script>--%>
</body>
</html>
