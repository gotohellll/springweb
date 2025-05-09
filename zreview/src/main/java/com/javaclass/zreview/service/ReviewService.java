package com.javaclass.zreview.service;

import java.util.List;

import com.javaclass.zreview.model.vo.CateVO;
import com.javaclass.zreview.model.vo.FoodVO;

public interface ReviewService {
	public List<CateVO> getCateList();
	public List<FoodVO> getFoodList(CateVO cate);
}
