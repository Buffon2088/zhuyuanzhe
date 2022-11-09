<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/jsp/home_login/css/login.css" />
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
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/login-image-3.png" class="theimg"/>
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/login-image-2.png" class="secimg"/>
        <img src="${pageContext.request.contextPath}/jsp/home_login/images/login-image-1.png" class="firimg"/>
     </div>
     <div class="main_right">
        <div class="main_r_up">
            <img src="${pageContext.request.contextPath}/jsp/home_login/images/user.png" />
            <div class="pp">登录</div>
        </div>
        <div class="sub"><p>还没有账号？<a href="${pageContext.request.contextPath}/jsp/home_login/zhuce1.jsp"><span class="blue">立即注册</span></a></p></div>
         <form action="${pageContext.request.contextPath}/User/userLogin" method="post">
         <div class="txt">
            <span style="letter-spacing:8px;">用户名:</span>
            <input name="userLoginName" id="userLoginName" type="text" class="txtphone" placeholder="请输入注册手机号或用户名" onchange="loginCheck()"/>
             <span id="userLoginNameSpan"></span>
         </div>
        <div class="txt">
            <span style="letter-spacing:4px;">登录密码:</span>
            <input name="userPwd" id="userPwd" type="password" class="txtphone" placeholder="请输入登录密码" onchange="pwdCheck()"/>
            <span id="userPwdSpan"></span>
        </div>
        <div class="txt">
            <span style=" float:left;letter-spacing:8px;">验证码:</span>
            <input name="" type="text" id="testInput" class="txtyzm" placeholder="请输入页面验证码" onchange="sureResult(sessionStorage.getItem('formula'))"/>&nbsp;&nbsp;
            <button type="button" id="buttonCheckCode" style="margin-top:5px;height: 35px;width: 100px;text-align: center" onclick="getCode()">点击获取验证</button>

        </div>
        <div class="xieyi">
            <input name="" type="checkbox" value="" checked="checked"/>
            记住我 <a href="password.html"><span class="blue" style=" padding-left:130px; cursor:pointer">忘记密码?</span></a>
        </div>
        <input class="xiayibu" type="submit" id="loginButton" value="登录">
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
    var loginButton=document.getElementById('loginButton');
    loginButton.disabled=true;
    document.getElementById('userPwd').disabled=true;
    document.getElementById('testInput').disabled=true;
     function loginCheck(){
         var loginButton=document.getElementById('loginButton');
         var loginName=document.getElementById('userLoginName').value;
         var loginNameInput=document.getElementById('userLoginName');
         var userLoginNameSpan=document.getElementById('userLoginNameSpan');
         var pwdInput=document.getElementById('userPwd');
         if (loginName.length == 0){
             loginNameInput.style.border='2px solid red';
             userLoginNameSpan.innerHTML='用户名不为空';
             userLoginNameSpan.style.color='red';
             loginNameInput.outerHTML = loginNameInput.outerHTML;
             loginButton.disabled=true;
         }else {
             userLoginNameSpan.innerHTML='';
             loginNameInput.style.border='2px solid limegreen';
             pwdInput.disabled=false;
             userLoginNameSpan.style.color='limegreen';
         }
     }

     function pwdCheck(){
         var loginButton=document.getElementById('loginButton');
         var pwd=document.getElementById('userPwd').value;
         var pwdInput=document.getElementById('userPwd');
         var userPwdSpan=document.getElementById('userPwdSpan');
         if (pwd.length===0){
             pwdInput.style.border='2px solid red';
             userPwdSpan.innerHTML='密码不为空';
             userPwdSpan.style.color='red';
             document.getElementById('testInput').disabled=true;
             pwdInput.outerHTML = pwdInput.outerHTML;
             loginButton.disabled=true;
         }else {
             pwdInput.style.border='2px solid limegreen';
             userPwdSpan.innerHTML='';
             userPwdSpan.style.color='limegreen';
             document.getElementById('testInput').disabled=false;
         }
     }
</script>
<script>
    function getCode(){
        sessionStorage.removeItem('formula');
        //验证码
        var oneNumber;
        var twoNumber;
        var threeNumber;
        var threeFour;
        var threeFive;
        var sign=['+','-','*','+','-','*','+','-','*','+','-','*'];
        var finalNum;
        for (var i=1;i<=10;i++){
            oneNumber=Math.floor(Math.random()*10);
            twoNumber=Math.floor(Math.random()*10);
            threeNumber=Math.floor(Math.random()*10);
            threeFour=Math.floor(Math.random()*10);
            threeFive=Math.floor(Math.random()*10);
        }
        if (threeNumber<5){
            finalNum=oneNumber+sign[oneNumber]+twoNumber+sign[twoNumber]+threeNumber+sign[threeNumber]+threeFive;
        }else if (threeFive>5){
            finalNum=threeFive+sign[threeFive]+threeFour+sign[threeFour]+threeNumber+sign[threeNumber]+oneNumber;
        }else {
            finalNum=twoNumber+sign[twoNumber]+threeNumber+sign[threeNumber]+threeFour+sign[threeFour]+threeNumber;
        }
        buttonCheckCode.innerText=finalNum;
        sessionStorage.setItem('formula',finalNum);
    }

    var buttonCheckCode=document.getElementById('buttonCheckCode');

    function sureResult(value){
        var testInput=document.getElementById('testInput');
        var testInputValue=document.getElementById('testInput').value;
        $.ajax({
            url: '${pageContext.request.contextPath}/User/sumJs',
            method: 'post',
            data: {
                'value': value
            },
            //回调值，响应respones
            success: function (date) {
                var obj = JSON.parse(date);
                var arr = obj['res'];
                if (arr=='N'){
                    loginButton.disabled=true;
                    buttonCheckCode.innerText='系统计算异常';
                    testInput.style.border='2px solid red';
                }else if (testInputValue == arr){
                    loginButton.disabled=false;
                    testInput.style.border='2px solid limegreen';
                }else {
                    loginButton.disabled=true;
                    buttonCheckCode.innerText='验证码错误';
                    testInput.style.border='2px solid red';
                }
            }
        });
    }

</script>
</body>
</html>
