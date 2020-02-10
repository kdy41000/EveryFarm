package com.everyfarm.product.dao;

import java.util.List;

import com.everyfarm.product.dto.ProductDto;

public interface ProductDao {

	//일반상품 리스트
		public List<ProductDto>productlist(int startseq, int endseq);
		
	//페이징
		public int totalpage();
		
	//best경매상품 리스트(4개만)
		public List<ProductDto>bestlist();	
}
