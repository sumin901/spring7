package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

//@Service : 스프링(root-context.xml)에서 해당 객체를 서비스로 인식하도록 명시함
//			  => 서비스 빈으로 인식
@Service
public class MemberServiceImpl implements MemberService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberVO mvo) {
		logger.debug("-------------------Service - 회원가입 처리 - memberJoin(MemberVO mvo)");
		//컨트롤러에서 전달받은 정보를 바탕으로 DAO 처리
		// DAO 객체 생성 - 회원가입 처리 메서드 호출
		logger.debug("-------------------DAO 회원가입 메서드 호출 - 시작");
		mdao.insertMember(mvo);
		logger.debug("-------------------DAO 회원가입 메서드 호출 - 끝");
	}

	@Override
	public MemberVO memberLogin(MemberVO mvo) {
		logger.debug("-------------------Service - 로그인 처리 - memberLogin(MemberVO mvo)");
		
		return mdao.selectLoginMember(mvo);
	}

	@Override
	public MemberVO memberInfo(String id) {
		logger.debug("-------------------Service - 회원정보 조회 - memberInfo(String id)");
		logger.debug("-------------------DAO 회원정보 조회 메서드 호출 - 시작");
		return mdao.selectMemberInfo(id);
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		logger.debug("-------------------Service - 회원정보 수정 - memberUpdate(MemberVO mvo)");
		logger.debug("-------------------DAO - 회원정보 수정 메서드 호출 - 시작");
		return mdao.updateMemberInfo(mvo);
	}

	@Override
	public int memberWithdrawal(MemberVO mvo) {
		logger.debug("-------------------Service - 회원탈퇴 - memberWithdrawal(MemberVO mvo)");
		logger.debug("-------------------DAO - 회원탈퇴 메서드 호출 - 시작");
		return mdao.withdrawalMember(mvo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("------------------Service - 모든회원정보목록조회");
		return mdao.getMemberList();
	}
	
	
	
	
	

}
