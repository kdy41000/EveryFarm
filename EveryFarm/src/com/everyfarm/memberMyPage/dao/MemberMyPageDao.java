package com.everyfarm.memberMyPage.dao;

import com.everyfarm.member.dto.MemberDto;

public interface MemberMyPageDao {
	//1.내 정보 조회
	public MemberDto selectMyInfo(String mem_id);
	//2.내 정보 수정
	public int updateMyInfo(MemberDto dto);
	//3.회원 탈퇴
	public int memberDelete(String mem_id);
	//4.등급 조회
	public MemberDto selectGrade(String mem_id);
	//5.등업 신청
	public int applyGradeUp(String mem_id);
	//농장 신청 내역
	//펀드 투자 내역
	//경매 참가 내역
	
	
	
}
