package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Log4j
//@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
//@WebAppConfiguration 
// => 스프링웹(MVC)로 테스트 하겠다고 명시
//@RunWith(SpringJUnit4ClassRunner.class)
//@Log4j
//@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
// => 스프링으로 controller 테스트 하겠다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class SampleControllerTests {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTests.class);
	
	@Inject
	private WebApplicationContext wac;
	
	// MockMvc : 요청과 응답을 처리하는 테스트용 객체
	private MockMvc mockMvc;
	
//	@Before : @Test 실행 전 반드시 처리해야하는 메서드라고 명시
	@Before
	public void setUp() {
		// MockMvc 객체 생성(준비)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		logger.debug("MockMvc 객체 생성 완료, 테스트 준비 완료");
	}
	
	@Test
	public void 컨트롤러테스트() {
		// 서버없이 컨트롤러 테스트
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
