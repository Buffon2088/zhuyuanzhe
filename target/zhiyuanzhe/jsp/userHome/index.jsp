<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
<title>新冠疫情志愿系统</title>

<!-- Favicon and Touch Icons -->
<link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" type="image/png">
<link href="images/apple-touch-icon.png" rel="apple-touch-icon">
<link href="images/apple-touch-icon-72x72.png" rel="apple-touch-icon" sizes="72x72">
<link href="images/apple-touch-icon-114x114.png" rel="apple-touch-icon" sizes="114x114">
<link href="images/apple-touch-icon-144x144.png" rel="apple-touch-icon" sizes="144x144">

<!-- Stylesheet -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/javascript-plugins-bundle.css" rel="stylesheet"/>

<!-- CSS | menuzord megamenu skins -->
<link href="${pageContext.request.contextPath}/js/menuzord/css/menuzord.css" rel="stylesheet"/>

<!-- CSS | timeline -->
<link href="${pageContext.request.contextPath}/js/timeline-cp-responsive-vertical/timeline-cp-responsive-vertical.css" rel="stylesheet" type="text/css">

<!-- CSS | Main style file -->
<link href="${pageContext.request.contextPath}/css/style-main.css" rel="stylesheet" type="text/css">
<link id="menuzord-menu-skins" href="${pageContext.request.contextPath}/css/menuzord-skins/menuzord-rounded-boxed.css" rel="stylesheet"/>

<!-- CSS | Responsive media queries -->
<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet" type="text/css">
<!-- CSS | Style css. This is the file where you can place your own custom css code. Just uncomment it and use it. -->

<!-- CSS | Theme Color -->
<link href="${pageContext.request.contextPath}/css/colors/theme-skin-color-set1.css" rel="stylesheet" type="text/css">

<!-- external javascripts -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/javascript-plugins-bundle.js"></script>
<script src="${pageContext.request.contextPath}/js/menuzord/js/menuzord.js"></script>

<!-- REVOLUTION STYLE SHEETS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/revolution-slider/css/rs6.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/revolution-slider/extra-rev-slider1.css">
<!-- REVOLUTION LAYERS STYLES -->
<!-- REVOLUTION JS FILES -->
<script src="${pageContext.request.contextPath}/js/revolution-slider/js/revolution.tools.min.js"></script>
<script src="${pageContext.request.contextPath}/js/revolution-slider/js/rs6.min.js"></script>
<script src="${pageContext.request.contextPath}/js/revolution-slider/extra-rev-slider1.js"></script>

<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> -->


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="/https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body class="container-1340px has-side-panel side-panel-right">

