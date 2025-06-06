package com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberVO;
import com.example.model.MemberVOList;

@Controller
public class MultiInsertController {
	
	//전송버튼 눌렸을때 
	@RequestMapping("multiInsert.do")
	public String multiInsert(MemberVOList mList) { //시작페이지에 있는 모든 데이터가 MemberVOList mList로 들어감 (스프링쓰는이유)
		System.out.println("---[ 컨트롤러 ]---");
		for( MemberVO vo : mList.getList()) {
			System.out.println(vo.toString());
		}
		
		return "listResult";
	}
}
