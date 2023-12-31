package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * DB 연결 테스트 (Spring - DataSource 사용)
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// : 스프링으로 테스트하도록 설정

// @ContextConfiguration(
//	 	locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//		)
// : 스프링에서 설정해놓은 파일의 정보 불러오기위한 경로 설정

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {

	// DB 연결을 위한 연결정보가 필요 => 해당 정보를 의존한다(<= 의존관계-주입)
//	@Inject : 의존관계의 객체를 주입하는 어노테이션
	@Inject // = @Autowired
	private DataSource ds;
	
//	@Test : 테스트하고자 하는 메서드에 어노테이션, 미작성시 no Runnable Method Exception 발생
	@Test
	public void dataSourceTest() {
		System.out.println("dataSource : " + ds);
	}
	@Test
	public void 디비연결테스트 () {
		try {
			Connection con = ds.getConnection();
			System.out.println("DB 연결 완료");
			System.out.println("con : " + con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
