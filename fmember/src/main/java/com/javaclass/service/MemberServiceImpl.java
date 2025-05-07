package com.javaclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.domain.MemberVO;
import com.javaclass.repository.MemberDAO;

//### (1) 해당 어노테이션 지정
@Service
public class MemberServiceImpl implements MemberService{

	// ### (2) 해당 어노테이션 지정
	@Autowired
	private MemberDAO memberDAOImpl;
	
	public void insertMember(MemberVO vo) {
		memberDAOImpl.insertMember(vo);
	}
	
	public MemberVO loginCheck(MemberVO vo) {
		return memberDAOImpl.loginCheck(vo);
	}
	
}
