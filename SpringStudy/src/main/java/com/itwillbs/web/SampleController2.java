package com.itwillbs.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	//http://localhost:8088/web/doB?msg=ITWILL2&age=20
	@GetMapping(value = "/doB")
	public String doB (@ModelAttribute("msg") String msg, 
					   @ModelAttribute("age") int age) {
		// 기본형 타입 리턴 불가 !
		// String 타입만 리턴 할 수 있음
		logger.debug("doB() 실행");
		logger.debug("msg : " + msg);
		logger.debug("age : " + age);
		
		
		// 메서드 리턴타입 : String -> "리턴".jsp 뷰 페이지 연결
		return "itwill";
		
	}
	
}
