package com.webprj.project_green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.RankDao;
import com.webprj.project_green.dto.ProductDto;

@Service
public class RankServiceImpl implements RankService {
	
	@Autowired
	private RankDao rankDao;
	
	@Override
	public List<ProductDto> getProducts() {
		// TODO Auto-generated method stub
		return rankDao.getProducts();
	}

	@Override
	public void updateRecommend(Integer productNum, int i) {
		// TODO Auto-generated method stub
		rankDao.updateRecommend(productNum, i);
	}

	@Override
	public List<ProductDto> getProductsOrder() {
		// TODO Auto-generated method stub
		return rankDao.getProductsOrder();
	}

}
