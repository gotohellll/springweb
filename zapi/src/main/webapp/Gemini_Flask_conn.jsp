<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gemini_Flask_conn</title>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	$("#btn").click(function () {
		//alert("ok");
		
		var param = {question : $("#questionText").val()}
		
		console.log(param);
		
		$.ajax({
			type : 'get'
			, data : param
			, url : 'http://127.0.0.1:5000' //pycham url
			, contentType : 'application/x-www-form-urlencoded;charset=UTF-8' //한글인코딩
			, dataType : 'text' //안써도 기본값 text
			, success : function(result){
				$("#answerText").text(result); //div태그 사이에 result 출력 
			}
			, error : function(err){
				alert("에러");
				console.log(err);
			}
		});
		//서버가 2개 : pycham flask서버 , tomcat 서버 
	})
});

</script>

</head>
<body>

<h2>세상에서 제일 간단한 챗봇</h2>

<textarea id="questionText" rows="5" cols="50"></textarea>
<button id='btn'>질문보내기</button>
<hr/>
<div id="answerText"></div>

</body>
</html>