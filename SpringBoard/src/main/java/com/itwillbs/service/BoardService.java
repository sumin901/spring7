package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	public void write(BoardVO vo) throws Exception;
	public List<BoardVO> boardListALL() throws Exception;
	public BoardVO getBoard(int bno) throws Exception;
	public void updateBoard(BoardVO bvo) throws Exception;
	public String updateViewcnt(int bno) throws Exception;
	public void deleteBoard(int bno) throws Exception;
	public List<BoardVO> boardListPage(Criteria cri) throws Exception;
}
