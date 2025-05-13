<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="google-translate-customization" content="6f1073ba568f1202-9c8990a4b3025b3e-ga74e3ea243d3f01d-14"></meta> <!-- 세계 언어선택 메타 태그 -->
<title> 이지스퍼블리싱 </title>
<link rel="stylesheet" type="text/css" href="resources/css/base.css" media="all" />
<link rel="stylesheet" type="text/css" href="resources/css/main.css" media="all" />

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script><!-- 제이쿼리 라이이브러리 연동 -->

<script src="https://cdn.jsdelivr.net/npm/bxslider@4.2.17/dist/jquery.bxslider.min.js"></script>
<!-- bxSlider 플러그인 연동 -->
<script type="text/javascript" src="resources/libs/jquery-ui-1.10.4.custom.min.js"></script> <!-- UI 플러그인 연동 -->
<script type="text/javascript" src="resources/libs/jquery.cookie.js"></script>  <!-- 쿠키 플러그인 연동 -->

<!-- 우리가 작성할 자바스크립트 파일  -->
<script type="text/javascript" src="resources/js/exam.js"></script> 

</head>
<body>
<div id="wrap">
<dl class="hide">
 <dt>스킵메뉴</dt>
 <dd><a href="#container">본문바로가기</a></dd>
</dl>
<div id="header">
  <h1><a href="#"><img src="resources/images/logo.gif" alt="이지스 퍼블리싱" /></a></h1>
  <dl id="util_menu">
     <dt class="hide">유틸메뉴</dt>
     <dd class="util_first">
        <ul>
        <li>
        	<p id="login_hide" style="display : none;"></p>
        </li>
           <li class="login_wrap">
           <a href="#">
           <img src="resources/images/util_menu_1.gif" alt="로그인" />
           </a>
             <!-- #######				로그인 폼			 ########-->
             <form action="#" method="post" name="log_f" id="login_f">
               <fieldset>
                 <legend>로그인</legend>
                 <p class="user_id">
                    <label for="user_id">
                      <img src="resources/images/login_title_id.gif" alt="아이디" />
                    </label>
                    <input type="text" name="user_id" id="user_id" />
                 </p>
                 <p class="user_pw">
                    <label for="user_pw">
                      <img src="resources/images/login_title_pw.gif" alt="아이디" />
                    </label>
                    <input type="password" name="user_pw" id="user_pw" /></p>
                 <p>
                    <input type="checkbox" name="save_id" id="save_id" />
                    <label for="save_id"> 비밀번호 저장</label>
                 </p>
                 <p class="log_btn">
                    <input type="image" src="resources/images/login_btn.gif" alt="로그인버튼" />
                 </p>
                 <p class="join_btn_wrap">
                     <a href="#">회원가입</a>
                     <a href="#" class="sch_id_btn">아이이디/비밀번호 찾기</a>
                 </p>
                 <p class="login_close_btn">
                     <a href="#">
                     <img src="resources/images/login_close_btn.gif" alt="닫기버튼" />
                     </a>
                 </p>
               </fieldset>
             </form>
           </li>
           <li>
            <a href="#"><img src="resources/images/util_menu_2.gif" alt="회원가입" /></a>
           </li>
           <li>
            <a href="#"><img src="resources/images/util_menu_3.gif" alt="도서목록" /></a>
           </li>
           <li>
            <a href="#"><img src="resources/images/util_menu_4.gif" alt="원고지원" /></a>
           </li>
           <li>
            <a href="#"><img src="resources/images/util_menu_5.gif" alt="사이트맵" /></a>
           </li>
        </ul>
     </dd>
     <dd>
        <ul id="zoom">
           <li><img src="resources/images/util_zoom_1.gif" alt="" /></li>
           <li>
            <a href="#" class="zoom_in"><img src="resources/images/util_zoom_2.gif" alt="" /></a>
           </li>
           <li>
            <a href="#" class="zoom_return"><img src="resources/images/util_zoom_3.gif" alt="" /></a>
           </li>
           <li>
            <a href="#" class="zoom_out"><img src="resources/images/util_zoom_4.gif" alt="" /></a>
           </li>
        </ul>
     </dd>
     <dd>
      <a href="#" class="print_btn">
        <img src="resources/images/util_print.gif" alt="" />
      </a>
     </dd>
     <dd>
        <div id="google_translate_element"></div>
     </dd>
  </dl>
  <form action="#" method="get" name="sch_f" id="sch_f">
     <fieldset>
        <legend>검색폼</legend>
        <p>
           <input type="text" name="keyword" id="keyword" title="검색어입력" />
           <input type="image" src="resources/images/header_sch_btn.gif" alt="검색" />
        </p>
     </fieldset>
  </form>
  
  <!--  ########				전체 메뉴					########  -->
  <p id="total_btn">
      <a href="#">
        <img src="resources/images/allmenu_btn_out.gif" alt="전체메뉴" />
      </a>
  </p>
  <div id="total_menu">
     <dl>
        <dt><img src="resources/images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">홈으로이동</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="resources/images/allmenu_title_2.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">회사소개</a></li>
              <li><a href="#">출간분야</a></li>
              <li><a href="#">찾아오시는 길</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="resources/images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">신간도서</a></li>
              <li><a href="#">인기도서</a></li>
              <li><a href="#">추천도서</a></li>
           </ul>
        </dd>
     </dl>
     <dl>
        <dt><img src="resources/images/allmenu_title_1.gif" alt="홈" /></dt>
        <dd>
           <ul>
              <li><a href="#">고객문의</a></li>
              <li><a href="#">저자문의</a></li>
              <li><a href="#">자료요청</a></li>
              <li><a href="#">자주묻는 질문</a></li>
           </ul>
        </dd>
     </dl>
     <p id="total_close">
        <a href="#">
            <img src="resources/images/allmenu_close_btn.gif" alt="전체메뉴 닫기" />
        </a>
     </p>
  </div>
  
  
  
  <!-- #######				날짜 출력			 ########-->
  <p id="date_wrap">
      <span class="year">0000</span> 년
      <span class="month">00</span> 월
      <span class="date">00</span>일
   </p>
