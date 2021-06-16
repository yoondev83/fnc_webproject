package com.webprj.project_green.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDto {
	private int postNum;
	private String title;
	private String content;
	private Date uploadDate;
	private int recommend;
	private String imageUrl;
	private String Category;
	private int userId;
	
}
