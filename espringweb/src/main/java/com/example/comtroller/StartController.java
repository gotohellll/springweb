package com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	@RequestMapping("start.do") //서버에서 start.do 라는 요청을 받으면 아래 함수를 호출
	public ModelAndView start() {
		System.out.println("start.do 요청을 받았음"); //콘솔창에뜨면 controller가 요청을 받았구나 확인 
		
		ModelAndView mv = new ModelAndView();
		//view 페이지 지정 /WEB-INF/views/ + hello + .jsp -> hello만 써도 인지함 
		//spring-context.xml파일에서 ViewResolver - prefix, suffix로 경로,파일확장자를 지정해줘서 이름만써도 가능해짐  
		mv.setViewName("hello"); //view페이지를 지정 , view페이지 이름 
		mv.addObject("dbvalue", "나중에진짜디비값");
		mv.addObject("login", "나중에사용자아이디"); //login변수에 "나중에사용자아이디" 값이 들어옴 
		
		return mv;
	}
}

/*
	@Controller -> @Service -> @Repository
	
	@Autowired
	
	---여기까지 스프링거
	
	[기타등등]
	@Data : 전체 인자를 받는 생성자 함수는 포함이 되어있지 않음 
	@AllArgsCont 사용하면 됨(지금단계에선 쓰지않음)  

*/