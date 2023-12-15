package com.itwillbs.persistance;

import com.itwillbs.domain.MemberVO;

public interface memberDAO {
	
	// 추상 메서드로 처리 동작 선언
	
	// DB 시간정보 조회
	public String getTime();
		
	// 유저 아이디 조회
	public String getUserID();
	
	// 회원가입
	public void insertMember(MemberVO mvo);
	
	// 로그인
	public MemberVO loginMember(MemberVO mvo);
	public MemberVO loginMember(String userid, String userpw);
	
	// 회원정보 조회
	public MemberVO getMemberInfo(MemberVO mvo);
	
	// 회원정보 수정
	public int updateMember(MemberVO mvo);
	
	// 회원정보 삭제
	public int deleteMember(MemberVO mvo);
	
	// 회원정보 조회 리스트
	public java.util.List<MemberVO> getMemberList();
	
	
	
}
