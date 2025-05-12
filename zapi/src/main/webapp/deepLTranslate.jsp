<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lib 이용</title>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	$("#btn").click(function(){
		//alert("ok");
		
		var param = {content : $("#originText").val()}; //key: content , origintText textarea의 value값 
		
		$.ajax({
			type : 'get' //방식
			, data : param //보내는 데이터
			, url : 'api/translate'	//어디로 받을지 (url요청)
			, contentType : 'application/x-www-form-urlencoded;charset=UTF-8' //한글 깨지지않게 인코딩 
			, dataType : 'text' //보내는 데이터 타입 (기본값 text)
			, success : function(result){ //성공시 함수
				$('#translateResult').val(result); //받은 결과를 translateResult value값에 입력
			}
			, error : function(err){ //실패시 함수
				alert("번역실패");
				console.log(err);
			}
			
		});
		
	})
})


</script>
</head>
<body>

<h2>라이브러리 이용</h2>

<textarea id="originText" rows="5" cols="50"></textarea>
<input type="button" id="btn" value="번역(한국어->영어)">
<hr/>
<textarea id="translateResult" rows="5" cols="50"></textarea>

</body>
</html>