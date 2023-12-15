package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	private SqlSession sqlsession;
	private static final String NAMESPACE = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void write(BoardVO vo) throws Exception {
		logger.debug("DAO, vo : " + vo);
		sqlsession.insert(NAMESPACE+".write", vo);
	}

	@Override
	public List<BoardVO> getBoardListALL() throws Exception {
		logger.debug("DAO, getBoardListALL() 호출");
		
		return sqlsession.selectList(NAMESPACE+".getListALL");
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug("dddddd, getBoard() 호출");
		
		return sqlsession.selectOne(NAMESPACE+".getBoard", bno);
	}
	
	
	
	
	
}
