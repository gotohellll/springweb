package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		BoardVO result = mybatis.selectOne("BoardDAO.getBoard", vo);
		
//		System.out.println("[결과]"+result.toString());
		
		return result;
	}

	public List<BoardVO> getBoardList(HashMap map) {
		System.out.println("===> Mybatis getBoardList() 호출");
		//콘솔확인용
//		System.out.println(map.toString());
		
		List<BoardVO> result = mybatis.selectList("BoardDAO.getBoardList", map);
		//인자로 받았으면 넘겨주기
		
		//콘솔창 출력해서 db에서 값을 못가져왔는지, 오류발생지점 확인할것 
//		for(BoardVO temp:result) {
//			System.out.println(temp.toString());
//		}
		
		return result;
	}
}