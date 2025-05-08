<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 1 -->
<a href='getText'>1. 문자열 반환</a>
<hr/>

<!-- 2 -->
<a href='getObject'>2. 객체 반환</a>
<hr/>

<!-- 3 -->
<a href='getList'> 3. 리스트 객체 반환</a>
<hr/>

<!-- 4 -->
<!-- 기존방식(parameter방식) : sample?cate=it&id=1001 -->
<a href='sample/it/1001'> 4. 쿼리스트링처리 </a><br/>
<a href='sample/novel/2001'> 4. 쿼리스트링처리 </a><br/>
<hr/>

<a href='sample2?cate=it&id=1001'> 4-2. 쿼리스트링처리 </a><br/>
<a href='sample2?cate=novel&id=2001'> 4-2. 쿼리스트링처리 </a><br/>
<hr/>


<!-- 5 -->
<form action='sample/data' method='post'>
	<input type='text' name='name'>
	<input type='text' name='age'>
	<input type='text' name='message'>
	<input type='submit' value='POST전송'>
</form>
</body>
</html>