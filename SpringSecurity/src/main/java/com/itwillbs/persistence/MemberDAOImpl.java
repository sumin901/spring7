package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository(value = "memberDAO")
public class MemberDAOImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "com.itwillbs.mappers.memberMapper"; 
	
	@Inject
	private SqlSession sqlsession;
	
	public MemberVO memberJoin() throws Exception {
		
		return sqlsession.selectOne(NAMESPACE+".getMemberJoin", "admin90");
	}
	
}
