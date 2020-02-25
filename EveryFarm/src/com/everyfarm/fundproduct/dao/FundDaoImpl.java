package com.everyfarm.fundproduct.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.everyfarm.fundproduct.dto.FundDto;
import com.everyfarm.fundproduct.dto.FundPagingDto;
import com.everyfarm.fundproduct.dto.FundPayDto;
import com.everyfarm.fundproduct.dto.FundPayInputDto;

public class FundDaoImpl extends SqlMapConfig implements FundDao {
	
	private String namespace = "fund.";
	
	@Override
	public List<FundDto> fundAllList(int to, int from) {
						//to는 10, from은 1 
		
		List<FundDto> list = null;
		SqlSession session = null;	
		FundPagingDto dto = new FundPagingDto();
			dto.setTo(to);
			dto.setFrom(from);
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"selectList",dto);
			
		} catch (Exception e) {
			System.out.println("session");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<FundDto> fundBestList() {	//펀드 best4 뽑기

		List<FundDto> list = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"bestList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public FundDto fundDetail(int stock_no) {			//펀드 detail

		FundDto detail = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			detail = session.selectOne(namespace+"detail",stock_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return detail;
	}


	@Override
	public int totalpage() {		//총 게시물 갯수

		int totalpage = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalpage = session.selectOne(namespace+"totalpage");
			
			if(totalpage>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}		
		
		return totalpage;
	}

	@Override
	public FundPayDto orderInput(int stock_no, String mem_id, int orderinfo_kg) {
		FundPayDto payDto = null;
		SqlSession session = null;
		
		payDto = new FundPayDto();
		payDto.setStock_no(stock_no);
		payDto.setMem_id(mem_id);
		payDto.setOrderinfo_kg(orderinfo_kg);
		
		try {
			session = getSqlSessionFactory().openSession();
			int res = session.insert(namespace+"orderinput",payDto);
			System.out.println(payDto.getOrder_no());
			
			if(res>0) {
				int res2 = session.insert(namespace+"orderdetail",payDto);
				if(res2>0) {
					session.commit();					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return payDto;
	}

	@Override
	public int payInput(int order_no, int pay_price) {
		int payRes = 0;
		SqlSession session = null;
		
		System.out.println(order_no);
		System.out.println(pay_price);
		FundPayInputDto payInput = new FundPayInputDto();
		payInput.setOrder_no(order_no);
		payInput.setPay_price(pay_price);
		
		try {
			session = getSqlSessionFactory().openSession();
			payRes = session.insert(namespace+"payInput",payInput);
			
			if(payRes>0) {
				int updatePayInfo = session.update(namespace+"updateDetail",payInput);
				if(updatePayInfo>0) {
					session.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return payRes;
	}

}
