package com.example.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.MemberVO;

@Controller
public class ModelValueController {
	
	@Autowired
	private MemberVO memberVO; //DI에 의해 null이 아님 
	
	@RequestMapping("modelValue.do")
	public ModelAndView modelValue() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modelValue"); //WEB-INF/views/ + modelValue + .jsp
		mv.addObject("vo", memberVO);
		
		return mv;
	}
}
