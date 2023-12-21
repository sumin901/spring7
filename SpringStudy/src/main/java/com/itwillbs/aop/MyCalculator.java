package com.itwillbs.aop;


/*
 * target 클래스 (주기능 : 계산)
 * 
 */

public class MyCalculator {
	
	public void add(int a, int b) {
		System.out.println("advice"); // 보조기능 
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println("advice");
	}
	public void sub(int a, int b) {
		System.out.println(a + " - " + b + " = " + (a-b));
	}
	public void mul(int a, int b) {
		System.out.println(a + " * " + b + " = " + (a*b));
	}
	public void div(int a, int b) {
		System.out.println(a + " / " + b + " = " + (a/b));
	}
}
