package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistance.memberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MemberDAOTest2 {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest2.class);
	@Inject
	private memberDAO mdao;
	
	@Test
	public void myBatis_테스트() {
		
		System.out.println("logger 찾기");
		logger.info(mdao.getUserID());
		
	}
	
	
}
