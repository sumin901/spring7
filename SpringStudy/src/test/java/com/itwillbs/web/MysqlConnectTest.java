package com.itwillbs.web;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.sun.jdi.connect.spi.Connection;

/**
 *	mysql데이터베이스 연결을 테스트하기위한 클래스
 */
public class MysqlConnectTest {

	// DB 연결정보
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";
	
	// @Test : 	테스트하고자하는 내용을 메서드 안에 작성 후 해당 어노테이션을
	//			작성하면, Junit이 해당 코드를 테스트용 코드로 인식하고 자동 실행 및 테스트를 진행함
	@Test
	public void testConnection() {
		
		try {
			//1. 드라이버 로드
			Class.forName(DRIVER);
			System.out.println("드라이버 로드");
			
			System.out.println("DB 연결 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. DB 연결
		try (java.sql.Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);){
			System.out.println("con : " + con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// try-with (1.7버전 이상부터 사용) 
		// : try, catch, finally 한번에 처리하는 문법
		// AutoCloseable 인터페이스를 구현한 객체를 try()안에 작성하면
		// 사용 후 자동으로 자원해제
		
		// 기본 문법 
		// try(예외처리 코드) {
		// 	실행 코드
		// } catch(Exception e) {
		// }
		
		
		
		
		
	}
	
}
