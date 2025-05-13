package com.example.zexam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.zexam.model.BookVO;
import com.example.zexam.model.EmpVO;
import com.example.zexam.model.NoticeVO;
import com.example.zexam.model.QnAVO;
import com.example.zexam.model.QuestionVO;
import com.example.zexam.service.ExamService;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService = null;
	
	@RequestMapping("index")
	public void index(Model m) {
		
		//NoticeVO vo, QnAVO vo2, QuestionVO vo3, BookVO vo4,  
		// 추후에는 디비 연결 지금은 공지사함 가짜 데이타
//		ArrayList<NoticeVO> noticeList = new ArrayList<NoticeVO>();
//		for(int i=0; i<5; i++) {
//			NoticeVO vo = new NoticeVO(i+1,"공지사항"+i,"공지사항내용"+i,"2025-05-0"+i);
//			noticeList.add(vo);
//		}
//		// 뷰페이지로 데이타 전송 여기서 공지사항 qna 저자문의 책정보 이미지
//		m.addAttribute("noticeList",noticeList);
		
		//공지사항
		m.addAttribute("noticeList", examService.getNoticeList());
		
		//QnA
		m.addAttribute("qnaList", examService.getQnAList());
		
		//저자
		m.addAttribute("questList", examService.getQuestionList());
		
		//책이미지
		m.addAttribute("bookList", examService.getBookList());
		
		
	}
	
	@PostMapping("login.do")
	@ResponseBody
	public EmpVO loginCheck(String ename,
							 Integer empno, 
							HttpSession sess) {
		
		//로그인
		EmpVO vo = new EmpVO(empno, ename); //인자에 EmpVO vo 넣고 vo로 받아도됨 
		
		EmpVO result = examService.loginCheck(vo);
		
		if (result != null) {		
			sess.setAttribute("logname", result.getEname());
			
			System.out.println(result.toString());
		}
		return result;
	}
}
