package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// http://localhost:8088/sample/all
// http://localhost:8088/sample/admin
@Controller
@RequestMapping(value = "/sample/*")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping (value = "/all", method = RequestMethod.GET)
	public void doALL() throws Exception {
		logger.debug("doALL");
	}
	@RequestMapping (value = "/member", method = RequestMethod.GET)
	public void doMember() throws Exception {
		logger.debug("doMember");
	}
	@RequestMapping (value = "/admin", method = RequestMethod.GET)
	public void doAdmin() throws Exception {
		logger.debug("doAdmin");
	}
}
