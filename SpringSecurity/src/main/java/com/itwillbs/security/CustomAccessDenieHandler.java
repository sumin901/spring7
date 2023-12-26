package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/*
 * 접근 권한이 없을 때 발생하는 오류를 처리하는 클래스
 * 
 * 주소줄의 표시와 뷰페이지가 일치하게 한다. (특정 쿠키, 세션 접근 처리가 가능하다)
 * 
 */

public class CustomAccessDenieHandler implements AccessDeniedHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDenieHandler.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		logger.debug("CustomAccessDenieHandler, handle 실행");
		// 권한정보 체크 가능함
		
		logger.debug("Redirect...~");
		// Redirect 페이지 이동
		response.sendRedirect("/accessErr");
	}

}
