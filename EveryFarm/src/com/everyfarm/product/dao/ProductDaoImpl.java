package com.everyfarm.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.everyfarm.product.dto.PagingDto;
import com.everyfarm.product.dto.ProductDto;

public class ProductDaoImpl extends SqlMapConfig implements ProductDao{

	private String namespace = "product.";
	
	@Override
	public List<ProductDto> productlist(int startseq, int endseq) {
		SqlSession session = null;
		List<ProductDto>list = null;
		PagingDto dto = new PagingDto();
		
		try {
			session = getSqlSessionFactory().openSession();
			
			dto.setStartseq(startseq);
			dto.setEndseq(endseq);
			
			list = session.selectList(namespace+"auctionlist",dto);
		} catch (Exception e) {
			System.out.println("[error] : selectList");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<ProductDto> bestlist() {
		SqlSession session = null;
		List<ProductDto>list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"bestauctionlist");
			System.out.println(list.get(2).getStock_image()+"********다오");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int totalpage() {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace + "totalpage");   //17
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

}
