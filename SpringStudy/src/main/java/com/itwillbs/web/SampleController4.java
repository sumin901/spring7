package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doD
	@RequestMapping(value="/doD" ,method = RequestMethod.GET)
	public String doD(/*RedirectAttributes rttr*/Model model /* @ModelAttribute("msg") String msg */) {
		logger.debug("doD() 실행");
//		rttr.addFlashAttribute("msg", "아이티윌");
		model.addAttribute("msg", "itwill");
		model.addAttribute("msg2", "itwill2");
		
/*		
		addAttribute() : URI(주소줄)에 데이터가 노출됨		- Model, RedirectAttribute 사용가능, F5 = 데이터 유지
		addFlashAttribute() : URI(주소줄)에 데이터 노출 X	- RedirectAttribue만 사용가능, F5 = 일회성 데이터
*/
//		return "forward:/doE";
		return "redirect:/doE";
	}
	
	@RequestMapping(value="/doE" ,method = RequestMethod.GET)
	public String doE(@ModelAttribute("msg") String msg, 
			@ModelAttribute("msg2") String msg2) {
		logger.debug("doE() 실행");
		logger.debug("---------------"+msg);
		logger.debug("---------------"+msg2);
		
		return "/doE";
		
	}
	// http://localhost:8088/web/doF?data=1234&data=4321
	@RequestMapping(value="/doF" ,method = RequestMethod.GET)
	public String doF(@RequestParam("data") Object[] data/*
						 * @ModelAttribute("data") int data,
						 * 
						 * @ModelAttribute("data") String sData
						 */) {
		logger.debug("doF() 실행");
//		logger.debug("---------------" + data);
//		logger.debug("---------------" + (data+100));
//		logger.debug("---------------" + (sData+100));
		
		logger.debug("---------------" + data[0]);
		logger.debug("---------------" + data[1]);
		return "/doF";
		
	}
	
}

/************************************************************************************
  	forward 방식
  
  	// http://localhost:8088/web/doD?msg=itwill
	@RequestMapping(value="/doD" ,method = RequestMethod.GET)
	public String doD() {
		logger.debug("doD() 실행");
		return "forward:/doE";
	}
	
	@RequestMapping(value="/doE" ,method = RequestMethod.GET)
	public String doE(@ModelAttribute("msg") String msg) {
		logger.debug("doE() 실행");
		logger.debug("---------------"+msg);
		return "/doE";
		
	}
 ************************************************************************************* 
  redirect 방식
  	
  	1.
  	@RequestMapping(value="/doD" ,method = RequestMethod.GET)
	public String doD(@ModelAttribute("msg") String msg) {
		logger.debug("doD() 실행");
//		return "forward:/doE";
		return "redirect:/doE";
	}
	
	@RequestMapping(value="/doE" ,method = RequestMethod.GET)
	public String doE(@ModelAttribute("msg") String msg) {
		logger.debug("doE() 실행");
		logger.debug("---------------"+msg);
		return "/doE";
		
	}
	
	2. Redirect 방식에서만 가능한 addFlashAttributes
		@RequestMapping(value="/doD" ,method = RequestMethod.GET)
	public String doD(RedirectAttributes rttr) {
		logger.debug("doD() 실행");
		rttr.addFlashAttribute("msg", "아이티윌");
//		return "forward:/doE";
		return "redirect:/doE";
	}
	
}	3. (1), (2), (3)의 방식 차이 이해하기 - Spring.txt 참조
	public String doD( (1) RedirectAttributes rttr (2) Model model (3) @ModelAttribute("msg") String msg ) {
		logger.debug("doD() 실행");
//		rttr.addFlashAttribute("msg", "아이티윌");
		model.addAttribute("msg2", "itwill");
//		return "forward:/doE";
		return "redirect:/doE";
	}
 
*
*/
