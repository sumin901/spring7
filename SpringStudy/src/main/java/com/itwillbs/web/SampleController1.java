package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller : 스프링이 컨트롤러로 인식하도록 어노테이션
//				 HttpServlet, doPost, doGet 기능을 포함한다
@Controller
public class SampleController1 {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// 구현하고자 하는 동작을 메서드로 선언
	// @RequestMapping(value = "URI주소", method = '전달방식' )
	// http://localhost:8088/web/doA.com
	@RequestMapping(value = "/doA", method = RequestMethod.GET )
	public void doA() {
		
		logger.debug("doA() 실행");
		
		// 페이지 이동 (스프링이 자동 처리)
		// 메서드 선언 시 방법 결정 method = RequestMethod.GET 
		// * 메서드 리턴 타입 void일 때 주소이름.jsp 뷰페이지로 이동(연결)
		
	}
	
	// doA1 주소 사용 페이지 호출
	// http://localhost:8088/web/doA1
	@RequestMapping(value = "/doA1", method = {RequestMethod.GET, RequestMethod.POST})
	public void doA1() {
		
		logger.debug("doA1() 실행"); 
		
	}
	
}
