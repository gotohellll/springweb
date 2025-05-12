package com.example.zapi.dto;

import java.util.List;

import lombok.Data;

@Data
public class TranslationResponse {

	List<Translation> translation;
	//결과를 리스트 형식으로 응답 (Translation이라는 리스트 형식)
	
	
}
