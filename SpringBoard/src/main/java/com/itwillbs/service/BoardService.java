package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	public void write(BoardVO vo) throws Exception;
	public List<BoardVO> boardListALL() throws Exception;
	public BoardVO getBoard(int bno) throws Exception;
}
