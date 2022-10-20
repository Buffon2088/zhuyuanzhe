<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="">
    <div class="container position-relative p-0 mt-90" style="max-width: 700px;">
        <h3 class="bg-theme-colored1 p-15 mb-0 text-white">发送邮件</h3>
        <div class="section-content bg-white p-30">
            <div class="row">
                <div class="col-md-12">
                    <!-- Reservation Form Start-->
                        <h3 class="mt-0">立刻发送邮件<span class="text-theme-colored1 font-weight-600"> Now!</span></h3>
                        <p class="">请填写邮件详细信息</p>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group mb-30">
                                    <input placeholder="邮件主题" type="text" name="form_phone"
                                           class="form-control required" disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <select class="form-control required" id="otherInformation">
                                    <option value=""> --- 选择原因 ---</option>
                                    <option value="活动申请" id="reqAct">活动申请</option>
                                    <option value="组织申请" id="reaTeam">组织申请</option>
                                    <option value="活动打卡" id="callCard">活动打卡</option>
                                    <option value="申请补卡" id="reqCard">申请补卡</option>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group mb-30">
                                    <input placeholder="${sessionScope.userInfo.userName}-${sessionScope.userInfo.userEmail}"
                                           type="text" name="form_name" class="form-control required" id="consignee" value="${sessionScope.userInfo.userEmail}"
                                           disabled>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <select name="收件人" class="form-control required" id="chooseAddressOr"
                                        onchange="findEmailByName(this.value)">
                                    <option value=""> --- 选择收件人 ---</option>
                                    <option value="Service 1">正在加载。。。</option>
                                    <option value="Service 2">正在加载。。。</option>
                                </select>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group mb-30">
                                    <select name="form_service" class="form-control required" id="activeTypePage"
                                            onchange="activeByType(this.value)">
                                        <option value="" id="chooseActType"> --- 选择活动类型 ---</option>
                                        <option value="Service 1">请按顺序选择！</option>
                                        <option value="Service 2">请按顺序选择！</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <select name="form_service" class="form-control required" id="active">
                                    <option value=""> --- 选择活动 ---</option>
                                    <option value="Service 1">请按顺序选择！</option>
                                    <option value="Service 2">请按顺序选择！</option>
                                </select>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group mb-30">
                                    <input name="form_date" class="form-control required date-picker" type="text"
                                           placeholder="日期">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group mb-30">
                                    <input name="form_time" class="form-control required time-picker" type="text"
                                           placeholder="时间">
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <textarea name="form_message" class="form-control required" rows="5"
                                              placeholder="邮件信息" id="information">
-新冠志愿活动系统
**您好：



                                                                                                                               ${sessionScope.userInfo.userName}祝您生活愉快~
                                    </textarea>
                                </div>
                            </div>
                            <div class="col-sm-12">
                                <div class="form-group mb-0 mt-0">
                                    <input name="form_botcheck" class="form-control" type="hidden" value="">
                                    <button type="submit" class="btn btn-theme-colored1 btn-round" data-loading-text="Please wait..."
                                             onclick="sendEmail()" id="sendAn">立刻发送</button>

                                </div>
                            </div>
                        </div>
                    <!-- Reservation Form End-->

                    <!-- Reservation Form Validation Start-->

                    <!-- Reservation Form Validation Start -->
                </div>
            </div>
        </div>
        <button title="Close (Esc)" type="button" class="mfp-close mt-10">×</button>
    </div>
</section>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

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
                window.location = '../jsp/adminHome/adminIndex.jsp';
            },
            error: function (data) {
                alert('发送失败');
            }
        });
    }
</script>
<script>
    function typeEmail() {
        var reaTeam = document.getElementById("reaTeam").value;
        $.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/User/reasonEmail',
            method: 'post',
            data: {
                'reaTeam': reaTeam
            },
            //回调值，响应respones
            success: function (date) {
                alert('发送成功');
                window.location = '../jsp/adminHome/adminIndex.jsp';
            }
        });
    }