<div class="side-panel-body-overlay"></div>
<div id="side-panel-container" class="dark" data-tm-bg-img="images/side-push-bg.jpg">
  <div class="side-panel-wrap">
    <div id="side-panel-trigger-close" class="side-panel-trigger"><a href="#"><i class="fa fa-times side-panel-trigger-icon"></i></a></div>
    <p style="text-align: center">活动打卡</p>

    <img class="logo mb-50" src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}" alt="Logo">
    <p>做你没做过的事情叫成长，做你不愿意做的事情叫改变，做你不敢做的事情叫突破。</p>
    <div class="widget">
      <h4 class="widget-title widget-title-line-bottom line-bottom-theme-colored1" style="color: red;">进行中的活动</h4>
      <p id="time" style="color: #0c8d0c"></p>
      <div class="latest-posts">
        <article class="post media-post clearfix pb-0 mb-10">
          <a class="post-thumb" href="${pageContext.request.contextPath}/news-details.html"><img src="${pageContext.request.contextPath}/images/blog/latest-news1.jpg" alt=""></a>
          <div class="post-right">
            <h5 class="post-title mt-0"><a href="${pageContext.request.contextPath}/news-details.html">活动名称</a></h5>
            <p>活动时间</p>
          </div>
          <div class="buttons cart-action-buttons" style="width: 230px;">
            <div class="row">
              <div class="col-6 pl-1"><a href="${pageContext.request.contextPath}/User/userLogin" class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">打卡</a>
              </div>
            </div>
          </div>

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
            <div class="text"><a href="mailto:info@yourdomain.com">邮箱：${sessionScope.userInfo.userEmail}</a></div>
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
              <li class="contact-phone"><i class="fa fa-phone font-icon sm-display-block"></i> Tel: ${userInfo.userTel}</li>
              <li class="contact-email"><i class="fa fa-envelope font-icon sm-display-block"></i> ${userInfo.userEmail}</li>
              <li class="contact-address"><i class="fa fa-map font-icon sm-display-block"></i> ${userInfo.userCardId}</li>
            </ul>
          </div>
          <div class="col-xl-auto ml-xl-auto header-top-right align-self-center text-center text-xl-right">
            <div class="element pt-0 pb-0">
              <ul class="styled-icons icon-dark icon-theme-colored1 icon-circled clearfix">
                <li><a class="social-link" href="#" ><i class="fab fa-facebook"></i></a></li>
                <li><a class="social-link" href="#" ><i class="fab fa-twitter"></i></a></li>
                <li><a class="social-link" href="#" ><i class="fab fa-youtube"></i></a></li>
              </ul>
            </div>
            <div class="element pt-0 pt-lg-10 pb-0">
              <a href="${pageContext.request.contextPath}/ajax-load/form-appointment.jsp" class="btn btn-theme-colored2 btn-sm ajaxload-popup">发送邮件</a>
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
                <a class="menuzord-brand site-brand" href="index-mp-layout1.html">
                  <img class="logo-default logo-1x" src="${pageContext.request.contextPath}/images/logo-wide.png" alt="Logo">
                  <img class="logo-default logo-2x retina" src="${pageContext.request.contextPath}/images/logo-wide@2x.png" alt="Logo">
                </a>
              </div>
              <div class="col-sm-auto ml-auto pr-0 align-self-center">
                <nav id="top-primary-nav" class="menuzord green" data-effect="fade" data-animation="none" data-align="right">
                  <ul id="main-nav" class="menuzord-menu">
                    <li class="active">
                      <a href="${pageContext.request.contextPath}/User/userLogin?userLoginName=${sessionScope.userInfo.userLoginName}&userPwd=${sessionScope.userInfo.userPwd}">主页</a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/news/findAll">公告</a></li>
                    <li class="menu-item"><a href="${pageContext.request.contextPath}/Active/findActiveList">参与活动</a>
                     <%-- <ul class="dropdown">
                        <li><a href="${pageContext.request.contextPath}/Active/findActiveList">个人活动</a></li>
                        <li><a href="#">组织活动</a></li>
                      </ul>--%>
                    </li>
                    <li class="menu-item"><a href="page-causes-grid.html">组织模块</a>
                      <ul class="dropdown">
                        <li><a href="${pageContext.request.contextPath}/User/buildTeam">创建组织</a></li>
                        <li><a href="page-causes-details.html">加入组织</a></li>
                      </ul>
                    </li>
                    <li class="menu-item"><a href="news-grid.html">志愿记录</a>
                      <ul class="dropdown">
                        <li><a href="news-grid.html">News Grid</a></li>
                        <li><a href="news-details.html">News Details</a></li>
                      </ul>
                    </li>
                    <li class="menu-item"><a href=${pageContext.request.contextPath}/User/userIndex>个人中心</li>
                  </ul>
                </nav>
              </div>
              <div class="col-sm-auto align-self-center nav-side-icon-parent">
                <ul class="list-inline nav-side-icon-list">

                  <li class="hidden-mobile-mode">
                    <div class="top-nav-mini-cart-icon-container">
                      <div class="top-nav-mini-cart-icon-contents">
                        <div class="top-nav-mini-cart-icon-contents">
                          <a class="mini-cart-icon" href="shop-cart.html" title="View your shopping cart">
                            <img src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}" width="25" alt="cart"><span class="items-count">1</span> <span class="cart-quick-info">1 item - <span class="amount"><span class="currencySymbol">&pound;</span>18.00</span></span>
                          </a>
                          <div class="dropdown-content">
                            <ul class="cart_list product_list_widget">
                              <li class="mini_cart_item">
                                <a href="#" class="remove remove_from_cart_button" aria-label="Remove this item" data-product_id="18832" data-cart_item_key="#" data-product_sku="woo-beanie">&times;</a>
                                <a href="#"> <img class="attachment-thumbnail" src="${pageContext.request.contextPath}/img/${sessionScope.userInfo.img}" width="300" height="300" alt=""/>${sessionScope.userInfo.userName}</a>
                                <span class="quantity">组织：  <span class="amount"><span class="currencySymbol"></span>${sessionScope.userInfo.teamName}</span></span>
                                <span class="quantity">职位：  <span class="amount"><span class="currencySymbol"></span>${sessionScope.userInfo.teamJobInfo.teamJobName}</span></span>
                              </li>
                            </ul>
                            <p class="total"><strong>当前状态：</strong> <span class="woocommerce-Price-amount amount"><span class="currencySymbol"></span><font style="color: #045e04;">在线</font></span></p>
                            <div class="buttons cart-action-buttons">
                              <div class="row">
                                <c:choose>
                                <c:when test="${sessionScope.userInfo.userId>0}">
                                <div class="col-6 pr-1"><a href="${pageContext.request.contextPath}/User/loginOut" class="btn btn-theme-colored2 btn-block btn-sm wc-forward">退出</a></div>
                                <div class="col-6 pl-1"><a href="${pageContext.request.contextPath}/jsp/adminHome/admin_login.jsp" class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">登录</a>
                                  </c:when>
                                  <c:otherwise>
                                  <div class="col-6 pl-1"><a href="${pageContext.request.contextPath}/User/userLogin" class="btn btn-theme-colored1 btn-block btn-sm checkout wc-forward">登录</a>
                                    </c:otherwise>
                                    </c:choose>
                                </div>
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
                    <input type="text" name="s" value="" placeholder="Type and Press Enter..." autocomplete="off" />
                  </form>
                  <a href="#" id="close-search-btn"><i class="fa fa-times"></i></a>
                </div>
              </div>
            </div>
            <div class="row d-block d-xl-none">
               <div class="col-12">
                <nav id="top-primary-nav-clone" class="menuzord d-block d-xl-none default menuzord-color-default menuzord-border-boxed menuzord-responsive" data-effect="slide" data-animation="none" data-align="right">
                 <ul id="main-nav-clone" class="menuzord-menu menuzord-right menuzord-indented scrollable">
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
    <!-- Section: home -->
    <section id="home" class="">
      <div class="container-fluid p-0">
        <div class="row">
          <div class="col">
            <!-- START Soolhart HTML RevSlider REVOLUTION SLIDER 6.1.7 -->
            <p class="rs-p-wp-fix"></p>
            <rs-module-wrap id="rev_slider_1_1_wrapper" data-alias="soolhart-html-revslider" data-source="gallery" style="background:transparent;padding:0;margin:0px auto;margin-top:0;margin-bottom:0;">
              <rs-module id="rev_slider_1_1" style="display:none;" data-version="6.1.7">
                <rs-slides>
                  <rs-slide data-key="rs-40" data-title="Slide 1" data-thumb="images/bg/slide1.jpg" data-anim="ei:d;eo:d;s:d;r:0;t:slotslide-horizontal;sl:d;">
                    <img src="${pageContext.request.contextPath}/images/bg/slide1.jpg" title="slide1" width="1920" height="1280" data-parallax="off" class="rev-slidebg" data-no-retina>
                    <rs-layer
                      id="slider-9-slide-40-layer-10"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:130px,171px,129px,155px;"
                      data-text="w:normal;s:20,18,18,16;l:31,24,18,11;a:left,left,center,center;"
                      data-dim="w:184px,161px,178px,149px;"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:12;font-family:Roboto;"
                      >立刻参与</rs-layer>
                    <rs-layer
                      id="slider-9-slide-40-layer-11"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:465px,440px,378px,334px;"
                      data-text="w:normal;s:20,18,18,16;l:31,27,24,22;a:left,left,center,center;"
                      data-dim="w:751px,619px,551px,470px;"
                      data-frame_1="st:1500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:9;"
                      >赠人玫瑰，手有余香；帮助他人，就是帮助自己.
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-40-layer-12"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:245px,221px,0,0;yo:145px,183px,107px,132px;"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:70px,54px,45px,45px;h:2px,2px,3px,3px;"
                      data-frame_1="st:800;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:11;background-color:#ffffff;"
                      >
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-40-layer-18"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,46px,0,0;yo:185px,214px,169px,187px;"
                      data-text="w:normal;s:130,110,92,64;l:120,98,84,60;ls:-7px,-5px,-3px,-1px;fw:700;a:left,left,center,center;"
                      data-dim="w:auto,auto,auto,455px;"
                      data-frame_1="st:1100;sp:1000;sR:600;"
                      data-frame_999="o:0;st:w;sR:7400;"
                      style="z-index:10;font-family:Averia Sans Libre;"
                      >Let’s become<br />
                      a helping hand
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-40-layer-22"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:60px,50px,0,-8px;yo:568px,537px,459px,412px;"
                      data-text="w:normal;s:20,16,16,15;l:25,20,18,20;a:left,left,left,center;"
                      data-frame_1="st:1700;sp:1000;sR:1200;"
                      data-frame_999="o:0;st:w;sR:6800;"
                      style="z-index:8;"
                      ><a href="page-about.html" class="btn btn-lg btn-bordered btn-theme-colored1 text-white">查看更多</a>
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-40-layer-33"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:100%;h:100%;"
                      data-basealign="slide"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;sR:8000;"
                      style="z-index:3;background-color:rgba(0,0,0,0.5);"
                    >
                    </rs-layer>
                  </rs-slide>
                  <rs-slide data-key="rs-43" data-title="Slide 1" data-thumb="images/bg/slide2.jpg" data-anim="ei:d;eo:d;s:d;r:0;t:slotslide-horizontal;sl:d;">
                    <img src="${pageContext.request.contextPath}/images/bg/slide2.jpg" title="slide2" width="1920" height="1280" data-parallax="off" class="rev-slidebg" data-no-retina>
                    <rs-layer
                      id="slider-9-slide-43-layer-10"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:130px,171px,129px,155px;"
                      data-text="w:normal;s:20,18,18,16;l:31,24,18,11;a:left,left,center,center;"
                      data-dim="w:184px,161px,178px,149px;"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:12;font-family:Roboto;"
                      >立刻行动
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-43-layer-11"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:465px,440px,378px,334px;"
                      data-text="w:normal;s:20,18,18,16;l:31,27,24,22;a:left,left,center,center;"
                      data-dim="w:751px,619px,551px,470px;"
                      data-frame_1="st:1500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:9;"
                      >赠人玫瑰，手有余香；帮助他人，就是帮助自己.
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-43-layer-12"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:245px,221px,0,0;yo:145px,183px,107px,132px;"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:70px,54px,45px,45px;h:2px,2px,3px,3px;"
                      data-frame_1="st:800;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:11;background-color:#ffffff;"
                      >
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-43-layer-18"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,46px,0,0;yo:185px,214px,169px,187px;"
                      data-text="w:normal;s:130,110,92,64;l:120,98,84,60;ls:-7px,-5px,-3px,-1px;fw:700;a:left,left,center,center;"
                      data-dim="w:auto,auto,auto,455px;"
                      data-frame_1="st:1100;sp:1000;sR:600;"
                      data-frame_999="o:0;st:w;sR:7400;"
                      style="z-index:10;font-family:Averia Sans Libre;"
                      >Let’s become<br />
                      a helping hand
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-43-layer-22"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:60px,50px,0,-8px;yo:568px,537px,459px,412px;"
                      data-text="w:normal;s:20,16,16,15;l:25,20,18,20;a:left,left,left,center;"
                      data-frame_1="st:1700;sp:1000;sR:1200;"
                      data-frame_999="o:0;st:w;sR:6800;"
                      style="z-index:8;"
                      ><a href="page-about.html" class="btn btn-lg btn-bordered btn-theme-colored1 text-white">Learn More</a>
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-43-layer-33"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:100%;h:100%;"
                      data-basealign="slide"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;sR:8000;"
                      style="z-index:3;background-color:rgba(0,0,0,0.5);"
                    >
                    </rs-layer>
                  </rs-slide>
                  <rs-slide data-key="rs-44" data-title="Slide 1" data-thumb="images/bg/slide3.jpg" data-anim="ei:d;eo:d;s:d;r:0;t:slotslide-horizontal;sl:d;">
                    <img src="${pageContext.request.contextPath}/images/bg/slide3.jpg" title="slide3" width="1920" height="1280" data-parallax="off" class="rev-slidebg" data-no-retina>
                    <rs-layer
                      id="slider-9-slide-44-layer-10"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:130px,171px,129px,155px;"
                      data-text="w:normal;s:20,18,18,16;l:31,24,18,11;a:left,left,center,center;"
                      data-dim="w:184px,161px,178px,149px;"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:12;font-family:Roboto;"
                      >立刻行动
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-44-layer-11"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,51px,0,0;yo:465px,440px,378px,334px;"
                      data-text="w:normal;s:20,18,18,16;l:31,27,24,22;a:left,left,center,center;"
                      data-dim="w:751px,619px,551px,470px;"
                      data-frame_1="st:1500;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:9;"
                      >赠人玫瑰，手有余香；帮助他人，就是帮助自己.
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-44-layer-12"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:245px,221px,0,0;yo:145px,183px,107px,132px;"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:70px,54px,45px,45px;h:2px,2px,3px,3px;"
                      data-frame_1="st:800;sp:1000;"
                      data-frame_999="o:0;st:w;"
                      style="z-index:11;background-color:#ffffff;"
                      >
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-44-layer-18"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:55px,46px,0,0;yo:185px,214px,169px,187px;"
                      data-text="w:normal;s:130,110,92,64;l:120,98,84,60;ls:-7px,-5px,-3px,-1px;fw:700;a:left,left,center,center;"
                      data-dim="w:auto,auto,auto,455px;"
                      data-frame_1="st:1100;sp:1000;sR:600;"
                      data-frame_999="o:0;st:w;sR:7400;"
                      style="z-index:10;font-family:Averia Sans Libre;"
                      >Let’s become<br />
                      a helping hand
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-44-layer-22"
                      data-type="text"
                      data-rsp_ch="on"
                      data-xy="x:l,l,c,c;xo:60px,50px,0,-8px;yo:568px,537px,459px,412px;"
                      data-text="w:normal;s:20,16,16,15;l:25,20,18,20;a:left,left,left,center;"
                      data-frame_1="st:1700;sp:1000;sR:1200;"
                      data-frame_999="o:0;st:w;sR:6800;"
                      style="z-index:8;"
                      ><a href="page-about.html" class="btn btn-lg btn-bordered btn-theme-colored1 text-white">Learn More</a>
                    </rs-layer>
                    <rs-layer
                      id="slider-9-slide-44-layer-33"
                      data-type="shape"
                      data-rsp_ch="on"
                      data-text="w:normal;s:20,15,11,6;l:0,19,14,8;"
                      data-dim="w:100%;h:100%;"
                      data-basealign="slide"
                      data-frame_1="st:500;sp:1000;"
                      data-frame_999="o:0;st:w;sR:8000;"
                      style="z-index:3;background-color:rgba(0,0,0,0.5);"
                    >
                    </rs-layer>
                  </rs-slide>
                </rs-slides>
                <rs-static-layers>
                  <!--
                    -->
                </rs-static-layers>
                <rs-progress class="rs-bottom" style="height: 5px; background: rgba(199,199,199,0.5);"></rs-progress>
              </rs-module>
              <script type="text/javascript">
                if(typeof revslider_showDoubleJqueryError === "undefined") {
                  function revslider_showDoubleJqueryError(sliderID) {
                    var err = "<div class='rs_error_message_box'>";
                    err += "<div class='rs_error_message_oops'>Oops...</div>";
                    err += "<div class='rs_error_message_content'>";
                    err += "You have some jquery.js library include that comes after the Slider Revolution files js inclusion.<br>";
                    err += "To fix this, you can:<br>&nbsp;&nbsp;&nbsp; 1. Set 'Module General Options' -> 'Advanced' -> 'jQuery & OutPut Filters' -> 'Put JS to Body' to on";
                    err += "<br>&nbsp;&nbsp;&nbsp; 2. Find the double jQuery.js inclusion and remove it";
                    err += "</div>";
                    err += "</div>";
                    jQuery(sliderID).show().html(err);
                  }
                }
              </script>
            </rs-module-wrap>
            <!-- END REVOLUTION SLIDER -->
          </div>
        </div>
      </div>
    </section>

    <!-- Section: Features -->
    <section class="z-index-1 bg-silver-light">
      <div class="container pt-0 pb-0 pt-md-30">
        <div class="section-content">
          <div class="row no-gutters">
            <div class="col-md-6 col-lg-4 col-xl-4 mt-md-0 mt--100">
              <div class="tm-sc-icon-box icon-box animate-icon-on-hover animate-icon-rotate-y mb-sm-30 bg-theme-colored1 p-60 p-sm-30 section-typo-light">
                <div class="icon-box-wrapper">
                  <div class="icon-wrapper"> <a class="icon icon-default"> <i data-tm-font-size="4rem" class="flaticon-charity-awareness-ribbon-inside-a-heart" ></i> </a></div>
                  <div class="icon-text">
                    <h4 class="icon-box-sub-title mb-0">创始人：ZhanZiQi</h4>
                    <h6 class="icon-box-sub-title mb-0">${userNum}/人</h6>
                    <h4 class="icon-box-title mt-0">志愿人数</h4>
                  </div>
                  <div class="clearfix"></div>
                </div>
              </div>
            </div>
            <div class="col-md-6 col-lg-4 col-xl-4 mt-md-0 mt--100">
              <div class="tm-sc-icon-box icon-box animate-icon-on-hover animate-icon-rotate-y mb-sm-30 bg-theme-colored2 p-60 p-sm-30 section-typo-light">
                <div class="icon-box-wrapper">
                  <div class="icon-wrapper"> <a class="icon icon-default"> <i data-tm-font-size="4rem" class="flaticon-charity-donation-box" ></i> </a></div>
                  <div class="icon-text">
                    <h4 class="icon-box-sub-title mb-0">最热活动：${hotAct}</h4>
                    <h6 class="icon-box-sub-title mb-0">${activeNum}/个</h6>
                    <h4 class="icon-box-title mt-0">活动数量</h4>
                  </div>
                  <div class="clearfix"></div>
                </div>
              </div>
            </div>
            <div class="w-100 d-block d-lg-none border-top-1px"></div>
            <div class="col-md-6 col-lg-4 col-xl-4 mt-md-0 mt--100">
              <div class="tm-sc-icon-box icon-box animate-icon-on-hover animate-icon-rotate-y mb-sm-30 bg-theme-colored1 p-60 p-sm-30 section-typo-light">
                <div class="icon-box-wrapper">
                  <div class="icon-wrapper"> <a class="icon icon-default"> <i data-tm-font-size="4rem" class="flaticon-charity-shaking-hands-inside-a-heart" ></i> </a></div>
                  <div class="icon-text">
                    <h4 class="icon-box-sub-title mb-0">志愿时间最长：${actSumTime}</h4>
                    <h6 class="icon-box-sub-title mb-0">52522/天</h6>
                    <h4 class="icon-box-title mt-0">总服务时长</h4>
                  </div>
                  <div class="clearfix"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Section: Service -->
    <section class="bg-silver-light">
      <div class="container">
        <div class="tm-sc-section-title section-title text-center" data-tm-margin-bottom="100px">
          <div class="row justify-content-md-center">
            <div class="col"></div>
            <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
              <h5 class="text-theme-colored1 mt-0">一个小小的介绍</h5>
              <h2 class="mt-0">欢迎您来到新冠志愿服务大家庭中！非营利慈善组织</h2>
            </div>
            <div class="col"></div>
          </div>
        </div>
      </div>
      <div class="tm-floating-objects">
        <span class="floating-object-1 tm-animation-floating" data-tm-bg-img="images/photos/1.png" data-tm-opacity="0.1" data-tm-width="161" data-tm-height="189" data-tm-top="10%"></span>
      </div>
    </section>

    <!-- Section: Service -->
    <section class="">
      <div class="container">
        <div class="section-content" data-tm-margin-top="-250px">
          <div class="row">
            <div class="col-md-6 col-lg-6 col-xl-3">
              <div class="service-item-current-style1 mb-lg-30">
                <div class="service-icon mb-20">
                  <img class="icon1" src="${pageContext.request.contextPath}/images/icons/service-icon1.png" alt="">
                  <img class="icon2" src="${pageContext.request.contextPath}/images/icons/service-white-icon1.png" alt="">
                </div>
                <h4 class="service-title">新冠病毒 <br>症状</h4>
                <p class="service-details mb-0">
                  根据现有病例资料，新型冠状病毒肺炎以发热、干咳、乏力等为主要表现，少数患者伴有鼻塞、流涕、腹泻等上呼吸道和消化道症状。
                </p>
              </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
              <div class="service-item-current-style1 mb-lg-30">
                <div class="service-icon mb-20">
                  <img class="icon1" src="${pageContext.request.contextPath}/images/icons/service-icon2.png" alt="">
                  <img class="icon2" src="${pageContext.request.contextPath}/images/icons/service-white-icon2.png" alt="">
                </div>
                  <h4 class="service-title">新冠病毒 <br>简介</h4>
                <p class="service-details mb-0">
                  新型冠状病毒是一种全新的冠状病毒，已知的冠状病毒已经超过50种，和人类相关的已经有6种，如果再加上新型冠状病毒肺炎已经有7种。
                </p>
              </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
              <div class="service-item-current-style1 mb-lg-30">
                <div class="service-icon mb-20">
                  <img class="icon1" src="${pageContext.request.contextPath}/images/icons/service-icon3.png" alt="">
                  <img class="icon2" src="${pageContext.request.contextPath}/images/icons/service-white-icon3.png" alt="">
                </div>
                <h4 class="service-title">个人防护 <br>注意</h4>
                <p class="service-details mb-0">
                  避免进出人口密集的公共场所，外出时需要正确佩戴医用口罩，适当进行体育锻炼，能有效增强体质，帮助抵御各种病毒入侵。
                </p>
              </div>
            </div>
            <div class="col-md-6 col-lg-6 col-xl-3">
              <div class="service-item-current-style1">
                <div class="service-icon mb-20">
                  <img class="icon1" src="${pageContext.request.contextPath}/images/icons/service-icon4.png" alt="">
                  <img class="icon2" src="${pageContext.request.contextPath}/images/icons/service-white-icon4.png" alt="">
                </div>
                <h4 class="service-title">我国经济 <br>影响</h4>
                <p class="service-details mb-0">
                  很多产业的经济遭到严重破坏、部分企业工厂相继倒闭、员工被迫失业等等；从另一个角度来说，新冠疫情其所带来的机遇也同样不可忽视。
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Section: Funfacts -->
    <section class="layer-overlay overlay-dark-7 bg-no-repeat bg-pos-center-center" data-tm-bg-img="images/bg/funfact-bg1.jpg">
      <div class="container pt-100 pb-150">
        <div class="tm-sc-section-title section-title text-center mb-30">
          <div class="row justify-content-md-center">
            <div class="col"></div>
            <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
              <h5 class="text-white text-uppercase letter-space-3 font-weight-300 mt-0">你的成就</h5>
            </div>
            <div class="col"></div>
          </div>
        </div>
        <div class="section-content">
          <div class="container">
            <div class="row">
              <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="funfact-item mb-lg-60">
                  <h2 data-animation-duration="2000" data-value="${userJoinNum}" class="counter animate-number mt-0 mb-10">0</h2>
                  <p class="title mb-0">参与公益数量/个</p>
                </div>
              </div>
              <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="funfact-item mb-lg-60">
                  <h2 data-animation-duration="2000" data-value="${userInfo.userHelpTime}" class="counter animate-number mt-0 mb-10">0</h2>
                  <p class="title mb-0">参与公益时间/时</p>
                </div>
              </div>
              <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="funfact-item mb-lg-60">
                  <h2 data-animation-duration="2000" data-value="${teamInfo.teamPeopleNum}" class="counter animate-number mt-0 mb-10">0</h2>
                  <p class="title mb-0">所属组织人数/人</p>
                </div>
              </div>
              <div class="col-md-6 col-lg-6 col-xl-3">
                <div class="funfact-item mb-lg-60">
                  <h2 data-animation-duration="2000" data-value="${teamInfo.teamHelpTime}" class="counter animate-number mt-0 mb-10">1000</h2>
                  <p class="title mb-0">组织公益时长/时</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Section: Latest Causes -->
    <section>
      <div class="container pt-0">
        <div class="tm-sc-section-title section-title text-center">
          <div class="row justify-content-md-center">
            <div class="col"></div>
            <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
              <h5 class="side-line text-theme-colored1 mt-0">立即参与</h5>
              <h2 class="mt-0">最新活动</h2>
            </div>
            <div class="col"></div>
          </div>
        </div>
        <div class="section-content">
          <div class="row">
            <c:forEach items="${threeActive}" var="li" begin="0" end="2" step="1">
              <div class="col-md-12 col-lg-6 col-xl-4">
                <div class="causes-item mb-lg-30">
                  <div class="causes-thumb">
                    <img src="${pageContext.request.contextPath}/img/${li.img}"  style="height: 280px;" alt="" class="w-100">
                    <a href="page-causes-details.html" class="btn btn-donate-now btn-theme-colored2">立刻参与</a>
                  </div>
                  <div class="causes-details">
                    <h3 class="causes-title mt-0 mb-20">${li.activeName}</h3>
                    <h6 class="causes-title mt-0 mb-20"><font style="font-family: 微软雅黑;font-weight:300">活动地点：${li.activeAddress}</font></h6>
                    <h6 class="causes-title mt-0 mb-20"><font style="font-family: 微软雅黑;font-weight:300">活动类型：${li.activeTypeInfo.activeTypeName}</font></h6>
                    <h6 class="causes-title mt-0 mb-20"><font style="font-family: 微软雅黑;font-weight:300">活动时间：${li.activeStartTime}-${li.activeEndTime}</font></h6>
                    <h6 class="causes-title mt-0 mb-20"><font style="font-family: 微软雅黑;font-weight:300">发布人员：${li.adminInfo.adminLoginName}</font></h6>
                    <p class="causes-text mb-0 mb-60">${li.activeContext}</p>
                    <div class="tm-sc-progress progress-item current-style theme-style mb-0">
                      <div class="tm-sc-progress-bar progress-bar-floating-percent" data-percent="${li.activeJoinNum/li.activeHighNum*100}" data-bar-height="">
                        <div class="progress-title-holder">
                          <span class="percent"><span class="symbol-left"></span><span class="value">${li.activeJoinNum/li.activeHighNum*100}</span><span class="symbol-right">%</span></span>
                        </div>
                        <div class="progress-holder">
                          <div class="progress-content" data-width="60%"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="donation-goal">
                    <ul>
                      <li>
                        <div class="raised">
                          <p class="mb-0">当前人数：<span style="font-size: 20px;">${li.activeJoinNum}人</span></p>
                        </div>
                      </li>
                      <li>
                        <div class="raised">
                          <p class="mb-0">最大人数：<span style="font-size: 20px;">${li.activeHighNum}人</span></p>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </c:forEach>



          </div>
        </div>
      </div>
      <div class="tm-floating-objects">
        <span class="floating-object-2 tm-animation-scaling" data-tm-bg-img="images/photos/2.png" data-tm-opacity="0.1" data-tm-width="161" data-tm-height="189" data-tm-top="30%"></span>
      </div>
    </section>

    <!-- Section: Video Popup -->
    <section class="layer-overlay overlay-dark-5 bg-no-repeat" data-tm-bg-img="images/bg/bg1.jpg">
      <div class="container">
        <div class="section-content">
          <div class="row">
            <div class="col"></div>
            <div class="col-lg-10 col-xl-10">
              <div class="video-block text-center mb-0">
                <h6 class="text-uppercase letter-spacing-4px font-weight-500 text-white">回到首页顶部</h6>
                <h2 class="text-white popup-video-title mb-40">衡量生命的标准是 <br> 不是它的持续时间，而是它的捐赠</h2>
                <div class="box-hover-effect tm-sc-video-popup tm-sc-video-popup-css-button">
                  <div class="effect-wrapper d-flex align-items-center">
                    <div class="animated-css-play-button"><span class="play-icon"><i class="fa fa-play"></i></span></div>
                    <a class="hover-link" data-lightbox-gallery="youtube-video" href="#" title=""></a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col"></div>
          </div>
        </div>
      </div>
    </section>

    <!-- Section: Call To Action -->
    <section class="bg-no-repeat bg-pos-center-top bg-size-cover bg-theme-colored2" data-tm-bg-img="images/call-to-action-bg1.png">
      <div class="container">
        <div class="section-content">
          <div class="row d-flex align-items-center">
            <div class="col-lg-8 col-xl-8">
              <div class="book-roofing">
                <div class="book-roofing-text">
                  <h2 class="text-white mt-0 mb-md-15">的最佳方式来改变 <br>其他人的生活</h2>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-xl-4 text-left text-lg-right">
              <a href="page-team-details.html" class="btn btn-circle btn-lg btn-dark text-white">Becone a Volunteer</a>
            </div>
          </div>
        </div>
      </div>
    </section>



    <!-- Section: Testimonials -->
    <section>
      <div class="container-fluid pl-60 pr-60 pl-md-20 pr-md-20">
        <div class="tm-sc-section-title section-title text-center">
          <div class="row justify-content-md-center">
            <div class="col"></div>
            <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
              <h5 class="side-line text-theme-colored1 mt-0">Testimonials</h5>
              <h2 class="mt-0">人们说的话</h2>
            </div>
            <div class="col"></div>
          </div>
        </div>
        <div class="section-content">
          <div class="row">
            <div class="col-md-12 col-lg-6 col-xl-4">
              <div class="testimonial-current-item mb-lg-30">
                <div class="testimonial-thumb-holder d-flex align-items-center">
                  <div class="author-thumb">
                    <img class="w-100 rounded-circle" src="${pageContext.request.contextPath}/images/testimonials/1.jpg" alt="Image">
                  </div>
                  <div class="testimonial-author-info">
                    <h4 class="name m-0">姓名</h4>
                    <p class="job-position text-uppercase font-weight-500 m-0">组织</p>
                  </div>
                </div>
                <div class="testimonial-text-holder">
                  <div class="author-text">There are many variations of passages of lorem ipsum available but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</div>
                </div>
              </div>
            </div>
            <div class="col-md-12 col-lg-6 col-xl-4">
              <div class="testimonial-current-item mb-lg-30">
                <div class="testimonial-thumb-holder d-flex align-items-center">
                  <div class="author-thumb">
                    <img class="w-100 rounded-circle" src="${pageContext.request.contextPath}/images/testimonials/2.jpg" alt="Image">
                  </div>
                  <div class="testimonial-author-info">
                    <h4 class="name m-0">Kevin Martin</h4>
                    <p class="job-position text-uppercase font-weight-500 m-0">Consultant in Bank</p>
                  </div>
                </div>
                <div class="testimonial-text-holder">
                  <div class="author-text">There are many variations of passages of lorem ipsum available but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</div>
                </div>
              </div>
            </div>
            <div class="col-md-12 col-lg-12 col-xl-4">
              <div class="testimonial-current-item">
                <div class="testimonial-thumb-holder d-flex align-items-center">
                  <div class="author-thumb">
                    <img class="w-100 rounded-circle" src="${pageContext.request.contextPath}/images/testimonials/3.jpg" alt="Image">
                  </div>
                  <div class="testimonial-author-info">
                    <h4 class="name m-0">Kevin Martin</h4>
                    <p class="job-position text-uppercase font-weight-500 m-0">Consultant in Bank</p>
                  </div>
                </div>
                <div class="testimonial-text-holder">
                  <div class="author-text">There are many variations of passages of lorem ipsum available but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>





    <!-- Section: Urgent Causes -->


    <!-- Section: News -->


    <!-- Start Divider -->
    <section class="bg-silver-light mt-sm-10" data-tm-margin-top="-100">
      <div class="container pb-80 pt-150 pt-sm-80">
        <div class="section-content">
          <div class="row">
            <div class="col-sm-12">
              <div class="tm-sc-clients tm-sc-clients-carousel owl-dots-light-skin owl-dots-center clients-animation-grayscale">
                <div class="owl-carousel owl-theme tm-owl-carousel-6col" data-autoplay="true" data-loop="true" data-duration="6000" data-smartspeed="300" data-margin="30" data-stagepadding="0" data-laptop="4">
                  <div class="item"> <a target="_blank" > <img src='${pageContext.request.contextPath}/images/clients/1.png' alt='Image' /> </a></div>
                  <div class="item"> <a target="_blank" href="#"> <img src='${pageContext.request.contextPath}/images/clients/2.png' alt='Image' /> </a></div>
                  <div class="item"> <a target="_blank" href="#"> <img src='${pageContext.request.contextPath}/images/clients/3.png' alt='Image' /> </a></div>
                  <div class="item"> <a target="_blank" href="#"> <img src='${pageContext.request.contextPath}/images/clients/4.png' alt='Image' /> </a></div>
                  <div class="item"> <a target="_blank" href="#"> <img src='${pageContext.request.contextPath}/images/clients/5.png' alt='Image' /> </a></div>
                  <div class="item"> <a target="_blank" href="#"> <img src='${pageContext.request.contextPath}/images/clients/6.png' alt='Image' /> </a></div>
                </div>
              </div>
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
            <div id="tm_widget_contact_info-1" class="split-nav-menu clearfix widget widget-contact-info clearfix mb-20 pr-30">
              <div class="tm-widget tm-widget-contact-info contact-info contact-info-style1  contact-icon-theme-colored1">
                <img class="mb-20" src="${pageContext.request.contextPath}/images/logo-wide-white.png" alt="images">
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
                <li><a data-tm-bg-color="#3457F1" class="social-link" href="#"><i class="fab fa-facebook"></i></a></li>
                <li><a data-tm-bg-color="#4EBEFF" class="social-link" href="#"><i class="fab fa-twitter"></i></a></li>
                <li><a data-tm-bg-color="#EF3230" class="social-link" href="#"><i class="fab fa-youtube"></i></a></li>
                <li><a data-tm-bg-color="#5376AC" class="social-link" href="#"><i class="fab fa-instagram"></i></a></li>
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

<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
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
    document.getElementById('time').innerHTML='当前时间：'+year+month+day+h+m+s  //显示当前时间
  }
</script>
</body>
</html>