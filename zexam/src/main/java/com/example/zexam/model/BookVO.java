package com.example.zexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookVO {
	
	private Integer book_no;
	private String book_title;
	private String book_detail;
	private String book_images;
	
}
