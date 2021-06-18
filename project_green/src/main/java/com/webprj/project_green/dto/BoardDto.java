package com.webprj.project_green.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BoardDto {
	private int postNum;
	private String title;
	private String content;
	private Date uploadDate;
	private int recommend;
	private String imageUrl;
	private String Category;
	private String userId;
}
