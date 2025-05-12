<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>라이브러리 없이 API</title>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	$("#btn").click(function () {
		//alert("ok");
		//사용자로부터 받아와야하는 정보가 3가지 : 입력값, sourceLang, targetLang -> 모두 value값
		var param = {
				text: [$("#originText").val()] //글자가 여러개일것 : 배열 표시 
				, source_lang : $("#source_lang").val()
				, target_lang : $("#target_lang").val()
		}
		
		//console.log(param);//브라우저 콘솔에서 확인
		
		$.ajax({
			type : 'post'
			, data : JSON.stringify(param) //json형태로 보내게 함
			, contentType : 'application/json' //보낼때 json
			, url : 'api/translate2' //요청명
			, dataType : 'json' //받아오는 데이터타입
			, success : function(result){
				console.log(result.translations);
			}
			, error : function(err){
				alert("번역실패");
				console.log(err);
			}
		});
		
	})
})
</script>
</head>

<body>

<textarea id="originText" rows="5" cols="50"></textarea>
<hr/>
<select id="source_lang">
	<option value="KO">한국</option>
	<option value="EN">영어</option>
</select>
<input id="btn" type="button" value="번역"/>
<select id="target_lang">
	<option value="EN">영어</option>
	<option value="KO">한국</option>
</select>
<hr/>
<textarea id="translateResult" rows="5" cols="50"></textarea>

</body>
</html>