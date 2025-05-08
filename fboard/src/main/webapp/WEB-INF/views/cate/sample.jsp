<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 프로젝트명 변수 처리 : 프로젝트명 바뀔때 값만 수정--%>    
<% String pjName= "/fboard"; %>  

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/cate/sample.jsp</title>
</head>
<body>

<h1>cate/sample.jsp 뷰페이지</h1>
<!-- 프로젝트명을 변수처리해 실질적으로 운영시에 프로젝트명이 바뀌어 경로를 찾지 못하는것 방지 -->
<!-- <a href='/fboard/board/getBoardList.do'>게시판목록보기(절대경로)</a><hr> -->
<a href='<%=pjName%>/board/getBoardList.do'>게시판목록보기(절대경로)</a><hr>
<a href='../board/getBoardList.do'>게시판목록보기(상대경로)</a><hr>
</body>
</html>