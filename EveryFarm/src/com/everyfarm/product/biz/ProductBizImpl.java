package com.everyfarm.product.biz;

import java.util.List;

import com.everyfarm.product.dao.ProductDao;
import com.everyfarm.product.dao.ProductDaoImpl;
import com.everyfarm.product.dto.PagingDto;
import com.everyfarm.product.dto.ProductDto;

public class ProductBizImpl implements ProductBiz{

	private ProductDao dao = new ProductDaoImpl();
	
	public List<ProductDto>productlist(PagingDto dto){
		int currentpage = dto.getCurrentpage();   //초기값 1
		int column = dto.getColumn();   //16
		
		int startseq = column * (currentpage - 1) + 1;  //1
		int endseq = column * currentpage;   //16
		
		return dao.productlist(startseq,endseq);
	}

	@Override
	public List<ProductDto> bestlist() {
	
		return dao.bestlist();
	}

	@Override
	public int totalPage(int column) {
		int totalpage = (int)Math.ceil((double)dao.totalpage()/column);   //17 / 16 = 1
		return totalpage;
	}
}
