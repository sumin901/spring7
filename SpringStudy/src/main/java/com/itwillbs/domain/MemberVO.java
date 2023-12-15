package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data : 필요한 기본 설정값 지정 (getter, setter, canEqual, toString)

@Data
public class MemberVO {
	// Value Object = DTO 개념으로 사용한다 (DB 테이블 정보 저장 객체)
	
	// lombok은 getter, setter 메서드를 작명할 때 첫 자를 강제로 대문자로 만들기 때문에
	// 변수명 작명시에 주의한다
	// private String 'uA'bc -> get'UA'bc()
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	
	
}