</script>
<%--查詢人員--%>
<script>
    $.ajax({
        //提交的服务地址，servlet服务器
        url: '${pageContext.request.contextPath}/User/reasonEmail',
        method: 'post',
        data: {
            'chooseType': '00'
        },
        //回调值，响应respones
        success: function (date) {
            var obj = JSON.parse(date);
            var jsonLength = getJsonLength(obj);
            var optionTags = '';
            for (var i = 0; i < jsonLength; i++) {
                var optionChoose = '<option value="' + obj[i] + '">' + obj[i] + '</option>';
                optionTags = optionTags + optionChoose;
            }
            // 将下拉框中除了第一个选项，全部移除
            $('#chooseAddressOr option:gt(0)').remove();
            // 为下拉框拼接子标签
            $('#chooseAddressOr').append(optionTags);
            activeTypePage();
        }
    });

    //获取json的长度
    function getJsonLength(jsonData) {
        var length = 0;
        for (var ever in jsonData) {
            length++;
        }
        return length;
    }
</script>
<%--类型查询--%>
<script>
    function activeTypePage() {
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
                var jsonLength = getJsonLength(obj);
                var optionTags = '';
                for (var i = 0; i < jsonLength; i++) {
                    var optionChoose = '<option value="' + obj[i] + '">' + obj[i] + '</option>';
                    optionTags = optionTags + optionChoose;
                }
                // 将下拉框中除了第一个选项，全部移除
                $('#activeTypePage option:gt(0)').remove();
                // 为下拉框拼接子标签
                $('#activeTypePage').append(optionTags);
            }
        });
    }
</script>
<%--根据活动类型查询活动--%>
<script>
    function activeByType(activeType) {
        $.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/User/reasonEmail',
            method: 'post',
            data: {
                'chooseType': '02',
                'activeType': activeType
            },
            //回调值，响应respones
            success: function (date) {
                var obj = JSON.parse(date);
                var jsonLength = getJsonLength(obj);
                var optionTags = '';
                for (var i = 0; i < jsonLength; i++) {
                    var optionChoose = '<option value="' + obj[i] + '">' + obj[i] + '</option>';
                    optionTags = optionTags + optionChoose;
                }
                // 将下拉框中除了第一个选项，全部移除
                $('#active option:gt(0)').remove();
                // 为下拉框拼接子标签
                $('#active').append(optionTags);
            }
        });
    }
</script>
<!-- Footer Scripts -->
<script>
    //reload date and time picker
    THEMEMASCOT.initialize.TM_datePicker();
</script>

<%--通过姓名查询邮箱号--%>
<script>
    function findEmailByName(peopleName){
        var userName="${sessionScope.userInfo.userName}";
        var textName=document.getElementById('information');
            textName.innerHTML='-新冠志愿活动系统  \r\n'+peopleName+'您好： \r\n \r\n \r\n \r\n -'+userName+'-祝您生活愉快~';
    }
</script>
<%--邮件发送方法--%>
<script>

    function sendEmail() {
        var consignee = document.getElementById("consignee").value;
        var addressOr = document.getElementById('chooseAddressOr').value;
        var information = document.getElementById("information").value;
        var otherInformation = document.getElementById("otherInformation").value;
        var sendAn=document.getElementById('sendAn');
        sendAn.innerText='发送中...';
        setTimeout($.ajax({
            //提交的服务地址，servlet服务器
            url: '${pageContext.request.contextPath}/admin/sendEmail',
            method: 'post',
            data: {
                'consignee': consignee,
                'addressOr': addressOr,
                'otherInformation': otherInformation,
                'information': information,
                'imgInformation': '',
                'txtInformation': ''
            },
            //回调值，响应respones
            success: function (date) {
                alert('发送成功');
                sendAn.innerText='发送成功';
                sendAn.disabled=true;
            },
            error: function (data) {
                alert('发送失败');
                sendAn.innerText='发送失败';
                sendAn.disabled=true;
            }
        }),3000)
    }
</script>