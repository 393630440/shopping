<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="pages">
  <div data-page="projects" class="page no-toolbar no-navbar">
    <div class="page-content">
    
     <div class="navbarpages">
       <div class="navbar_home_link"><a href="/member/index"><img src="/resources/images/icons/white/home.png" alt="" title="" /></a></div>
       <div class="navbar_page_center">Contact</div>
       <div class="menu_open_icon_white"><a href="#" class="open-panel"><img src="/resources/images/menu_open.png" alt="" title="" /></a></div>
     </div>
     <div id="pages_maincontent">
      
      <h2 class="page_subtitle">Get in touch</h2>

            <h2 id="Note"></h2>
            <div class="contactform">
            <form class="cmxform" id="ContactForm" method="post" action="">
            <label>Name:</label>
            <input type="text" name="ContactName" id="ContactName" value="" class="form_input required" />
            <label>Email:</label>
            <input type="text" name="ContactEmail" id="ContactEmail" value="" class="form_input required email" />
            <label>Message:</label>
            <textarea name="ContactComment" id="ContactComment" class="form_textarea textarea required" rows="" cols=""></textarea>
            <input type="submit" name="submit" class="form_submit" id="submit" value="Send" />
            <input class="" type="hidden" name="to"  value="youremail@yourwebsite.com" />
            <input class="" type="hidden" name="subject" value="Contacf form message" />
            <label id="loader" style="display:none;"><img src="/resources/images/loader.gif" alt="Loading..." id="LoadingGraphic" /></label>
            </form>
            </div>
            
      <h3>Our Location</h3>
      
      
      <div class="call_button"><a href="">Call Us Now!</a></div>    
      
      <div class="clear"></div>
      </div>
      
      
    </div>
  </div>
</div>
