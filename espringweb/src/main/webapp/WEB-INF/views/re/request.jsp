<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>re/request.jsp</title>
</head>
<body>

<h2>re/request.jsp 결과 뷰페이지</h2>
<!-- 무조건 파라미터값 출력 -->
아이디: ${param.id} <br/>
이름: ${param.name} <br/>
나이: ${param.age} <br/>

<hr/><hr/>
<!-- 컨트롤러에서 설정한 인자의 타입(첫글자 소문자)을 객체로 받아서 출력  -->
아이디: ${memberVO.id} <br/>
이름: ${memberVO.name} <br/>
나이: ${memberVO.age} <br/>

<hr/>

</body>
</html>