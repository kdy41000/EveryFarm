package com.everyfarm.admin.dao;

import static com.everyfarm.admin.dao.SqlMapConfig.getSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;


public class AdminAccountDao {
	
	private String namespace = "admin.";
	
	public int stockKindCount(int kindnumber) {
		int totalstock = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalstock = session.selectOne(namespace+"stockKindCount", kindnumber);
			System.out.println("품목별 카운트 수 : "+totalstock);
			if(totalstock>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : AdminAccountDao stockKindCount()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalstock; 
	}
	
	public int fundSumCurrentPrice() {
		int totalres = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalres = session.selectOne(namespace+"fundSumCurrentPrice");
			System.out.println("펀드 진행중인 현재 총액 : "+totalres);
			if(totalres>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : AdminAccountDao fundSumCurrentPrice()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalres; 
	}
	
	public int auctionSumCurrentPrice() {
		int totalres = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalres = session.selectOne(namespace+"auctionSumCurrentPrice");
			System.out.println("경매 진행중인 현재 총액 : "+totalres);
			if(totalres>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : AdminAccountDao auctionSumCurrentPrice()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalres; 
	}
	
	public int fundCurrentMember() {
		int totalres = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalres = session.selectOne(namespace+"fundCurrentMember");
			System.out.println("펀드 진행중인 참여자 수 : "+totalres);
			if(totalres>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : AdminAccountDao fundCurrentMember()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalres; 
	}
	
	public int auctionCurrentMember() {
		int totalres = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalres = session.selectOne(namespace+"auctionCurrentMember");
			System.out.println("경매 진행중인 참여자 수 : "+totalres);
			if(totalres>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : AdminAccountDao auctionCurrentMember()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return totalres; 
	}

}
