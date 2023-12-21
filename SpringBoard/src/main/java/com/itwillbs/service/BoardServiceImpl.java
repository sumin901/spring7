package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAOImpl;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAOImpl bdao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public void write(BoardVO vo) throws Exception {
		bdao.write(vo);
		logger.debug("Service, vo = " + vo);
		
	}

	@Override
	public List<BoardVO> boardListALL() throws Exception {
		logger.debug("Service, boardListALL() 호출 ");
		List<BoardVO> bListALL = bdao.getBoardListALL();
		logger.debug("Service, bListALL : " + bListALL);
		return bListALL;
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug("sssssssss, getBoard() 호출");
		
		return bdao.getBoard(bno);
	}

	@Override
	public void updateBoard(BoardVO bvo) throws Exception {
		logger.debug("ss : updateBoard() 호출");
		bdao.updateBoard(bvo);
		
	}

	@Override
	public String updateViewcnt(int bno) throws Exception {
		logger.debug("ss : updateViewcnt 호출 ");
		bdao.updateViewcnt(bno);
		return "조회수증가";
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		logger.debug("ss : deleteBoard 호출");
		bdao.deleteBoard(bno);
		
		
	}

	@Override
	public List<BoardVO> boardListPage(Criteria cri) throws Exception {
		logger.debug("ss : boardListPage 호출");
		return bdao.getBoardListPage(cri);
	}
	
	

	
	
}
