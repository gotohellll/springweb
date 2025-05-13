/**
 * 
 */
let time = 0;

$(function() {

	// (1) 오늘 날짜 출력
	let today = new Date();		//날짜 객체 생성

	//id가 date_wrap인 태그의 자식 중 연,월,일을 담당하는 클래스의 태그를 찾아서 text값을 지정
	$('#date_wrap > .year').text(today.getFullYear());
	$('#date_wrap > .month').text(today.getMonth() + 1);
	$('#date_wrap > .date').text(today.getDate());

	/*---------------------------------------------*/

	// (2) 포커스에 가면 '검색어를 입력하세요'가 안보이게 하고, 다시 포커스가 없으면 다시 출력
	let searchInputTag = $('#keyword');

	//포커스 될 때
	searchInputTag.on("focusin", function() {
		//포커스된 요소 자신의 background를 없앤다 (기존엔 이미지 있었음)
		$(this).css({
			background: "none"
		});
	});

	//포커스 해제 될 때
	searchInputTag.on("focusout", function() {
		$(this).css({
			// 이 js는 index.html에 속한 것으로 취급하여 이미지 상대경로는 index.html 기준으로 작성하여야 함.
			background: 'url("./resources/images/sch_guide.gif") no-repeat'
		});
	});

	/*---------------------------------------------*/

	// (3) 탭팬 구현

	// 각 탭에서 정확하게 이미지 구역에다가 이벤트를 지정한다.
	$('dt[class*="tab_btn"] img').on("click", function() {
		//탭을 모두 초기화하고 내용을 모두 숨긴다.
		closeAllTabPane();

		//해당하는 탭의 이미지 위치를 over 이미지 위치로 바꾼다
		let beforeImageSource = $(this).attr("src");
		let afterImageSource = beforeImageSource.replace("out", "over");

		$(this).attr("src", afterImageSource);

		//해당하는 내용만 보여준다. (이미지의 부모의 부모 태그의 다음 태그가 내용임)
		$(this).parent().parent().next().show();

	});

	// (4) 이미지 슬라이드 구현 (10점)
	$("#best_bg").bxSlider({
		minSlides: 4,
		maxSlides: 4,
		slideMargin: 10,
		slideWidth: 600,
		moveSlides: 1
	});

	// (5) [로그인]을 누르면 로그인 창이 보이고 [Close]를 누르면 다시 안 보임
	// css로 안보이는 곳으로 떨어져있었음... 

	// 로그인 이미지 버튼 클릭하면 500px 떨어져 있던 폼 가져옴
	$("li.login_wrap img").on("click", function() {
		$("#login_f").css({
			top: '30px'
		});
	});

	// Close 이미지 버튼 클릭하면 다시 위치 멀리 보냄
	$('p.login_close_btn img').on("click", function() {
		$("#login_f").css({
			top: '-500px'
		});
	});

	// (6) [전체메뉴]를 선택하면 전체메뉴가 보이고 [Close] 누르면 다시 안 보임
	// display none 처리 되어있음

	// 전체메뉴 버튼 클릭시 display 변경하여 보이게 하기
	$('p#total_btn').on("click", function() {
		$("#total_menu").css({
			display: "block"
		});
	});

	// CLOSE 버튼 클릭시 display none으로 변경하여 다시 안보이게 하기
	$('p#total_close').on("click", function() {
		$("#total_menu").css({
			display: "none"
		})
	});

	// (7-1) 프린트 버튼 누르면 프린트 창 띄우기
	$('a.print_btn').on("click", function() {
		window.print();
	});

	// (7-2) 알림판 슬라이더
	$('dt[class*="roll_btn"] img').on("click", function() {
		//탭을 모두 초기화하고 내용을 모두 숨긴다.
		closeAllButton();

		//해당하는 탭의 이미지 위치를 over 이미지 위치로 바꾼다
		let beforeImageSource = $(this).attr("src");
		let afterImageSource = beforeImageSource.replace("out", "over");

		$(this).attr("src", afterImageSource);

		//해당하는 내용만 보여준다. (이미지의 부모의 부모 태그의 다음 태그가 내용임)
		$(this).parent().parent().next().show();
		
		//현재 위치로 time 바꾸기
		let temp = $(this).parent().parent().attr("class");
		temp = parseInt(temp.charAt(temp.length-1))-1;
		time=temp;
	});


	// (7-3) 알림판 슬라이더 자동 변경
	// 2초마다 알림판의 다음 버튼을 클릭함.
	// 재생버튼과 정지버튼으로 정지재생 할 수 있게함
	// 기본은 자동 변경 되게끔 함
	let boardInterval = setInterval(startBoardInterval, 2000);
	$('.stopBtn').on("click",function(){
		clearInterval(boardInterval);
	});
	
	$('.playBtn').on("click",function(){
		boardInterval = setInterval(startBoardInterval, 2000);
	});
	
	//로그인창 입력칸 클릭시 이미지 사라짐 
	$('#user_id').focus(function(){
		$('img[alt="아이디"]').hide();
		
	});

	
	//로그인 작업
	$('.log_btn').click(function(e){
		e.preventDefault(); //서브밋막기 
		var param = {ename : $('#user_id').val()
				, empno : $('#user_pw').val()};
		
		$.ajax({
			type : 'post'
			, url : 'login.do'
			, data : param
			, dataType : 'json'
			, success : function(result){
				$('.login_wrap').hide(); //로그인 이미지 숨기기
				$('img[alt="회원가입"]').closest('li').hide(); //회원가입 이미지 숨기기
				//var login = $('.login_wrap');
				//var li = $('<li/>').text(result.ename+"님 로그인 중입니다")
				//login.append(li);
				$('#login_hide').text(result.ename+"님 로그인 중입니다").show();
			}
			, error : function(err){
				alert("로그인실패");
				console.log(err);
			}
		});
		
	});
});


// (3번문제용) 탭팬 전체 닫기, 버튼 전체 off 함수
let closeAllTabPane = function() {
	let dt = $('dt[class*="tab_btn"]');

	//dt각각 안의 img 태그를 찾아서 src를 해당 순서의 out 이미지로 변경
	dt.each(function(index) {
		$(this).find("img").attr("src", "resources/images/tab_btn_" + (index + 1) + "_out.gif");
	});

	//내용물을 숨긴다.
	dt.next().hide();
};

// (7-2번용) 전체 닫기, 버튼 전체 off 함수
let closeAllButton = function() {
	let dt = $('dt[class*="roll_btn"]');

	dt.each(function(index) {
		$(this).find("img").attr("src", "resources/images/pop_btn_" + (index + 1) + "_out.gif");
	});

	dt.next().hide();
}

// (7-3번용) 
let startBoardInterval = function() {
	time = (time + 1) % 4;
	//알림판 번호 버튼 클릭시킴
	$(`dt[class=roll_btn${time + 1}] img`).trigger("click");
};

