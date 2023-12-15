package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
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
	
	

	
	
}
