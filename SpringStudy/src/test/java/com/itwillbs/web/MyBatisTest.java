package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MyBatisTest {

	// DB 연결 = Mybatis 사용 => sqlSessionFactoryBean 객체 사용
	@Inject
	private SqlSessionFactory sqlFactory; // root-context에서 SqlSessionFactoryBean으로 
										  // 받아왔는데 SqlSessionFactory을 업캐스팅해서 사용한다
	@Inject
	private SqlSession SqlSession;
	@Test
	public void mybatis테스트() {
		
		System.out.println(sqlFactory);
		System.out.println(SqlSession);
//		SqlSession session = sqlFactory.openSession();
//		session.insert(statement);
		
	}
		
}
