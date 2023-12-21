package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.aop.MyCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AOPTest {
	
	@Inject @Qualifier("pc")
	private MyCalculator cal;
	
	@Test
	public void AOP테스트() {
		cal.add(100, 15);
		cal.div(100, 1);
		cal.mul(6, 6);
		cal.sub(897, 123);
	}
	
}
