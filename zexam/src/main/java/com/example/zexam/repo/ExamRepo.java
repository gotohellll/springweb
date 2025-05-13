package com.example.zexam.repo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.zexam.model.BookVO;
import com.example.zexam.model.EmpVO;
import com.example.zexam.model.NoticeVO;
import com.example.zexam.model.QnAVO;
import com.example.zexam.model.QuestionVO;

@Mapper
public interface ExamRepo {
	public ArrayList<NoticeVO> getNoticeList();
	
	public ArrayList<QnAVO> getQnAList();
	
	public ArrayList<QuestionVO> getQuestionList();
	
	public ArrayList<BookVO> getBookList();
	
	public EmpVO loginCheck(EmpVO vo);
	
}
