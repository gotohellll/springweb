package com.example.zapi.dto;

import java.util.List;

public class TranslationRequest {
	//멤버변수(요청할 데이터)
	List<String> text;
	String source_lang;
	String target_lang;
	
	//getter, setter
	public List<String> getText() {
		return text;
	}
	public void setText(List<String> text) {
		this.text = text;
	}
	public String getSource_lang() {
		return source_lang;
	}
	public void setSource_lang(String source_lang) {
		this.source_lang = source_lang;
	}
	public String getTarget_lang() {
		return target_lang;
	}
	public void setTarget_lang(String target_lang) {
		this.target_lang = target_lang;
	}
	
	
}
