package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //인자 다받는 생성자함수
@NoArgsConstructor //인자없는 생성자함수
public class SampleVO {

	String name;
	Integer age;
	String message;
	
}
