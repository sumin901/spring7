package com.itwillbs.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test {
	
	@Autowired
	private SqlSession sqlsession;
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	@Inject
	private BoardDAO bdao;
	
//	@org.junit.Test
//	public void 디비연결테스트() {
//		
//		logger.debug("디비연결 확인 : " + sqlsession);
//		
//	}
	
	@org.junit.Test
	public void 페이징테스트() {
		try {
			logger.debug("페이징 처리 테스트");
			logger.debug("test :" + bdao.getBoardListPage(1));
			logger.debug("-----------------------");
			Criteria cri = new Criteria();
			cri.setPage(4);
			cri.setPageSize(20);
			for(BoardVO bvo : bdao.getBoardListPage(cri)) {
				logger.debug(bvo.getBno() + "//" + bvo.getTitle() + "//" +bvo.getContents());
			}
			logger.debug("-----------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
