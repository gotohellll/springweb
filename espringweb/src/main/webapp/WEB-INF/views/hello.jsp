<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>

<h2>여기가 스프링 뷰 페이지입니다.</h2>


${dbvalue}이 전달되었습니다. <hr/>
${login}님이 로그인되었습니다.

<!-- 사용자는 컨트롤러를 통하지 않으면 절대 이 뷰 페이지에 접근할 수 없다. 어쩌다 접근하게 되더라도 데이터가 뜨지않음.
정상적인 루트를 타지 않으면 데이터를 전달받지 못함  -->

</body>
</html>