<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png" />
<link rel="apple-touch-startup-image" href="images/apple-touch-startup-image-320x460.png" />
<title>首页</title>
<link rel="stylesheet" href="/resources/css/framework7.css">
<link rel="stylesheet" href="/resources/style.css">
<link type="text/css" rel="stylesheet" href="/resources/css/swipebox.css" />
</head>
<body id="mobile_wrap">

    <div class="statusbar-overlay"></div>

    <div class="panel-overlay"></div>

    <div class="panel panel-left panel-cover">
              <nav class="list-nav">
                <ul>
                  <li class="home-icon"><a href="/member/index" class="close-panel">首页</a></li>
                  <li class="about-icon"><a href="about.html" class="close-panel">个人信息</a></li>
                  <li class="features-icon"><a href="features.html" class="close-panel">修改信息</a></li>
                  <li class="blog-icon"><a href="blog.html" class="close-panel">工作日志</a></li>
                  <li class="logout-icon"><a href="/member/index" class="close-panel">取消绑定</a></li>
                </ul>
              </nav>  
    </div>

    <div class="views">
      <div class="view view-main">
        <div class="navbar">
          <div class="navbar-inner">
            <div class="left sliding"><div class="logo_title">天瑞集团</div></div>
            <div class="right menu_open_icon"><a href="#" data-panel="left" class="link icon-only open-panel"></a></div>
          </div>
        </div>
        <div class="pages navbar-through toolbar-through">
          <div data-page="index" class="page homepage">
            <div class="page-content">
                  <!-- Slider -->
                  <div class="swiper-container swiper-init" data-effect="coverflow" data-pagination=".swiper-pagination">
                    <div class="swiper-wrapper">
                      <div class="swiper-slide">
                          <span>TWO <br />部门</span>
                          <span class="subtitle">方便快捷</span>
                          <a href="/member/features" class="swiper_read_more">选择所属部门</a>
              	      </div>
                      <div class="swiper-slide">
                          <span>THREE <br /> 记录</span>
                          <span class="subtitle">随时随地</span>
                          <a href="/member/features" class="swiper_read_more">我的工作记录</a> 
                      </div>
                    </div>
                    <div class="swiper-pagination"></div>
                  </div>
            </div>
          </div>
        </div>
        <!-- Bottom Toolbar-->
        <div class="toolbar">
              <div class="toolbar-inner">
              <ul class="toolbar_icons icons_4row">
              <li><a href="#" data-popup=".popup-login" class="open-popup"><img src="/resources/images/icons/white/user.png" alt="" title="" /></a></li>
              <li><a href="/member/contact"><img src="/resources/images/icons/white/settings.png" alt="" title="" /></a></li>
              <li><a href="#" data-popup=".popup-social" class="open-popup"><img src="/resources/images/icons/white/heart.png" alt="" title="" /></a></li>
              </ul>
              </div>  
        </div>
        

      </div>
    </div>
    
    <!-- About Popup -->
    <div class="popup popup-login">
	    <div class="content-block">
	      <h4>登录</h4>
	            <div class="loginform">
	            <form id="LoginForm" method="post">
	            <label>用户名:</label>
	            <input type="text" name="Username" value="" class="form_input required" />
	           	<input type="text" value="${openid }">
	            <label>密码:</label>
	            <input type="password" name="Password" value="" class="form_input required" />
	            <input type="submit" name="submit" class="form_submit" id="submit" value="登录" />
	            </form>
	            </div>
	      <div class="close_popup_button_gray"><a href="#" class="close-popup">关闭</a></div>
	    </div>
    </div>
    <!-- Services Popup -->
    <div class="popup popup-social">
    <div class="content-block">
      <h4>Social Share</h4>
      <p>Share icons solution that allows you share and increase your social popularity.</p>
      <ul class="social_share">
      <li><a href="#"><img src="/resources/images/icons/white/twitter.png" alt="" title="" /></a></li>
      <li><a href="#"><img src="/resources/images/icons/white/facebook.png" alt="" title="" /></a></li>
      <li><a href="#"><img src="/resources/images/icons/white/googleplus.png" alt="" title="" /></a></li>
      <li><a href="#"><img src="/resources/images/icons/white/dribbble.png" alt="" title="" /></a></li>
      <li><a href="#"><img src="/resources/images/icons/white/linkedin.png" alt="" title="" /></a></li>
      <li><a href="#"><img src="/resources/images/icons/white/pinterest.png" alt="" title="" /></a></li>
      </ul>
      <div class="close_popup_button"><a href="#" class="close-popup">Close</a></div>
    </div>
    </div>
    
<script type="text/javascript" src="/resources/js/jquery-1.10.1.min.js"></script>
<script src="/resources/js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/js/framework7.min.js"></script>
<script type="text/javascript" src="/resources/js/my-app.js"></script>
<script type="text/javascript" src="/resources/js/jquery.swipebox.js"></script>
<script type="text/javascript" src="/resources/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="/resources/js/email.js"></script>
  </body>
</html>
