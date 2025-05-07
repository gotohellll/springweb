package com.example.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberVO;

@Controller
public class ParameterController {

	@RequestMapping("param.do")
	public void param(String id, Integer age) { //void : 뷰페이지를 자동으로 잡음 
		//파라미터가 넘어올때 컨트롤러에서 인자에만 설정해주면 받을 수 있다 
		//int를 넣으면 null값일때 멈춤, Integer 객체라서 null값도 처리
		
		//콘솔확인용
		System.out.println("서버까지 파라메터 받음");
		System.out.println("아이디:"+id);
		System.out.println("나이:"+age);
		
		//parameter는 Model에 받지않음 -> 리퀘스트가 끊어지지않음(포워딩처리)
		//리턴값이 없더라도 받은 파라미터가 컨트롤러를 타고 뷰페이지로 넘어간다 
		
	}
	
	@RequestMapping("paramtest.do")
	public void paramtest(String item, String cate) {
		
	}
	
	@RequestMapping("paramForm.do")
	public void paramForm(MemberVO vo, HttpSession session) { //폼 입력값을 한번에 처리 가능 
		System.out.println("폼의 입력값을 서버에서 확인 : "+vo.toString());
		
		/**********************
		 *  스프링에서 세션을 처리 => 인자에 HttpSession 변수만 선언 
		 */
		//가짜 db값
		Integer dbid = 1004;
		String dbname = "홍길동";
		//Integer끼리의 비교도 equals사용 ***
		if(dbid.equals(vo.getId()) && dbname.equals(vo.getName())) {
			System.out.println("로그인확인");
			//id와 pw가 동일하면 session에 저장하고 문장출력 
			session.setAttribute("login", dbid+"님 로그인");
		}
		
		
	}
}
