<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ########################### -->
<!-- [1] JSTL core 라이브러리 설정 		 -->
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 연습은 꼼꼼하게 </title>

<!-- ========================================  -->
<!-- [3] CSS 적용 -->
<link rel="stylesheet" href="resources/css/review.css" />

<!-- [4] JS /Jquery 적용 : slim 버전은 ajax 함수 안됨 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src='resources/js/review.js'></script>

</head>
<body>

<table border="1">
		<tr>	
			<td>[ 종류 선택 ]</td><td>[ 메뉴 선택 ] </td>
		</tr>
		<tr>	
			<td>
				<ul>
					<!-- ################################ -->
					<!-- [2] 카테고리 내용을 출력  -->
					<li><label><input type="radio" class="cate" name="category" value="1">분식</label></li>
					<li><label><input type="radio" class="cate" name="category" value="2">한식</label></li>
					
				</ul> 
			</td> 

			<td>
				<ul id='foodList'>				
				</ul>	
			</td>
		</tr>	
		</table>
</body>
</html>