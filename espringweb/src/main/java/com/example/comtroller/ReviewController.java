package com.example.comtroller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {
	
	/*
	 *  1. ModelAndView 객체를 리턴하는 경우
	 *  	-> 뷰페이지 지정과 데이터전송
	 */
	
	@RequestMapping("review/modelandview.do")
	public ModelAndView test1() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/modelandview");
		//뷰페이지로 보내는 데이터 
		mv.addObject("myData", "나중에 디비에서 중요한 데이터"); //변수명, 값 
		mv.addObject("serverTime",new Date().toString());
		
		return mv;
	}
	
	
	/*
	 * 2. void 리턴
	 * 		-> 요청명(request경로)와 동일한 뷰페이지 지정
	 * 		-> 뷰페이지로 데이터 전송은 무조건 Model 객체 이용해 보냄  
	 */
	@RequestMapping("review/void.do")
	public void test2(Model m) {
		//위의 경우 여기서 객체를 생성해 그 객체를 return
		//return이 void인 경우(건드리지못함) => 인자에 Model 입력(보통 인자를 받는다고 생각하지만 스프링에서는 보낸다)
		m.addAttribute("myData", "나중에 디비에서 중요한 데이터");
		m.addAttribute("serverTime",new Date().toString());
		
	}
	
	/*
	 * 3. 문자열 리턴인 경우 
	 * 		-> 뷰페이지 지정
	 * 		-> 뷰페이지로 데이터 전송은 무조건 Model 객체 이용해 보냄  
	 */
	
	@RequestMapping("review/string.do")
	public String test3(Model m) {
		
		m.addAttribute("testData", "디비에서 중요한 데이터");
		m.addAttribute("message", "오늘도 우리팀 화이팅");
		
		return "review/string"; //값이아닌 뷰페이지 지정
	}
}
