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
public class QnAVO {
	
	private Integer qna_no;
	private String qna_title;
	private String qna_content;
	private String qna_date;

}
