<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_paramReview.jsp</title>
</head>
<body>

<a href='param.do?id=hong&age=20'>요청테스트1</a><br/>
<a href='paramtest.do?item=book&cate=it'>요청테스트2</a><br/><hr/>

<!-- name, submit 이 있어야 함  -->
<form action='paramForm.do'> 
아이디 : <input type='text' name='id'/><br/>
이름 : <input type='text' name='name'/><br/>
나이 : <input type='text' name='age'/><br/>
<input type='submit'/>
</form>

</body>
</html>