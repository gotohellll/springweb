package com.javassem.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

//@Controller
@RestController //ajax가 대표적일때 :  Controller + ResponseBody 합쳤다고 생각 : 이 컨트롤러의 모든 리턴값이 단순한 데이터값일때 사용
public class SampleController {
	
	//1. 문자열 반환
	@RequestMapping(value="getText", produces="text/plain; charset=UTF-8")
	// @ResponseBody -> RestController가 있다면 ResposeBody삭제 
	public String getText() {
		
		return "서버에서 보내는 데이터"; 
		//ResposeBody를 붙여 뷰페이지가 아닌 진짜 데이터로 인식하게 함 
	}
	
	//2. 객체 반환
	//일반 컨트롤러면 객체리턴 못한다 
	@RequestMapping("getObject")
	public SampleVO getObject() {
		SampleVO vo = new SampleVO("홍길동", 22, "오늘도 맛점");
		
		return vo; //json방식으로 리턴됨 (key-value)
	}
	
	//3. 리스트 반환
	@RequestMapping("getList")
	public ArrayList<SampleVO> getList() {
		ArrayList<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길동", 22, "meow"));
		list.add(new SampleVO("홍길자", 33, "meowmeow"));
		list.add(new SampleVO("홍길순", 44, "meowmeowmeow"));
		return list; //배열로 넘어간다
	}
	
	//4. url에서 정보받기
	@RequestMapping("sample/{cate}/{cno}") //sample/{cate}/{cno} 해당하는 경로가 들어오면 경로변수로 처리함  
	public String[] sample(@PathVariable String cate, @PathVariable String cno) { //요청명 받아서 변수처리 @PathVariable 추가(경로변수)
		System.out.println(cate+"/"+cno);
		
		return new String[] {"카테고리:"+ cate, "번호:"+cno};
	}
	
	@RequestMapping("sample2")
	public String[] sample2(@RequestParam String cate, @RequestParam String id) { //parameter명 동일하게
		
		return new String[] {"카테고리:"+ cate, "번호:"+id};
	}
	
	//5. 폼 전송 
	@RequestMapping("sample/data")
	public SampleVO sampleData(SampleVO vo) {
		
		return vo; //return되는 vo의 자료형 SampleVO 
	}
}
