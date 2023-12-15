package com.itwillbs.web;

import org.junit.Test;

import com.itwillbs.domain.MemberVO;

public class LombokTest {
	@Test
	public void 롬복테스트() {
		
		MemberVO mvo = new MemberVO();
		mvo.setUserid("qweqwe123");
		mvo.setUserpw("qwer1234!");
		System.out.println("멤버 ID : " + mvo.getUserid());
		System.out.println("멤버 OW : " + mvo.getUserpw());
		
		
	}
	
}
