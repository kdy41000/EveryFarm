package com.everyfarm.admin.dao;

import org.apache.ibatis.session.SqlSession;
import static com.everyfarm.admin.dao.SqlMapConfig.*;

public class PagingDao {
	
	private String namespace = "admin.";

	public int totalPage(int totalrows) {
		int totalpage = 0;
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			totalpage = session.selectOne(namespace+"totalpage");
			res = (int)Math.ceil((double)totalpage/totalrows);
			
			if(totalpage>0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("ERROR : PagingDao totalPage()");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res; 
		
	}
	
	
	
}
