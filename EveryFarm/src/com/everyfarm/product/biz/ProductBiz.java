package com.everyfarm.product.biz;

import java.util.List;

import com.everyfarm.product.dto.PagingDto;
import com.everyfarm.product.dto.ProductDto;

public interface ProductBiz {

	//일반상품 리스트
	public List<ProductDto>productlist(PagingDto dto);
	
	//페이징
	public int totalPage(int column);
	//best경매상품 리스트(4개만)
	public List<ProductDto>bestlist();
}
