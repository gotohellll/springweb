
$(function(){

	//댓글 추가 버튼이 눌렸을 때 - 전송방식 post
	$('#replyConfirm').click(function(){
		//alert("ok");
		
//		var params = {
//			bno : $('#bno').val()
//			, replyer : $('#replyer').val()
//			, reply : $('#reply').val() 
//		}
//		
		
		var params = $('#replyFrm').serialize();
		
//		console.log(params);
		
		$.ajax({
			type : 'post'
			, url : '../replies/new'
			, data : params
			, success : function(result){
				//alert('댓글입력성공'+result);
				$('#reply').val(''); //입력 후 입력칸 비우기 
				replyList(); //입력성공했을때 댓글목록가져오기 함수 호출
			}
			, error : function(err){
				alert('댓글입력실패');
				console.log(err);
			}
		}); //end of ajax
	}); //end of click replyConfirm
	
	//댓글목록 가져오기 -전송방식 get
	replyList(); //처음부터 댓글목록이 뜨도록 처음에 한번 호출
	
	function replyList() {
		
		$.ajax({
			type : 'get'
			, url : '../replies'
			, data : {bno : $('#bno').val()} //가지고갈 데이터 - 원본 글번호
			, dataType : 'json' //받았을때 데이터타입
			, success : function(result){
				//alert('성공');
				//console.log(result);
				var replyList = $('#replyList');
				
				replyList.empty(); //비워야 중복으로 안뜸
				
				for (row of result) {
					//console.log(row);
					var tr = $('<tr/>'); //tr태그 객체를 만들어서 tr 변수에 담는것  
					//var tr = $('tr'); //화면에 있는 tr을 찾아 변수에 담는것
					var rno = $('<td/>').html(row['rno']); //태그와 태그사이에 값 입력 : text or html 사용
					var replyer = $('<td/>').html(row['replyer']);
					var reply = $('<td/>').html(row['reply']);
					var replydate = $('<td/>').html(row['replydate']);
					
					tr.append(rno); //tr태그에 rno 붙임 
					tr.append(replyer);
					tr.append(reply);
					tr.append(replydate);
					
					//수정버튼과 삭제버튼 추가
					tr.append('<td><button class="modify">수정</button></td>');
					tr.append('<td><button class="delete">삭제</button></td>');
					
					replyList.append(tr);//replyList태그에 tr붙임 
					
					
				}
			}
			, error : function(err){
				alert('검색실패');
				console.log(err);
			}
		});//end of ajax
		
	}//end of function replyList
	
	//동적 '삭제'버튼 이벤트 클릭시 -전송방식 delete
	$('#replyList').on('click','.delete', function(){
		//alert('ok');
		var rno = $(this).closest('tr').find('td:first').text(); //closest or parents 
		//alert(rno); //클릭한 댓글번호가져오는지확인
		
		$.ajax({
			type : 'delete'
			, url : `../replies/${rno}` //or '../replise'+rno
			, success : function(result){
				replyList(); //삭제한 이후에 목록보기 다시 부르기 : 화면에서도 삭제한 행이 사라지게 
			}
			, error : function(err){
				alert("삭제실패");
				console.log(err);
			}
		}); //end of ajax
	});//end of click delete
	
	//동적 '수정'버튼 이벤트 클릭시
	$('#replyList').on('click','.modify',function(){
		var btn = $(this);
		
		if(btn.text() == '수정') {
			//댓글작성자 부분
			var replyertd = btn.closest('tr').find('td:eq(1)'); //td태그
			var replyertdText = replyertd.text(); //td태그 사이 글자
			
			replyertd.text('');
			replyertd.append('<input type="text" name="replyer" value="'+replyertdText+'">');
			
			//댓글부분
			var replytd = btn.closest('tr').find('td:eq(2)');
			var replytdText = replytd.text();
			
			replytd.text('');
			replytd.append('<input type="text" name="reply" value="'+replytdText+'">');
			
			btn.text('수정하기'); //버튼이 수정이면 수정하기로 바뀜 
		}else if (btn.text() == '수정하기') {
			var rno = btn.closest('tr').find('td:eq(0)').text()
			
			var param = {
				rno : rno
				, replyer : btn.closest('tr').find('td:eq(1)').children().val() //위에서 td하나를 더붙여서 children, 입력값이라 val()
				, reply : btn.closest('tr').find('td:eq(2)').children().val()
						//btn.parents('tr').find('input').eq(1).val()
			}
			
			console.log(param);
			
			//서버에서 수정 (전송방식 put안되면 post)
			$.ajax({
				type : 'post'
				, url : `../replies/${rno}`
				, data : param
				, success : function(result){
					replyList(); //삭제한 이후에 목록보기 다시 부르기 : 화면에서도 삭제한 행이 사라지게 
				}
				, error : function(err){
					alert("수정실패");
					console.log(err);
				}
			});//end of ajax
			
			btn.text('수정'); //수정하기 -> 수정으로 변경 
		}
		
	});//end of click modify

}); 