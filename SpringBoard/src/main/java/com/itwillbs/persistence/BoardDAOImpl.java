package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

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

	@Override
	public void updateBoard(BoardVO bvo) throws Exception {
		logger.debug("dd : updateBoard() 호출");
		sqlsession.update(NAMESPACE+".updateBoard", bvo);
		
	}

	@Override
	public void updateViewcnt(int bno) throws Exception {
		logger.debug("dd : updateViewcnt 호출");
		sqlsession.update(NAMESPACE+".updateViewcnt", bno);
		
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		logger.debug("dd : deleteBoard 호출");
		sqlsession.delete(NAMESPACE+".deleteBoard", bno);
	}

	@Override
	public List<BoardVO> getBoardListPage(int page) throws Exception {
		logger.debug("dd : getBoardListPage 호출");
		
		// 페이징처리 계산
		// page 1 => 1~10, page 2 => 11~20
		//		  => 0,10		  => 10,10
		page = (page - 1)*10;
		
		return sqlsession.selectList(NAMESPACE+".getListPage", page);
	}

	@Override
	public List<BoardVO> getBoardListPage(Criteria cri) throws Exception {
		logger.debug("dd : getBoardListPage(Criteria cri) 호출");
		return sqlsession.selectList(NAMESPACE+".getListPage", cri);
	}
	
	
	
	
	
}
