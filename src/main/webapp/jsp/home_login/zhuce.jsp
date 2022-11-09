<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/jsp/home_login/css/zhuce.css" />
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
              <div class="pp">头像</div>
          </div>
          <form action="${pageContext.request.contextPath}/publicAddPeo/addUser?userLoginName=${userInfo.userLoginName}&userCardId=${userInfo.userCardId}&userPwd=${userInfo.userPwd}" method="post" enctype="multipart/form-data">
              <input type="file" id="file" name="file" onchange="handCheck(this.value)"/> &nbsp;&nbsp;<span id="fileSpan" style="color: red;">请上传头像</span>
          <div class="sub"><p>已经注册？<a href="${pageContext.request.contextPath}/jsp/home_login/login.jsp"><span class="blue">请登录</span></a></p></div>
          <div class="txt txt0">
              <span style="letter-spacing:7px;">邮箱号:</span>
              <input  name="userEmail" id="email" type="text" class="txtphone" placeholder="请输入邮箱号" onblur="emailCheck(this.value)" disabled/>
              <span id="emailSpan"></span>
          </div>
          <div class="txt txt0">
              <span style="letter-spacing:7px;">授权码:</span>
              <input name="key" id="code" type="text" class="txtphone" placeholder="请输入授权码" onblur="codeCheck(this.value)" disabled/>
              <span id="codeSpan"></span>
          </div>
          <div class="txt txt0">
              <span style="letter-spacing:3px;">真实姓名:</span>
              <input name="userName" type="text" class="txtphone" placeholder="请输入真实姓名" id="trueName" onblur="trueNameCheck(this.value)" disabled/>
              <span id="trueNameSpan"></span>
          </div>
          <div class="txt txt0">
              <span style="float:left">验证码:</span>
              <input name="" id="testCode" type="text" placeholder="请输入邮箱验证码" class="txtyzmdx" onmouseout="checkCode(this.value)" disabled/>&nbsp;&nbsp;
              <button type="button" id="testCodeSpan" onclick="getTestCode()" style="text-align: center; margin-top: 8px;height: 33px;width: 85px;">获取验证码</button>
          </div>
          <div class="txt txt0">
              <a href="${pageContext.request.contextPath}/jsp/home_login/zhuce1.jsp"><span style=" float:left;color:#31acfb">返回上一步</span></a>
              <button type="submit"  id="button"  class="zhucebtn">注册</button>
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
    button.disabled = true;
    var file=document.getElementById('file').value;
    var fileSpan=document.getElementById('fileSpan');
    var emailInput=document.getElementById('email');
    var email=document.getElementById('email').value;
    var emailSpan=document.getElementById('emailSpan');
    var code=document.getElementById('code').value;
    var codeInput=document.getElementById('code');
    var codeSpan=document.getElementById('codeSpan');
    var trueName = document.getElementById('trueName').value;
    var trueNameInput = document.getElementById('trueName');
    var trueNameSpan = document.getElementById('trueNameSpan');
    var testCode=document.getElementById('testCode').value;
    var testCodeInput=document.getElementById('testCode');
    var testCodeSpan=document.getElementById('testCodeSpan');
    var codeMessageSpan=document.getElementById('codeMessage');
    document.getElementById('testCodeSpan').disabled=true;
    //头像验证
    function handCheck(value){
        if (value.length>0){
            emailInput.disabled=false;
            fileSpan.innerText='正常';
            fileSpan.style.color='limegreen';
            button.disabled = true;
        }else{
            fileSpan.innerText='头像不可为空';
            fileSpan.style.color='red';
        }
    }
    //邮箱验证
    function emailCheck(value){
        if (value.length>0){
            emailSpan.innerText='正常';
            emailSpan.style.color='limegreen';
            emailInput.style.border='2px solid limegreen';
            codeInput.disabled=false;
        }else {
            emailSpan.innerText='邮箱不可为空';
            emailSpan.style.color='red';
            emailInput.style.border='2px solid red';
            button.disabled = true;
        }
    }
    //授权码验证
    function codeCheck(value){
       if (value.length>8){
           codeSpan.innerText='正常';
           codeSpan.style.color='limegreen';
           codeInput.style.border='2px solid limegreen';
           trueNameInput.disabled=false;
           document.getElementById('testCodeSpan').disabled=false;
       }else {
           codeSpan.innerText='位数应大于8';
           codeSpan.style.color='red';
           codeInput.style.border='2px solid red';
           button.disabled = true;
       }
    }
    //真实姓名验证
    function trueNameCheck(value) {
        var rg = /[\u4e00-\u9fa5]/;
        //全部为中文正则
        if (rg.test(value)) {
            if (value.length >= 6 || value.length < 2) {
                trueNameSpan.innerText='姓名不规范';
                trueNameSpan.style.color='red';
                trueNameInput.style.border='2px solid red';
                userNameInput.outerHTML = userNameInput.outerHTML;
                button.disabled = true;
            } else {
                trueNameSpan.innerText='正常';
                trueNameSpan.style.color='limegreen';
                trueNameInput.style.border='2px solid limegreen';
            }
        } else {
            trueNameSpan.innerText='只能为中文';
            trueNameSpan.style.color='red';
            trueNameInput.style.border='2px solid red';
            userNameInput.outerHTML = userNameInput.outerHTML;
            button.disabled = true;
        }

    }
</script>
<script>
    //验证码校验
    function getTestCode(){
        var testCodeSpan=document.getElementById('testCodeSpan');
        var addressOr=document.getElementById('email').value;
        testCodeSpan.disabled=true;
        testCodeInput.disabled=false;

        $.ajax({
            url: '${pageContext.request.contextPath}/User/sendEmailCheckCode',
            method: 'post',
            data: {
                'addressOr': addressOr
            },
            //回调值，响应respones
            success: function (date) {
                var result=JSON.parse(date);
                var obj=result['res'];
                if (result['res']=='N'){
                    testCodeSpan.innerText='发送异常！';
                }else {
                    sessionStorage.removeItem('result');
                    sessionStorage.setItem('result',obj);
                     //调用计时方法
                    checkCodeTime(60);

                }
            }
        });
    }
    var nowTime=60;
    //倒计时方法
    function checkCodeTime(codeTime){
        //发送时间处理
        var forTime=setInterval(countdown,1000);
        function countdown(){
            let finalTime=nowTime-1;
            nowTime=finalTime;
            testCodeSpan.innerText=nowTime+'重新发送';
            if (nowTime==0){
                testCodeSpan.innerText='重新发送';
                clearInterval(forTime);
                testCodeSpan.disabled=false;
            }
        }
    }
    //检验验证码
    function checkCode(value){
        var testCodeInput=document.getElementById('testCode');
        var userCode=sessionStorage.getItem('result');
        if (value==userCode){
            testCodeInput.style.border='2px solid limegreen';
           /* codeMessageSpan.innerText='正确';
            codeMessageSpan.style.color='limegreen';*/
            button.disabled = false;
        }else {
            testCodeInput.style.border='2px solid red';
            /*codeMessageSpan.innerText='验证码错误,重新输入';
            codeMessageSpan.style.color='red';*/
            testCodeInput.outerHTML = testCodeInput.outerHTML;
            button.disabled = true;
        }
    }
</script>
</body>
</html>
