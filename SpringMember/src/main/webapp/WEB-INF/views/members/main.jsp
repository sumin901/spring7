<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>

	<h2>스프링 MVC 메인</h2>
	<!-- 로그인 여부에 따라 페이지 제어 -->
	<c:if test="${empty id }">
		<c:redirect url="/members/login" />
	</c:if>
	로그인한 유저의 아이디 : ${sessionScope.id } 
	
	<input type="button" value="로그아웃" onclick="location.href='/members/logout'"><br>
	<a href="javascript:location.href='/members/logout';">로그아웃</a> <hr>
	
	<h3>회원정보 조회(info)</h3>
	<a href="/members/info">내 정보 조회</a>
	
	<h3>회원정보 수정(update)</h3>
	<a href="/members/update">내 정보 수정</a>
	
	<h3>회원탈퇴</h3>
	<a href="/members/withdrawal">회원탈퇴</a>
	
	<!-- 관리자 전용 메뉴 -->
	<c:if test="${id.equals('admin') && !empty id }">
		<h3>회원정보 목록 조회(list)</h3>
		<a href="/members/list">회원정보 목록</a>
	</c:if>
</body>
</html>