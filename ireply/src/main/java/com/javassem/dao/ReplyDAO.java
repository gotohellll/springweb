package com.javassem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javassem.domain.ReplyVO;

@Mapper
public interface ReplyDAO {

	public Integer insertReply(ReplyVO vo); 
	public List<ReplyVO> selectAllReply(Integer bno);
	public int deleteReply(Integer rno);
	public Integer modifyReply(ReplyVO vo);
}
