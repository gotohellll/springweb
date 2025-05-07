<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paramForm.jsp</title>
</head>
<body>

<h1>폼의 데이터값을 출력</h1>

결과아이디 : ${memberVO.id}<br/>
결과이름  : ${memberVO.name}<br/>
결과나이  : ${memberVO.age}<br/>

<hr/><hr/>

세션값 : ${sessionScope.login}<br/>

</body>
</html>