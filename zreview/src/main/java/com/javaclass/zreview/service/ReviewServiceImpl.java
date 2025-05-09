package com.javaclass.zreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.zreview.model.ReviewRepository;
import com.javaclass.zreview.model.vo.CateVO;
import com.javaclass.zreview.model.vo.FoodVO;

// [1]
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	// [2]
	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<CateVO> getCateList() {
		// [2-1]  레포지토리의 해당함수 호출하고 그 리턴값을 받아 다시 리턴한다
		
		
		return reviewRepository.getCateList();			
	}
	
	public List<FoodVO> getFoodList(CateVO cate) {
		// [2-2]  레포지토리의 해당함수 호출하고 그 리턴값을 받아 다시 리턴한다
		

		return reviewRepository.getFoodList(cate);		
	}
}
