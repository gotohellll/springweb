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
public class QuestionVO {
	private Integer question_no;
	private String question_title;
	private String question_content;
	private String question_date;

}
