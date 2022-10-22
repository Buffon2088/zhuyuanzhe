<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <!-- Meta Tags -->
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="SoolHart"/>
    <meta name="keywords" content=" charity, nonprofit, church, crowdfunding, donate"/>
    <meta name="author" content="ThemeMascot"/>

    <!-- Page Title -->
    <title>新冠志愿-个人活动</title>

    <!-- Favicon and Touch Icons -->
    <link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" type="image/png">
    <link href="${pageContext.request.contextPath}/images/apple-touch-icon.png" rel="apple-touch-icon">
    <link href="${pageContext.request.contextPath}/images/apple-touch-icon-72x72.png" rel="apple-touch-icon"
          sizes="72x72">
    <link href="${pageContext.request.contextPath}/images/apple-touch-icon-114x114.png" rel="apple-touch-icon"
          sizes="114x114">
    <link href="${pageContext.request.contextPath}/images/apple-touch-icon-144x144.png" rel="apple-touch-icon"
          sizes="144x144">

    <!-- Stylesheet -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/javascript-plugins-bundle.css" rel="stylesheet"/>

    <!-- CSS | menuzord megamenu skins -->
    <link href="${pageContext.request.contextPath}/js/menuzord/css/menuzord.css" rel="stylesheet"/>

    <!-- CSS | timeline -->
    <link href="${pageContext.request.contextPath}/js/timeline-cp-responsive-vertical/timeline-cp-responsive-vertical.css"
          rel="stylesheet" type="text/css">

    <!-- CSS | Main style file -->
    <link href="${pageContext.request.contextPath}/css/style-main.css" rel="stylesheet" type="text/css">
    <link id="menuzord-menu-skins"
          href="${pageContext.request.contextPath}/css/menuzord-skins/menuzord-rounded-boxed.css" rel="stylesheet"/>

    <!-- CSS | Responsive media queries -->
    <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet" type="text/css">
    <!-- CSS | Style css. This is the file where you can place your own custom css code. Just uncomment it and use it. -->

    <!-- CSS | Theme Color -->
    <link href="${pageContext.request.contextPath}/css/colors/theme-skin-color-set1.css" rel="stylesheet"
          type="text/css">

    <!-- external javascripts -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/javascript-plugins-bundle.js"></script>
    <script src="${pageContext.request.contextPath}/js/menuzord/js/menuzord.js"></script>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body class="container-1340px has-side-panel side-panel-right">
<!-- preloader -->
<div id="preloader">
    <div id="spinner">
        <div class="preloader-dot-loading">
            <div class="cssload-loading"><i></i><i></i><i></i><i></i></div>
        </div>
    </div>
    <div id="disable-preloader" class="btn btn-default btn-sm">Disable Preloader</div>
</div>

