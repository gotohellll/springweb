package com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("insert.do")
	public String insert() {
		System.out.println("실제로 메세지를 디비에 입력합니다");
		
		//return "select"; //입력 후 select화면 페이지 출력 -> 단순 뷰페이지만 지정한 경우
		//******************************
		// 스프링에서 리다이렉팅하려면 
		return "redirect:select.do"; //리다이렉트하면서 select.do를 요청 
		
		//단순 뷰페이지 지정과 리다이렉팅의 차이점 ** 
		//단순 뷰페이지 지정 -> url : insert.do
		//리다이렉팅 -> url : select.do 
	}
	
	@RequestMapping("select.do")
	public void select() {
		System.out.println("실제로 디비에서 메세지를 가져옵니다");
	}
}
