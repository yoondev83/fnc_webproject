package com.webprj.project_green.service;

import java.util.List;

import com.webprj.project_green.dto.ProductDto;

public interface RankService {

	List<ProductDto> getProducts();

	void updateRecommend(Integer productNum, int i);

	List<ProductDto> getProductsOrder();

}
