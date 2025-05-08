package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyService;

//***************** 값만 보내는 컨트롤러
@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService replyService = null;
	
	//댓글입력
	@PostMapping("replies/new")
	public String insert(ReplyVO rvo) {
		//서버까지 데이터 보내는지 확인 
		System.out.println("[replies/new]"+rvo.toString());
		
		Integer result = replyService.insertReply(rvo);
		if(result == 1) return "ok";
		else return "fail";
	}
	
	//댓글전체목록보기
	@GetMapping("replies")
	public List<ReplyVO> list(Integer bno) {
		System.out.println("답글전체검색"+bno);
		
		List<ReplyVO> result = replyService.selectAllReply(bno);
		//List util import
		return result;
	}
	
	//댓글삭제
	@DeleteMapping("replies/{rno}") //rno를 변수잡아 처리
	public void delete(@PathVariable Integer rno) { //PathVariable : 경로로 넘어오는 애를 변수에 담음 (일반파라미터변수가아님)
		System.out.println("삭제할댓글번호:"+rno);
		replyService.deleteReply(rno);
	}
	
	//댓글수정
	@PostMapping("replies/{rno}")
	public void modify(@PathVariable Integer rno, ReplyVO vo) { //rno는 경로설정, vo는 값을 받아오는것
		System.out.println("[수정할 데이터]"+vo.toString());
		
		replyService.modifyReply(vo);
	}
	
}
