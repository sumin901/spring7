package com.itwillbs.service;

import java.util.ArrayList;
import java.util.List;

import com.itwillbs.domain.MemberVO;

/*
 * 서비스 계층 (비지니스 로직 계층) : 사용자의 요구사항을 구현하는 단계
 * 
 * => 컨트롤러 <-> DAO를 연결하는 계층 (접착제의 역할)
 * => 외부호출이 영속계층(DB)에 종속적인 상황을 막는다
 */

public interface MemberService {
	
	// 구현하고자하는 동작을 추상 메서드로 선언한다
	 public void memberJoin(MemberVO mvo);
	 
	 public MemberVO memberLogin(MemberVO mvo);
	 
	 public MemberVO memberInfo(String id);
	 
	 public int memberUpdate(MemberVO mvo);
	 
	 public int memberWithdrawal(MemberVO mvo);
	 
	 public List<MemberVO> getMemberList();
	
}
