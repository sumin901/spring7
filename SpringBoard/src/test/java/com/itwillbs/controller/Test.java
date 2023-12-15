package com.itwillbs.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test {

	@Autowired
	private SqlSession sqlsession;
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@org.junit.Test
	public void 디비연결테스트() {
		
		logger.debug("디비연결 확인 : " + sqlsession);
		
	}
	
}
