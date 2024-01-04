package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

// @RestController : REST 방식의 컨트롤러임을 선언
@RestController
@RequestMapping(value = "/sample")
public class SampleRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);
	
	// http://localhost:8088/sample/doA
	@GetMapping(value = "/doA")
	public String doA() {
		logger.debug("doA 호출");
		
		return "ResponseBody";
	}
	
	@GetMapping(value = "/doB")
	public Integer doB() {
		
		// String을 제외한 기본형타입들의 리턴은 참조형 타입으로 리턴하는 것을 권장한다. (Wrapper Class)
		return 123;
	}
	
	@GetMapping(value = "/doC")
	public MemberVO doC() {
		MemberVO mvo = new MemberVO();
		mvo.setUseremail("klop1211@naver.com");
		mvo.setUserid("qwer");
		mvo.setUserpw("1234");
		mvo.setUsername("수민");
		
		// 객체를 JSON 타입으로 변환한다. 
		// * 자바 직렬화 : 자바 시스템 내부에서 사용되는 데이터 형태에서 외부에서 사용되는 데이터 형태로 변경하는 것
		
		return mvo;
	}
	@GetMapping(value = "/doD")
	public List<MemberVO> doD() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		for(int i=1; i<10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setUseremail("klop1211"+i+"@naver.com");
			mvo.setUserid("qwer"+i);
			mvo.setUserpw("1234");
			mvo.setUsername("수민"+i);
			memberList.add(mvo);
		}
		
		
		// 객체를 JSON 타입으로 변환한다. 
		// * 자바 직렬화 : 자바 시스템 내부에서 사용되는 데이터 형태에서 외부에서 사용되는 데이터 형태로 변경하는 것
		
		return memberList;
	}
	@GetMapping(value = "/doE")
	public Map<Integer, MemberVO> doE() {
		Map<Integer, MemberVO> memberMap = new HashMap<Integer, MemberVO>();
		for(int i=1; i<10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setUseremail("klop1211"+i+"@naver.com");
			mvo.setUserid("qwer"+i);
			mvo.setUserpw("1234");
			mvo.setUsername("수민"+i);
			memberMap.put(i, mvo);
		}
		
		
		// 객체를 JSON 타입으로 변환한다. 
		// * 자바 직렬화 : 자바 시스템 내부에서 사용되는 데이터 형태에서 외부에서 사용되는 데이터 형태로 변경하는 것
		
		return memberMap;
	}
	
	// http://localhost:8088/sample/doF/100
	@GetMapping(value = "/doF/{num}")
	public String doF(@PathVariable("num") Integer num) {
		logger.debug("doF 실행");
		return "Hi, " + num;
	}
	
	@PostMapping(value = "/info")
	public String doInfo(@RequestBody MemberVO mvo) {
		logger.debug("info 실행");
		logger.debug("member : " + mvo);
		return "Success";
	}
	
	
}
