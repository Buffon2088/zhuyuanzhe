<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/jsp/home_login/css/zhuce.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/home_login/js/zhuce.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/home_login/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	var height=$(document).height();
	$('.main').css('height',height);
})
</script>
</head>

<body>
<div class="main">
  <div class="main0">
     <div class="main_left">
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/zhuce-image-3.png" class="theimg"/>
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/zhuce-image-2.png" class="secimg"/>
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/zhuce-image-1.png" class="firimg"/>
     </div>
     <div class="main_right">
        <div class="main_r_up">
            <img src="${pageContext.request.contextPath}/jsp/home_login/images/user.png" />
            <div class="pp">注册</div>
        </div>
         <form action="${pageContext.request.contextPath}/publicAddPeo/addUserMessage" method="post">
         <div class="sub"><p>已经注册？<a href="${pageContext.request.contextPath}/jsp/home_login/login.jsp"><span class="blue">请登录</span></a></p></div>
         <div class="txt txt0">
            <span style="letter-spacing:8px;">用户名:</span>
            <input name="userLoginName" id="userLoginName" type="text" class="txtphone" placeholder="请输入用户名" onblur="nameRepeat()"/>
             <span id="userLoginNameSpan"></span>
         </div>
         <div class="txt txt0">
             <span style="letter-spacing:8px;">身份证:</span>
             <input name="userCardId" id="idCard" type="text" class="txtphone" placeholder="请输入身份证" onblur="idCardTest()" disabled/>
             <span id="idCardSpan"></span>
         </div>
        <div class="txt txt0">
            <span style="letter-spacing:4px;">登录密码:</span>
            <input name="userPwd" id="password" type="password" class="txtphone" placeholder="请输入密码" disabled/>
            <span id="passwordSpan"></span>
        </div>
        <div class="txt txt0">
            <span style="letter-spacing:4px;">重复密码:</span>
            <input name="" type="password" id="againPas" onmouseout="passwordSure()"class="txtphone" placeholder="请再次输入密码" disabled/>
        </div>

        <div class="txt txt0" style="margin-top:10px;" >
            <a href="${pageContext.request.contextPath}/jsp/home_login/login.jsp"><span style="color:#31acfb">返回上一步</span></a>
            <button class="xiayibu"  type="submit" id="button" style="margin-left: 30px;">下一步</button>
        </div>
         </form>
     </div>
  </div>
</div>

<div class="footer">
    <div class="footer0">
        <div class="footer_l">毕业设计 | 张自奇</div>
        <div class="footer_r">© 2022 （内蒙）集宁师范学院    更多信息：<a href="http://www.jntc.nm.cn/" target="_blank">集宁师范官方网站</a></div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script>
    var button=document.getElementById('button');
    var idCardInput=document.getElementById('idCard');
    var loginPwd=document.getElementById('password');
    var againPas=document.getElementById('againPas');
    var userLoginNameSpan=document.getElementById('userLoginNameSpan');
    var idCardSpan=document.getElementById('idCardSpan');
    var passwordSpan=document.getElementById('passwordSpan');
    button.disabled = true;
    function nameRepeat() {
        var userLoginName = document.getElementById('userLoginName').value;
        var userNameInput = document.getElementById('userLoginName');
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
                    userNameInput.style.border='2px solid red';
                    //清空输入框
                    userNameInput.outerHTML = userNameInput.outerHTML;
                    idCard.disabled=true;
                    loginPwd.disabled=true;
                    againPas.disabled=true;
                    userLoginNameSpan.innerHTML='用户名已被占用';
                    userLoginNameSpan.style.color='red';
                } else if (userLoginName.length<1){
                    userNameInput.style.border='2px solid red';
                    //清空输入框
                    userNameInput.outerHTML = userNameInput.outerHTML;
                    idCard.disabled=true;
                    loginPwd.disabled=true;
                    againPas.disabled=true;
                    userLoginNameSpan.innerHTML='用户名不能为空';
                    userLoginNameSpan.style.color='red';
                }else {
                    userNameInput.style.border='2px solid limegreen';
                    idCard.disabled=false;
                    loginPwd.disabled=false;
                    againPas.disabled=false;
                    userLoginNameSpan.innerHTML='用户名可使用';
                    userLoginNameSpan.style.color='limegreen';
                }
            }
        });
    }

    function idCardTest() {
        //身份证正则
        var idCardGz = /^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X)?/;
        var idCard = document.getElementById('idCard').value;
        var idCardInput = document.getElementById('idCard');
        if (idCardGz.test(idCard)) {
            idCardInput.style.border='2px solid limegreen';
            loginPwd.disabled=false;
            againPas.disabled=false;
            idCardSpan.innerHTML='身份证符合规范';
            idCardSpan.style.color='limegreen';
        } else {
            idCardInput.style.border='2px solid red';
            loginPwd.disabled=true;
            againPas.disabled=true;
            idCardSpan.innerHTML='不符合规范';
            idCardSpan.style.color='red';
            idCardInput.outerHTML = idCardInput.outerHTML;
        }
    }
</script>
<script>
    function passwordSure() {
        var loginPwd=document.getElementById('password');
        var password = document.getElementById('password').value;
        var againPas = document.getElementById('againPas').value;
        if (password == againPas && password.length>0) {
            loginPwd.style.border='2px solid limegreen';
            passwordSpan.innerText='密码验证成功';
            passwordSpan.style.color='limegreen';
            button.disabled = false;
            //到时候里面添加密码规则校验
        } else if (password.length>0) {
            loginPwd.style.border='2px solid red';
            passwordSpan.innerText='两次密码不一致';
            passwordSpan.style.color='red';
            document.getElementById('againPas').outerHTML = document.getElementById('againPas').outerHTML;
        }else {
            loginPwd.style.border='2px solid red';
            passwordSpan.innerText='密码不能为空';
            passwordSpan.style.color='red';
            document.getElementById('againPas').outerHTML = document.getElementById('againPas').outerHTML;
        }
    }
</script>
</body>
</html>
