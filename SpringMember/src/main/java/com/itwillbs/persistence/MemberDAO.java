package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/*
 * DAO : 데이터 처리 객체 (MyBatis를 통해 DB 동작 제어)
 */
public interface MemberDAO {
	
	public void insertMember(MemberVO mvo);
	
	public MemberVO selectLoginMember(MemberVO mvo);
	
	public MemberVO selectMemberInfo(String id);
	
	public int updateMemberInfo(MemberVO mvo);
	
	public int withdrawalMember(MemberVO mvo);
	
	public List<MemberVO> getMemberList();
}
