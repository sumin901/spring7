<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<!-- 로그인 여부에 따라 페이지 제어 -->
	<c:if test="${empty id }">
		<c:redirect url="/members/login" />
	</c:if>
	<h1>회원탈퇴</h1>
	<fieldset>
		<legend>비밀번호 확인</legend>
	    <form method="post">
	        비밀번호: <input type="password" name="userpw">
	        <input type="submit" value="탈퇴하기">
   		</form>
	</fieldset>
	<h3><a href="/members/main">메인페이지로</a></h3>
</body>
</html>