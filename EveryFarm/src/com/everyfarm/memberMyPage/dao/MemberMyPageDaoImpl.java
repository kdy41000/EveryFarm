package com.everyfarm.memberMyPage.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.everyfarm.member.dto.MemberDto;

public class MemberMyPageDaoImpl extends SqlMapConfig implements MemberMyPageDao {
	private String namespace = "memberMyPage.";
	
	@Override
	public MemberDto selectMyInfo(String mem_id) {
		SqlSession session = null;
		MemberDto dto = new MemberDto();
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectMyInfo", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
				
		}
		return dto;
	}

	@Override
	public int updateMyInfo(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"updateMyInfo", dto);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public int memberDelete(String mem_id) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"memberDelete", mem_id);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	public int applyGradeUp(String mem_id) {
		SqlSession session = null;
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace+"applyGradeUp", mem_id);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public MemberDto selectGrade(String mem_id) {
		SqlSession session = null;
		MemberDto dto = new MemberDto();
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectGrade", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}

}