</div>
<hr />

<hr />
<div id="container">
 <div id="contents_top">
   <div id="roll_banner_wrap">
     <h3><img src="resources/images/pop_title.gif" alt="알림판" /></h3>
     <dl>
       <dt class="roll_btn1">
         <a href="#" class="active">
         <img src="resources/images/pop_btn_1_over.gif" alt="버튼1" />
         </a>
       </dt>
       <dd>
          <a href="#"><img src="resources/images/pop_banner_1.gif" alt="배너1" /></a>
       </dd>
       <dt class="roll_btn2">
          <a href="#"><img src="resources/images/pop_btn_2_out.gif" alt="버튼2" /></a>
       </dt>
       <dd>
          <a href="#"><img src="resources/images/pop_banner_2.gif" alt="배너2" /></a>
       </dd>
       <dt class="roll_btn3">
          <a href="#"><img src="resources/images/pop_btn_3_out.gif" alt="버튼3" /></a>
       </dt>
       <dd>
          <a href="#"><img src="resources/images/pop_banner_3.gif" alt="배너3" /></a>
       </dd>
       <dt class="roll_btn4">
          <a href="#"><img src="resources/images/pop_btn_4_out.gif" alt="버튼4" /></a>
       </dt>
       <dd>
          <a href="#"><img src="resources/images/pop_banner_4.gif" alt="배너4" /></a>
       </dd>
     </dl>
     <p class="ctl_btn">
       <a href="#" class="playBtn">
        <img src="resources/images/pop_btn_play_on.gif" alt="재생버튼" />
       </a> 
       <a href="#" class="stopBtn">
        <img src="resources/images/pop_btn_stop_off.gif" alt="정지버튼" />
       </a>
     </p>
   </div>
   
   <!--  ########## 		탭메뉴		##########  -->
   <dl id="tabmenu">
     <dt class="tab_btn1">
        <a href="#"><img src="resources/images/tab_btn_1_over.gif" alt="공지사항" /></a>
     </dt>
     <dd>
       <ul>
       	 <c:forEach var='notice' items='${noticeList}'>
       	 	<li>
       	 		${notice.notice_no}<a href="#">  ${notice.notice_title}</a><span>${notice.notice_date}</span>
       	 	</li>
       	 </c:forEach>
       </ul>
       <p>
          <a href="#"><img src="resources/images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
     <dt class="tab_btn2">
        <a href="#"><img src="resources/images/tab_btn_2_out.gif" alt="질문과답변" /></a>
     </dt>
     <dd>
       <ul>
         <li>
       	 <c:forEach var='qna' items='${qnaList}'>
       	 	<li>
       	 		${qna.qna_no}<a href="#">  ${qna.qna_title}</a><span>${qna.qna_date}</span>
       	 	</li>
       	 </c:forEach>
       </ul>
       <p>
          <a href="#"><img src="resources/images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
     <dt class="tab_btn3">
      <a href="#"><img src="resources/images/tab_btn_3_out.gif" alt="저자문의" /></a>
     </dt>
     <dd>
       <ul>
       	 <c:forEach var='question' items='${questList}'>
       	 	<li>
       	 		${question.question_no}<a href="#">  ${question.question_title}</a><span>${question.question_date}</span>
       	 	</li>
       	 </c:forEach>
       </ul>
       <p>
        <a href="#"><img src="resources/images/tab_more_btn.gif" alt="더보기" /></a>
       </p>
     </dd>
   </dl>
   <ul id="consult_wrap">
     <li>
      <img src="resources/images/banner_consult.gif" alt="출판상담문의 02-3235-1722" />
     </li>
     <li>
     <img src="resources/images/banner_support.gif" alt="원고 양식 다운받기 및 지원 easy@easypub.co.kr" usemap="#support" />
       <map name="support" id="support">
         <area shape="rect" coords="9,29,126,53" href="#" alt="원고 양식 다운 받기" />
       </map>
     </li>
   </ul>
 </div>
 
 <!-- ###########		베스트북  슬라이더 	#############  -->
 <div id="bestbook_zone">
   <h3>
      <img src="resources/images/bestbook_title.gif" alt="이지스퍼블리싱 베스트 책" />
   </h3>
   <div id="best_bg">
   		<c:forEach var="book" items="${bookList}">
   			<div>${book.book_title}<a href="#"><img src="resources/images/${book.book_images}" alt="" /></a></div>
   		</c:forEach>  
   </div>
 </div> <!-- close of bestbook_zone -->
 


</div> <!-- close of container -->
</div> <!-- close of wrap -->
<hr />

</body>
</html>