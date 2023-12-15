package com.itwillbs.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBatisTests {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTests.class);
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void 마이바티스테스트() {
		
		logger.debug("sqlSession : " + sqlSession);
		
	}
	
	
}
