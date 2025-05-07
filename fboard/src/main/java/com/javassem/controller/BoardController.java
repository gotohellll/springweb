package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService = null;
	
	@RequestMapping("getBoardList.do") //("board/getBoardList.do") 
	public void getBoardList(Model m) {
		List<BoardVO> result = boardService.getBoardList();
		m.addAttribute("boardList", result);
		
	}
	
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}
	
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO vo) {
		System.out.println("입력값 확인:"+vo.toString());
		
		//서비스로 넘겨받은 vo를 넘김 -> db입력됨 
		boardService.insertBoard(vo);
		
		//return "getBoardList"; //단순 뷰페이지 지정
		return "redirect:getBoardList.do";//리다이렉트
	}

	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO vo, Model m) {
		BoardVO result = boardService.getBoard(vo); //vo를가져와 결과를 담음 ?
		
		m.addAttribute("board", result); //getBoard.jsp의 변수명과 동일하게 board 
		//db에서 값을 받아와서 뷰페이지(getBoard.jsp)에 보여줘야해서 Model사용 
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("수정할 항목 확인:"+vo.toString());
		//BoardVO result = boardService.updateBoard(vo);
		boardService.updateBoard(vo);
		
		return "redirect:getBoard.do?seq="+vo.getSeq(); //직접 url지정 
	}

}
