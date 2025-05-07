package com.javaclass.repository;

import com.javaclass.domain.MemberVO;

public interface MemberDAO {
	public void insertMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
}
