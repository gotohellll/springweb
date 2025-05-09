package com.javaclass.zreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.zreview.model.vo.CateVO;
import com.javaclass.zreview.model.vo.FoodVO;
import com.javaclass.zreview.service.ReviewService;

// [1]
@Controller
public class ReviewController {

	// [2]
	@Autowired
	private ReviewService reviewService;
	
	// [3]
	@RequestMapping("review.do")
	public String review(Model m) {
		// ------------------------------------------------
		// [3-1] 카테고리 목록을 얻어오는 서비스단의 함수를 호출하여 넘겨받은 데이타를 
		//		 뷰페이지로 데이타를 전송하는 Model객체에 속성으로 추가
		
		List<CateVO> list = reviewService.getCateList();
		m.addAttribute("cateList",list);
		
		
		// [3-2] 뷰페이지 지정
		return "Review";
	}
	
	
	// [4]
	// [5]
	@RequestMapping("review2.do")
	@ResponseBody
	public List<FoodVO> foodByCate(CateVO cate) {
		//System.out.println("[ReviewController] ajax로 넘어오는 카테고리 번호: " + cate.toString());
		
		//System.out.println(cate.toString());
		// ----------------------------------------
		// [4-1] 해당 카테고리의 음식 목록을 얻어오는 서비스단의 함수를 호출하여 데이타를 넘겨받음
		
		
		
		// [4-2] 위의 넘겨받은 데이타를 리턴함
		return reviewService.getFoodList(cate);
	}
}
