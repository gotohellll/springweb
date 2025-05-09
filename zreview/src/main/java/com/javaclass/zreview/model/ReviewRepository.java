package com.javaclass.zreview.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaclass.zreview.model.vo.CateVO;
import com.javaclass.zreview.model.vo.FoodVO;

@Mapper
public interface ReviewRepository {
	public List<CateVO> getCateList();
	public List<FoodVO> getFoodList(CateVO cate);
}
