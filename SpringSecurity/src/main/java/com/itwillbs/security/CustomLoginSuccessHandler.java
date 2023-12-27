package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/*
 * 로그인 성공 시 권한별로 페이지 이동
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
			logger.debug("onAuthenticationSuccess 실행");
			logger.debug("로그인 성공");
			
			// 사용자 권한 정보 저장
			List<String> roleNames = new ArrayList<String>();
			
			auth.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
			logger.debug("roleNames : " + roleNames);
			if(roleNames.contains("ROLE_ADMIN")) {
				logger.debug("관리자 계정");
				// 페이지 이동
				response.sendRedirect("/sample/admin");
				return;
			}
			
			if(roleNames.contains("ROLE_MEMBER")) {
				logger.debug("일반 사용자 계정");
				// 페이지 이동
				response.sendRedirect("/sample/member");
				return;
			}
			// 그 외 나머지의 페이지 이동
			response.sendRedirect("/sample/all");
			
			
	}
	
	
}
