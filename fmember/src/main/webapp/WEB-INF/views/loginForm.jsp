<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 로그인 </title>
</head>
<body>

<h2>로그인</h2>
<form name="frm" id='frm' method="post" action="login.do" >
		<label for="id">아이디</label>
		<input type="text" id="id" name="userid" required> 
		<br>
		<label for="password">비밀번호</label>
		<input type='password' id="password"  name="userpass" maxlength="10">
		<br>
	<input type="submit" value="로그인"> 

</form>
</body>
</html>