package com.itwillbs.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;


@Repository
// @Repository : 스프링이 해당 파일이 memberDAO 역할을 수행하는 객체로 인식되게 만든다
public class MemberDAOImpl implements memberDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	// DB 연결정보 (자동 연결, mapper접근 ...)를 처리하는 객체가 필요함
	// rootContext.xml의 미리 생성된 객체(beans)를 주입받는다
	// rootContext.xml에 context:component-scan> 태그로 해당 파일이 위치한 패키지를 인식시켜놓음
	@Inject
	private SqlSession sqlSession;
	
	// mapper 위치정보 저장
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper.";
	
	
	@Override
	public String getTime() {

		// 1. DB 연결
		// 2. SQL 구문작성 : mapper.XML파일
		// 3. SQL 실행
		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
//					  sqlSession.selectOne("SQL 구문의 쿼리 정보");
		System.out.println("SQL 쿼리 실행, " + time);
		
		return time;
	}

	@Override
	public String getUserID() {
		
		String userid = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getUserID");
		
		System.out.println("SQL 쿼리 실행, " + userid);
		
		return userid;
	}

	@Override
	public void insertMember(MemberVO mvo) {
		
		logger.debug("insertMember(MemberVO mvo) 실행 - 시작");
		logger.debug("MyBatis가 mapper에 접근");
		logger.debug("SQL 구문 실행");
		logger.debug("SQL 구문 실행 결과 발생");
		sqlSession.insert(NAMESPACE+"insertMember", mvo);
		logger.debug("insertMember(MemberVO mvo) 실행 - 종료");
		
	}

	@Override
	public MemberVO loginMember(MemberVO mvo) {
		
		logger.debug("loginMember(MemberVO mvo) 실행 - 시작");
		logger.debug("DAO : mapper 호출");
		MemberVO resultMVO = sqlSession.selectOne(NAMESPACE+"loginMember", mvo);
		logger.debug("loginMember 결과 : " + resultMVO);
		logger.debug("loginMember(MemberVO mvo) 실행 - 종료");
		
		if(resultMVO != null) {
			logger.debug("로그인 성공");
		} else {
			logger.debug("로그인 실패");
		}
		
		return resultMVO;
	}

	@Override
	public MemberVO loginMember(String userid, String userpw) {

		logger.debug("loginMember(String userid, String userpw) 실행");
//		MemberVO mvo = new MemberVO();
//		mvo.setUserid(userid);
//		mvo.setUserpw(userpw);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+"loginMember", paramMap);
		
		logger.debug("loginMember(String userid, String userpw) 종료");
		
		return resultVO;
	}

	@Override
	public MemberVO getMemberInfo(MemberVO mvo) {
		
		logger.debug("getMemberInfo(MemberVO mvo) 실행");
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+"getMemberInfo", mvo);
		logger.debug("DAO 결과 : " + resultVO);
		logger.debug("getMemberInfo(MemberVO mvo) 종료");
				
		return resultVO;
	}

	@Override
	public int updateMember(MemberVO mvo) {
		
		logger.debug("updateMember(MemberVO mvo) 실행");
		int result = sqlSession.update(NAMESPACE+"updateMember", mvo);
		logger.debug("updateMember(MemberVO mvo) 종료");
		
		return result;
	}

	@Override
	public int deleteMember(MemberVO mvo) {

		logger.debug("deleteMember(MemberVO mvo) 실행");
		int result = sqlSession.delete(NAMESPACE+ "deleteMember", mvo);
		logger.debug("deleteMember(MemberVO mvo) 종료");
		
		return result;
	}

	@Override
	public List<MemberVO> getMemberList() {

		logger.debug("getMemberList() 실행");
		return sqlSession.selectList(NAMESPACE+"getMemberList");
		
	}

	
	
	
	
	
	
	

}
