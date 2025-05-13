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
public class NoticeVO {

	private Integer notice_no;
	private String notice_title;
	private String notice_content;
	private String notice_date;
}
