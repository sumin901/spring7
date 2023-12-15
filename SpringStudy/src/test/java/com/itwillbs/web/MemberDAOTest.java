package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistance.memberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

// 테스트 전용 클래스
public class MemberDAOTest {
	
	// logger 객체 생성 (출력 전용 객체)
//	private static final Logger logger
//					= LoggerFactory.getLogger(MemberDAOTest.class);
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	// memberDAO 객체 필요 => memberDAOImpl 객체가 주입됨 
	@Inject
	private memberDAO mdao;
//	@Test
//	public void myBatis_첫쿼리구문실행() {
//		mdao.getTime();
//		logger.info(mdao.getTime());
//		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//	}
//	@Test
//	public void 회원가입테스트() {
//		
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid("qweqwe12352451");
//		mvo.setUsername("수민");
//		mvo.setUserpw("qwer1234!");
//		mvo.setUseremail("klop1211@naver.com");
//		mdao.insertMember(mvo);
//		
//		
//	}
//	@Test
//	public void 로그인테스트() {
//	
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid("1");
//		mvo.setUserpw("2");
//		mdao.loginMember(mvo);
//		
//		mdao.loginMember("1", "2");
//		
//	}
//	@Test
//	public void 회원조회테스트() {
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid("1");
//		
//		mdao.getMemberInfo(mvo);
//	}
//	@Test
//	public void 회원정보수정테스트() {
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid("1");
//		mvo.setUsername("민수");
//		mvo.setUseremail("klop1211@nate.com");
//		mvo.setUserpw("123123qwe!");
//		mdao.updateMember(mvo);
//	}
//	@Test
//	public void 회원삭제테스트() {
//		
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid("1");
//		int result = mdao.deleteMember(mvo);
//		logger.debug("회원삭제 결과 : " + result);
//	}
	
	@Test
	public void 회원정보리스트조회() {
		
		logger.debug("------회원정보리스트조회() ------");
		List<MemberVO> memberList = mdao.getMemberList();
		for(MemberVO vo : memberList) {
			logger.debug("id : " + vo.getUserid() + "// pw : " + vo.getUserpw());
		}
		logger.debug("------회원정보리스트조회() ------");
		
	}
	
	
	
	
	
	
}
