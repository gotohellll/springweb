package com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberVO;

@Controller
@RequestMapping("/re")
public class RequestMappingController {
	
	/***************
	  [1] 스프링 컨트롤러에서 리턴값이 ModelAndView인 경우
	 		- ModelAndView에 view 페이지 지정
	 		- ModelAndView에 뷰페이지 보낼 데이터 추가
	 		
	 */
	
	
	/***************
	  [2] 스프링 컨트롤러에서 리턴값이 String인 경우
	   	=> 문자열 전송이 아님
	   
	   	=> ****** view 페이지 지정이다. 
	 */
//	@RequestMapping(value={"re/a.do", "re/b.do"})   
	@RequestMapping(value={"a.do", "b.do"})  //@RequestMapping("/re") 작성 시 re를 뺀 나머지만 받아줌 
	public String test() {
		System.out.println("re/a.do 요청과 re/b.do 요청을 받아 동일 작업");
		
		return "hello"; //뷰페이지명 지정하면 뷰페이지 리턴
	}
	
	/********************
	  [3] 스프링 컨트롤러에서 리턴값이 void인 경우 
	  		- 자동 뷰페이지 지정
	  		- 요청명과 동일한 뷰페이지 지정
	  		
	  		[요청명] re/c
	  		[뷰페이지명] WEB-INF/views/ + re/c + .jsp
	 */
	@RequestMapping(value="c.do")
	public void test2(String id) {
		
		System.out.println("re/c.do 요청 받음");
		System.out.println("이전화면에서 파라미터 : "+id);
	}
	//---------------------------
	// 이전화면에서 파라미터 받기 => 함수에 매개변수(인자)로 쓴다
	//---------------------------
	
	
	
	@RequestMapping("request.do")
	public void test3(MemberVO vo) {
		System.out.println("[컨트롤러영역]"+vo.toString());
	}
}
