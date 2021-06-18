package com.webprj.project_green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.webprj.project_green.dto.ProductDto;

@Mapper
@Repository
public interface RankDao {

	List<ProductDto> getProducts();

	void updateRecommend(@Param("productNum") Integer productNum,@Param("i") int i);

	List<ProductDto> getProductsOrder();

}
