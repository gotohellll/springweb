package com.example.zexam.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zexam.model.BookVO;
import com.example.zexam.model.EmpVO;
import com.example.zexam.model.NoticeVO;
import com.example.zexam.model.QnAVO;
import com.example.zexam.model.QuestionVO;
import com.example.zexam.repo.ExamRepo;

@Service("examService")
public class ExamServiceImpl implements ExamService{
	@Autowired
	private ExamRepo examRepo;

	@Override
	public ArrayList<NoticeVO> getNoticeList(NoticeVO vo) {
		
		return examRepo.getNoticeList(vo);
	}

	@Override
	public ArrayList<QnAVO> getQnAList(QnAVO vo) {
		
		return examRepo.getQnAList(vo);
	}

	@Override
	public ArrayList<QuestionVO> getQuestionList(QuestionVO vo) {
		
		return examRepo.getQuestionList(vo);
	}

	@Override
	public ArrayList<BookVO> getBookList(BookVO vo) {
		
		return examRepo.getBookList(vo);
	}
	
	public EmpVO loginCheck(EmpVO vo) {
		return examRepo.loginCheck(vo);
	}
	
	
	
	
}
