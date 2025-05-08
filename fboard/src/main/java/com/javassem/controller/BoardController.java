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
	public void getBoardList(Model m, String searchCondition, String searchKeyword) {
		//getBoardList form태그에서 넘어오는 파라미터값 받기 -> 인자에 BoardVO를 쓰려면 변수로 잡혀있어야함 
		//외부적인 애들 : db와 관련없는 값은 따로 적는게 좋다 
		//콘솔창에서 값 잘 넘어오는지 확인
//		System.out.println("[searchCondition]"+searchCondition);
//		System.out.println("[searchKeyword]"+searchKeyword);
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		System.out.println(map.toString());
		
		/*
		 * 만일 제목을 선택하고 검색어입력에 'spring' 글자를 입력했다면 
		 * 		[key] 				[value]
		 * searchCondition			title
		 * searchKeyword			spring
		 * 
		 */
		
		
		List<BoardVO> result = boardService.getBoardList(map);
		//map 추가 -> 오류 -> 컨트롤클릭 implementation -> 인자 받기 
		//그 외 파일 getBoardList에 해당하는 함수에 전부 HashMap map 인자 처리
		//mapper에 parameterType 추가 
		m.addAttribute("boardList", result);
		
	}
	
	//화면만 출력하는 코딩 (db와 연결되지 않음) : 함수안에 코딩이없음 -> 이런 코딩이 반복되면 경로를 변수처리
//	@RequestMapping("insertBoard.do")
//	public void insertBoard() {
//		
//	}
	
	/*
	 	@RequestMapping("{step}.do") //step(변수명)
	  	public void viewpage(@PathVariable String step){ //반드시 void여야함
	  		//@PathVariable : 경로변수라고 알려주는 annotation ? , 없으면 String step을 parameter로 인식
			//System.out.println("step:"+step);
			//주의할 점 : step.do가 여러개 겹치면 안됨 
	  	}
	 */
	
	@RequestMapping("{step}.do") 
	public String viewpage(@PathVariable String step) { //String 으로 경로지정하는 경우도 있다 
		
		return "board/"+step; 
		//404error : 파일 [/WEB-INF/views/insertBoard.jsp]을(를) 찾을 수 없습니다.
		//http://localhost:8080/basic/board/insertBoard.do -> url을 직접 입력해 경로 지정해줘야함 
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
