package com.itwillbs.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	//http://localhost:8088/web/doC?userid="1234"&gender=남자
	
	//DB에서 전달받는 데이터로 가정한다
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public void doC(Model model, MemberVO mvo) {
		
		// MembeVo mvo : <@ModelAttribute ("memberVO") MemberVO memberVO> 가 생략되어있음
		// => memberVO에 해당하는 데이터들을 알아서 찾아 저장해줌
		
		logger.debug("doC() 실행");
		// DB에서 전달받는 MemberVO 객체 생성
		MemberVO Resultmvo = new MemberVO();
		model.addAttribute(Resultmvo);
		// 전달하는 대상의 이름을 지정하지 않을 경우
		// Spring에서 자동으로 대상 데이터 데이터타입(클래스명)의 첫문자를 소문자로 변경 후 저장
		logger.debug("model : " + model.toString());
		logger.debug("mvo : " + mvo);
		
		// 연결된 뷰 페이지로 전달 -> Model 객체 생성
		// ! Model 객체 : View <-> Controller 간에 정보를 전달하는 객체
		
	}
	
}
