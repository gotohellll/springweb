package com.example.zexam.service;

import java.util.ArrayList;

import com.example.zexam.model.BookVO;
import com.example.zexam.model.EmpVO;
import com.example.zexam.model.NoticeVO;
import com.example.zexam.model.QnAVO;
import com.example.zexam.model.QuestionVO;

public interface ExamService {
	//공지사항
	ArrayList<NoticeVO> getNoticeList(NoticeVO vo);
	//QnA
	ArrayList<QnAVO> getQnAList(QnAVO vo);
	//저자문의
	ArrayList<QuestionVO> getQuestionList(QuestionVO vo);
	//책이미지
	ArrayList<BookVO> getBookList(BookVO vo);
	
	EmpVO loginCheck(EmpVO vo);
}
