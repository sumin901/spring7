package com.itwillbs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonsController.class);
	
	@RequestMapping (value = "/accessErr", method = RequestMethod.GET)
	public void accessErr(
			Authentication auth 
			) throws Exception{
		logger.debug("accessErr 실행");
		logger.debug("auth : " + auth.getAuthorities());
		List authList = (List) auth.getAuthorities();
		logger.debug("authList(0) : " + authList.get(0));
		
		if(authList.get(0).toString().equals("ROLE_MEMBER")) {
			logger.debug("사용자 권한");
		}
	}
	
	@RequestMapping (value = "/customLogin", method = RequestMethod.GET)
	public void myLoginPage () throws Exception {
		logger.debug("myLoginPage 실행");
	}
	
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public void myLogoutPage() {
		logger.debug("myLogoutPage 실행");
	}
}
