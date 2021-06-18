package com.webprj.project_green.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int productNum;
	private String name;
	private String imageUrl;
	private int locationLa;
	private int locationLo;
	private int recommend;
}
