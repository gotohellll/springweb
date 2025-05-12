package com.example.zapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;

//@RestController
@Controller 
@RequestMapping("/api")
public class DeepLWithLib {

	@RequestMapping("/sample")
	public void test() {
		String authKey = "e1aec024-48f1-4994-a43d-f20597ac4d56:fx"; //개인 DeepL api key
		Translator translator = new Translator(authKey); //Translator 클래스
		TextResult result = null;
		
		try {
			result = translator.translateText("Hello, World", null, "KO"); //sourceLang : 영어는 null줘도 인지, targetLang 
		} catch (DeepLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("번역결과:"+result.getText());
		//http://localhost:8080/zapi/api/sample 요청을 직접 브라우저에 타이핑해서 확인가능
	}
	
	
	@RequestMapping("translate") //translate요청을 받음
	@ResponseBody //String return이 뷰 페이지가 되지 않게 
	public String test2(String content) { //ajax의 content를 받음 
		System.out.println("[원본]"+content); //사용자 입력값이 서버까지 왔는지 확인
		
		String authKey = "e1aec024-48f1-4994-a43d-f20597ac4d56:fx"; //개인 DeepL api key
		Translator translator = new Translator(authKey); 
		TextResult result = null;
		
		try {
			result = translator.translateText(content, "KO", "en-US");  
			//java.lang.IllegalArgumentException: targetLang="en" is not allowed, please use "en-GB" or "en-US" instead
		} catch (DeepLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//return "ok"; 
		return result.getText();
	}
}