<div class="side-panel-body-overlay"></div>
<div id="side-panel-container" class="dark" data-tm-bg-img="images/side-push-bg.jpg">
    <div class="side-panel-wrap">
        <div id="side-panel-trigger-close" class="side-panel-trigger"><a href="#"><i
                class="fa fa-times side-panel-trigger-icon"></i></a></div>
        <p style="text-align: center">活动打卡</p>

        <img class="logo mb-50" src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}" alt="Logo">
        <p>做你没做过的事情叫成长，做你不愿意做的事情叫改变，做你不敢做的事情叫突破。</p>
        <div class="widget">
            <h4 class="widget-title widget-title-line-bottom line-bottom-theme-colored1" style="color: red;">
                进行中的活动~</h4>
            <p id="time" style="color: #0c8d0c"></p>
            <div class="latest-posts">
                <article class="post media-post clearfix pb-0 mb-10">
                    <a class="post-thumb" href="${pageContext.request.contextPath}/news-details.html"><img
                            src="${pageContext.request.contextPath}/images/blog/latest-news1.jpg" alt=""></a>
                    <div class="post-right">
                        <h5 class="post-title mt-0"><a
                                href="${pageContext.request.contextPath}/news-details.html">活动名称</a></h5>
                        <p>活动时间</p>
                    </div>

                    <div class="buttons cart-action-buttons" style="width: 230px;">
                        <div class="row">
                            <div class="col-6 pl-1"><a href="${pageContext.request.contextPath}/User/userLogin"
                                                       class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">打卡</a>
                            </div>
                        </div>
                    </div>
                    <br>
                </article>
            </div>
        </div>

        <div class="widget">
            <h5 class="widget-title widget-title-line-bottom line-bottom-theme-colored1">个人信息</h5>
            <div class="tm-widget-contact-info contact-info-style1 contact-icon-theme-colored1">
                <ul>
                    <li class="contact-name">
                        <div class="icon"><i class="flaticon-contact-037-address"></i></div>
                        <div class="text">姓名：${sessionScope.userInfo.userName}</div>
                    </li>
                    <li class="contact-phone">
                        <div class="icon"><i class="flaticon-contact-042-phone-1"></i></div>
                        <div class="text"><a href="tel:+510-455-6735">电话：${sessionScope.userInfo.userTel}</a></div>
                    </li>
                    <li class="contact-email">
                        <div class="icon"><i class="flaticon-contact-043-email-1"></i></div>
                        <div class="text"><a href="mailto:info@yourdomain.com">邮箱：${sessionScope.userInfo.userEmail}</a>
                        </div>
                    </li>
                    <li class="contact-address">
                        <div class="icon"><i class="flaticon-contact-047-location"></i></div>
                        <div class="text">所属组织：${sessionScope.userInfo.teamJobInfo.teamJobName}</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div id="wrapper" class="clearfix">
    <!-- Header -->
    <header id="header" class="header header-layout-type-header-2rows">
        <div class="header-top">
            <div class="container">
                <div class="row">
                    <div class="col-xl-auto header-top-left align-self-center text-center text-xl-left">
                        <ul class="element contact-info">
                            <li class="contact-phone"><i class="fa fa-phone font-icon sm-display-block"></i>
                                Tel: ${userInfo.userTel}</li>
                            <li class="contact-email"><i
                                    class="fa fa-envelope font-icon sm-display-block"></i> ${userInfo.userEmail}</li>
                            <li class="contact-address"><i
                                    class="fa fa-map font-icon sm-display-block"></i> ${userInfo.userCardId}</li>
                        </ul>
                    </div>
                    <div class="col-xl-auto ml-xl-auto header-top-right align-self-center text-center text-xl-right">
                        <div class="element pt-0 pb-0">
                            <ul class="styled-icons icon-dark icon-theme-colored1 icon-circled clearfix">
                                <li><a class="social-link" href="#"><i class="fab fa-facebook"></i></a></li>
                                <li><a class="social-link" href="#"><i class="fab fa-twitter"></i></a></li>
                                <li><a class="social-link" href="#"><i class="fab fa-youtube"></i></a></li>
                            </ul>
                        </div>
                        <div class="element pt-0 pt-lg-10 pb-0">
                            <a href="${pageContext.request.contextPath}/ajax-load/form-appointment.jsp"
                               class="btn btn-theme-colored2 btn-sm ajaxload-popup">发送邮件</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-nav tm-enable-navbar-hide-on-scroll">
            <div class="header-nav-wrapper navbar-scrolltofixed">
                <div class="menuzord-container header-nav-container">
                    <div class="container position-relative">
                        <div class="row header-nav-col-row">
                            <div class="col-sm-auto align-self-center">
                                <a class="menuzord-brand site-brand"
                                   href="${pageContext.request.contextPath}/index-mp-layout1.html">
                                    <img class="logo-default logo-1x"
                                         src="${pageContext.request.contextPath}/images/logo-wide.png" alt="Logo">
                                    <img class="logo-default logo-2x retina"
                                         src="${pageContext.request.contextPath}/images/logo-wide@2x.png" alt="Logo">
                                </a>
                            </div>
                            <div class="col-sm-auto ml-auto pr-0 align-self-center">
                                <nav id="top-primary-nav" class="menuzord green" data-effect="fade"
                                     data-animation="none" data-align="right">
                                    <ul id="main-nav" class="menuzord-menu">
                                        <li class="active">
                                            <a href="${pageContext.request.contextPath}/User/userLogin?userLoginName=${sessionScope.userInfo.userLoginName}&userPwd=${sessionScope.userInfo.userPwd}">主页</a>
                                        </li><!-- Footer -->
                                        <li><a href="${pageContext.request.contextPath}/news/findAll">公告</a></li>
                                        <li class="menu-item"><a
                                                href="${pageContext.request.contextPath}/Active/findActiveList">参与活动</a>
                                            <%--     <ul class="dropdown">
                                                     <li><a href="${pageContext.request.contextPath}/Active/findActiveList">个人活动</a></li>
                                                     <li><a href="#">组织活动</a></li>
                                                 </ul>--%>
                                        </li>
                                        <li class="menu-item"><a href="page-causes-grid.html">组织模块</a>
                                            <ul class="dropdown">
                                                <li><a href="${pageContext.request.contextPath}/User/buildTeam">创建组织</a></li>
                                                <li><a href="${pageContext.request.contextPath}/Team/findTeam?userId=${sessionScope.userInfo.userId}">加入组织</a></li>
                                                <li><a href="${pageContext.request.contextPath}/Team/MyTeam?userId=${sessionScope.userInfo.userId}">我的组织</a></li>
                                            </ul>
                                        </li>
                                        <li class="menu-item"><a href="news-grid.html">志愿记录</a>
                                            <ul class="dropdown">
                                                <li><a href="news-grid.html">个人记录</a></li>
                                                <li><a href="news-details.html">组织记录</a></li>
                                            </ul>
                                        </li>
                                        <li class="menu-item"><a href="${pageContext.request.contextPath}/User/userIndex">个人中心</a></li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="col-sm-auto align-self-center nav-side-icon-parent">
                                <ul class="list-inline nav-side-icon-list">
                                    <li class="hidden-mobile-mode"><a href="#" id="top-nav-search-btn"><i
                                            class="search-icon fa fa-search"></i></a></li>
                                    <li class="hidden-mobile-mode">
                                        <div class="top-nav-mini-cart-icon-container">
                                            <div class="top-nav-mini-cart-icon-contents">
                                                <a class="mini-cart-icon" href="shop-cart.html"
                                                   title="View your shopping cart">
                                                    <img src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}"
                                                         width="25" alt="cart"><span class="items-count">1</span> <span
                                                        class="cart-quick-info">1 item - <span class="amount"><span
                                                        class="currencySymbol">&pound;</span>18.00</span></span>
                                                </a>
                                                <div class="dropdown-content">
                                                    <ul class="cart_list product_list_widget">
                                                        <li class="mini_cart_item">
                                                            <a href="#" class="remove remove_from_cart_button"
                                                               aria-label="Remove this item" data-product_id="18832"
                                                               data-cart_item_key="#" data-product_sku="woo-beanie">&times;</a>
                                                            <a href="#"> <img class="attachment-thumbnail"
                                                                              src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}"
                                                                              width="300" height="300"
                                                                              alt=""/>${sessionScope.userInfo.userName}
                                                            </a>
                                                            <span class="quantity">组织：  <span class="amount"><span
                                                                    class="currencySymbol"></span>${sessionScope.userInfo.teamName}</span></span>
                                                            <span class="quantity">职位：  <span class="amount"><span
                                                                    class="currencySymbol"></span>${sessionScope.userInfo.teamJobInfo.teamJobName}</span></span>
                                                        </li>
                                                    </ul>
                                                    <p class="total"><strong>当前状态：</strong> <span
                                                            class="woocommerce-Price-amount amount"><span
                                                            class="currencySymbol"></span><font style="color: #045e04;">在线</font></span>
                                                    </p>
                                                    <div class="buttons cart-action-buttons">
                                                        <div class="row">
                                                            <c:choose>
                                                            <c:when test="${sessionScope.userInfo.userId>0}">
                                                            <div class="col-6 pr-1"><a
                                                                    href="${pageContext.request.contextPath}/User/loginOut"
                                                                    class="btn btn-theme-colored2 btn-block btn-sm wc-forward">退出</a>
                                                            </div>
                                                            <div class="col-6 pl-1"><a
                                                                    href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp"
                                                                    class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">登录</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                <div class="col-6 pl-1"><a
                                                                        href="${pageContext.request.contextPath}/User/userLogin"
                                                                        class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">登录</a>
                                                                    </c:otherwise>
                                                                    </c:choose>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </li>
                                    <li class="hidden-mobile-mode">
                                        <div id="side-panel-trigger" class="side-panel-trigger">
                                            <a href="#">
                                                <div class="hamburger-box">
                                                    <div class="hamburger-inner"></div>
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                                <div id="top-nav-search-form" class="clearfix">
                                    <form action="#" method="GET">
                                        <input type="text" name="s" value="" placeholder="Type and Press Enter..."
                                               autocomplete="off"/>
                                    </form>
                                    <a href="#" id="close-search-btn"><i class="fa fa-times"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="row d-block d-xl-none">
                            <div class="col-12">
                                <nav id="top-primary-nav-clone"
                                     class="menuzord d-block d-xl-none default menuzord-color-default menuzord-border-boxed menuzord-responsive"
                                     data-effect="slide" data-animation="none" data-align="right">
                                    <ul id="main-nav-clone"
                                        class="menuzord-menu menuzord-right menuzord-indented scrollable">
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Start main-content -->
    <div class="main-content-area">
        <!-- Section: page title -->
        <section class="page-title layer-overlay overlay-dark-9 section-typo-light bg-img-center"
                 data-tm-bg-img="images/bg/bg1.jpg">
            <div class="container pt-50 pb-50">
                <div class="section-content">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h2 class="title">个人活动</h2>
                            <nav class="breadcrumbs" role="navigation" aria-label="Breadcrumbs">
                                <div class="breadcrumbs">
                                    <span><a href="#" rel="home">主页</a></span>
                                    <span><i class="fa fa-angle-right"></i></span>
                                    <span><a href="#">活动</a></span>
                                    <span><i class="fa fa-angle-right"></i></span>
                                    <span class="active">个人活动</span>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <section class="">
            <div class="container">
                <div class="section-content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Isotope Filter -->
                            <div class=" filter-style-4 text-left cat-filter-default text-center"
                                 data-link-with="gallery-holder-618422">
                                <a href="${pageContext.request.contextPath}/Active/findActiveList" class="active"
                                   data-filter="*">全部&nbsp;&nbsp;</a>
                                <c:forEach items="${activeTypeInfoList}" var="li">
                                    <c:choose>
                                        <c:when test="${li.activeTypeState=='已发布'}">
                                            <a href="${pageContext.request.contextPath}/Active/findActiveType?activeTypeId=${li.activeTypeId}"
                                               class="active" data-filter="*">${li.activeTypeName}&nbsp;&nbsp;</a>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </div>
                            <br>
                            <!-- End Isotope Filter -->

                            <!-- Isotope Gallery Grid -->


                            <div class="section-content">
                                <div class="row">
                                    <c:forEach items="${activeInfoList}" var="li">
                                        <c:choose>
                                            <c:when test="${li.activeState=='上线'}">
                                                <div class="col-md-12 col-lg-6 col-xl-4">
                                                    <div class="causes-item mb-lg-30">
                                                        <div class="causes-thumb">
                                                            <img src="${pageContext.request.contextPath}/img/${li.img}"
                                                                 style="height: 280px;" alt="" class="w-100">
                                                            <a href="${pageContext.request.contextPath}/User/findActiveById?activeId=${li.activeId}"
                                                               class="btn btn-donate-now btn-theme-colored2">立刻参与</a>
                                                        </div>
                                                        <div class="causes-details">
                                                            <h3 class="causes-title mt-0 mb-20">${li.activeName}</h3>
                                                            <h6 class="causes-title mt-0 mb-20"><font
                                                                    style="font-family: 微软雅黑;font-weight:300">活动地点：${li.activeAddress}</font>
                                                            </h6>
                                                            <h6 class="causes-title mt-0 mb-20"><font
                                                                    style="font-family: 微软雅黑;font-weight:300">活动类型：${li.activeTypeInfo.activeTypeName}</font>
                                                            </h6>
                                                            <h6 class="causes-title mt-0 mb-20"><font
                                                                    style="font-family: 微软雅黑;font-weight:300">活动时间：${li.activeStartTime}-${li.activeEndTime}</font>
                                                            </h6>
                                                            <h6 class="causes-title mt-0 mb-20"><font
                                                                    style="font-family: 微软雅黑;font-weight:300">发布人员：${li.adminInfo.adminLoginName}</font>
                                                            </h6>
                                                            <p class="causes-text mb-0 mb-60">${li.activeContext}</p>
                                                            <div class="tm-sc-progress progress-item current-style theme-style mb-0">
                                                                <div class="tm-sc-progress-bar progress-bar-floating-percent"
                                                                     data-percent="${li.activeJoinNum/li.activeHighNum*100}"
                                                                     data-bar-height="">
                                                                    <div class="progress-title-holder">
                                                                        <span class="percent"><span
                                                                                class="symbol-left"></span><span
                                                                                class="value">${li.activeJoinNum/li.activeHighNum*100}</span><span
                                                                                class="symbol-right">%</span></span>
                                                                    </div>
                                                                    <div class="progress-holder">
                                                                        <div class="progress-content"
                                                                             data-width="60%"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="donation-goal">
                                                            <ul>
                                                                <li>
                                                                    <div class="raised">
                                                                        <p class="mb-0">当前人数：<span
                                                                                style="font-size: 20px;">${li.activeJoinNum}人</span>
                                                                        </p>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="raised">
                                                                        <p class="mb-0">最大人数：<span
                                                                                style="font-size: 20px;">${li.activeHighNum}人</span>
                                                                        </p>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- End Isotope Gallery Grid -->
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
    <!-- end main-content -->
    <!-- Footer -->
    <footer id="footer" class="footer bg-no-repeat" data-tm-bg-img="images/footer-bg.png">
        <div class="footer-widget-area">
            <div class="container pt-100 pb-70">
                <div class="row">
                    <div class="col-md-6 col-lg-6 col-xl-4">
                        <div id="tm_widget_contact_info-1"
                             class="split-nav-menu clearfix widget widget-contact-info clearfix mb-20 pr-30">
                            <div class="tm-widget tm-widget-contact-info contact-info contact-info-style1  contact-icon-theme-colored1">
                                <img class="mb-20" src="${pageContext.request.contextPath}/images/logo-wide-white.png"
                                     alt="images">
                                <p>在劳动力和劳动力相等的情况下，当劳动力与劳动力的劳动力相同时，劳动力会产生劳动力。</p>
                                <h4 class="text-theme-colored2 m-0">888 888 0000</h4>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <div class="footer-bottom">
                <div class="container">
                    <div class="row pt-30 pb-30">
                        <div class="col-sm-6">
                            <div class="footer-paragraph text-center text-xl-left text-lg-left text-md-left mb-sm-15">
                                集宁师范学院2023届毕业设计
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <ul class="styled-icons icon-dark icon-md icon-circled text-center text-xl-right text-lg-right text-md-right">
                                <li><a data-tm-bg-color="#3457F1" class="social-link" href="#"><i
                                        class="fab fa-facebook"></i></a></li>
                                <li><a data-tm-bg-color="#4EBEFF" class="social-link" href="#"><i
                                        class="fab fa-twitter"></i></a></li>
                                <li><a data-tm-bg-color="#EF3230" class="social-link" href="#"><i
                                        class="fab fa-youtube"></i></a></li>
                                <li><a data-tm-bg-color="#5376AC" class="social-link" href="#"><i
                                        class="fab fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- end wrapper -->

<!-- Footer Scripts -->
<!-- JS | Custom script for all pages -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script>
    setInterval(time, 1000) //定时器
    function time() { //定义方法 time
        let time = new Date();  //实例化日期对象
        let year = time.getFullYear() + "年" //获取年
        let month = time.getMonth() + 1 + "月" //获取月
        let day = time.getDate() + "日"      //获取日
        let h = time.getHours() + ':'        //获取时
        let m = time.getMinutes() + ":"      //获取分
        let s = time.getSeconds()          //获取秒
        if (s < 10) {                        //判定秒 是否小于10秒
            s = "0" + time.getSeconds()      //小于是 在其前加0 01，02，03...
        }
        if (time.getMinutes() < 10) {        //判定分 是否小于10分
            m = "0" + time.getMinutes() + ":"  //小于是 在其前加0 01，02，03...
        }
        document.getElementById('time').innerHTML = '当前时间：' + year + month + day + h + m + s  //显示当前时间
    }
</script>
</body>
</html>