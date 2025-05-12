package com.example.zapi.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.zapi.dto.TranslationRequest;
import com.example.zapi.dto.TranslationResponse;

@RestController
@RequestMapping("api")
public class DeepLWithoutLib {
	
	private final String deeplApiUrl = "https://api-free.deepl.com/v2/translate"; //사이트에 접속
	private final String authKey = "e1aec024-48f1-4994-a43d-f20597ac4d56:fx"; //api key
	
	@PostMapping("translate2") //post타입의 translate2 요청 매핑
	public ResponseEntity<TranslationResponse> translate(@RequestBody TranslationRequest request) { //인자가 json형태로 넘어옴
																	//request 요청
		//System.out.println("test"); //서버까지 왔는지 확인 
		
		//사용자가 보내준 데이터 확인
		System.out.println(request.getText());
		System.out.println(request.getSource_lang());
		System.out.println(request.getTarget_lang());
		
		//header양식
		HttpHeaders headers = new HttpHeaders(); //spring import
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); //MediaType : sping선택
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "DeepL-Auth-Key " + authKey); //주의할점: "DeepL-Auth-Key " 공백 필수
		System.out.println(headers);
		System.out.println("-------------------");
		
		RestTemplate restTemplate = new RestTemplate();
		
		//응답으로 response구조를 만들어 받음
		TranslationResponse response = 
				restTemplate.postForObject(deeplApiUrl, //어디로 접속할지
											createHttpEntity(request, headers), //요청
											TranslationResponse.class); //어떤 형식으로 응답할지
		
		return ResponseEntity.ok(response);
	}
	
	private HttpEntity<TranslationRequest> createHttpEntity(
				TranslationRequest request, HttpHeaders headers){
		
		return new HttpEntity<>(request,headers); //버전 안맞아서 에러 뜨면 project facets 버전 변경  
	}
	
}
