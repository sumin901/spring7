package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*
 * advice 객체 (보조기능 - 로깅)
 * 
 */

public class LogginAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 보조기능 구현
		System.out.println("advice"); // 보조 기능
		Object obj = invocation.proceed(); // 주 기능
		System.out.println("advice"); // 보조 기능
		
		return null;
	}

	
	
}
