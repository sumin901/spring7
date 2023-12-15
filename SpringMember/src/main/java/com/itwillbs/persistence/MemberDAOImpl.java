package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// DB에 접근할 객체
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mappers.memberMapper.";
	// 컨트롤러에서 전달받은 정보를 가지고 DAO 처리
	// DAO 객체 생성 - 회원가입 처리 메서드 호출
	@Override
	public void insertMember(MemberVO mvo) {
		
		// 실제 DB에서 실행할 동작
		logger.debug("---------------mapper(DB) 회원가입 처리 구문 실행 - 시작");
		sqlSession.insert(NAMESPACE+"insertMember",mvo);
		logger.debug("---------------mapper(DB) 회원가입 처리 구문 실행 - 끝");
		
	}
	@Override
	public MemberVO selectLoginMember(MemberVO mvo) {
		logger.debug("---------------mapper(DB) 로그인 처리 구문 실행 - 시작");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+"loginMember", mvo);
		logger.debug("---------------결과 : " + resultVO);
		logger.debug("---------------mapper(DB) 로그인 처리 구문 실행 - 끝"); 
		return resultVO;
	}
	@Override
	public MemberVO selectMemberInfo(String id) {
		logger.debug("---------------mapper(DB) 회원정보 조회 실행 - 시작");
		logger.debug("---------------mapper(DB) 회원정보 조회 실행 - 끝");
		return sqlSession.selectOne(NAMESPACE+"memberInfo", id);
	}
	@Override
	public int updateMemberInfo(MemberVO mvo) {
		logger.debug("---------------mapper(DB) 회원정보 조회 실행 - 시작");
		
		return sqlSession.update(NAMESPACE+"memberUpdate", mvo);
	}
	@Override
	public int withdrawalMember(MemberVO mvo) {
		logger.debug("---------------mapper(DB) 회원탈퇴 실행 - 시작");
		
		return sqlSession.delete(NAMESPACE+"memberWithdrawal", mvo);
		
	}
	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("--------------DAO : getMemberList() 메서드 실행 ");
		
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}
	
	
	
	
	

}
