package com.javassem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javassem.domain.BoardVO;

//BoardDAOImpl을사용하지않고 mapper로 바로 연결 -> mapper namespace 변경 com.javassem.dao.BoardDAO

@Mapper
public interface BoardDAO {
	public void insertBoard(BoardVO vo); 

	public void updateBoard(BoardVO vo) ;

	public void deleteBoard(BoardVO vo);

	public BoardVO getBoard(BoardVO vo) ;

	public List<BoardVO> getBoardList(BoardVO vo) ;
				//리턴값       매퍼아이디 		파라미터   ->함수명이 반드시 매퍼의 아이디 
}
