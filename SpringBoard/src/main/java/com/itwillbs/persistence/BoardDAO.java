package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardDAO {
	
	public void write(BoardVO vo) throws Exception;
	public List<BoardVO> getBoardListALL() throws Exception;
	public BoardVO getBoard(int bno) throws Exception;
	public void updateBoard(BoardVO bvo) throws Exception;
	public void updateViewcnt(int bno) throws Exception;
	public void deleteBoard(int bno) throws Exception;
	public List<BoardVO> getBoardListPage(int page) throws Exception;
	public List<BoardVO> getBoardListPage(Criteria cri) throws Exception;
}
