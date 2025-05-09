$(function(){

	// 카테고리명을 클릭하면 해당 카테고리의 음식명을 검색한다. (ajax 이용 )
	$('.cate').click(function(){
		// 카테고리 번호 확인
		//alert($(this).val());
		
		
		/* 서버로 보낼 파라메터 데이타 지정
				: 한 개의 파라메터라도 서버에서  CateVO로 받을 예정
		let param = { CateVO 클래스 안에 멤버변수명 지정 : 보낼 데이타 };
		*/
		var param = {cate_no : $(this).val()};
		
		$.ajax({
			type : 'get'
			, url  : 'review2.do'
			, data : param
			// 처음에는 dataType 타입 지정 없이 ajax 확인한 후에 'json' 지정
			//, dataType : 'json'
			, success : selectByCate

		});
		
		
		
		function selectByCate(result){
			//alert('ok');
			//alert(result.length);
			$('#foodList').empty(); //화면비우기
			// 화면에 출력
			var list = $('#foodList');
			for (row of result) {
				var li = $('<li/>').text(row['food_name']);
				list.append(li);
			}
		}	
		
	});

});