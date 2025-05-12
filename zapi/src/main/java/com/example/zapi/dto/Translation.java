package com.example.zapi.dto;

import lombok.Data;

@Data
public class Translation {
	String detected_source_language; //번역된 언어
	String text; //결과물(번역본)
}
