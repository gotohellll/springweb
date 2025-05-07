package com.javaclass.service;

import com.javaclass.domain.MemberVO;

public interface MemberService {

	public void insertMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);	
}
