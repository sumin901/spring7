<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<!-- 로그인 여부에 따라 페이지 제어 -->
	<c:if test="${empty id }">
		<c:redirect url="/members/login" />
	</c:if>
	<h1>회원정보 수정</h1>
	<h2>${memberVO }</h2>
	<fieldset>
		<legend>내 정보 수정</legend>
	    <form method="post">
	        <label for="userId">아이디:</label>
	        <input type="text" id="userid" name="userid" value="${memberVO.userid }" readonly="readonly"><br>
	        
	        <label for="password">비밀번호:</label>
	        <input type="password" id="userpw" name="userpw"><br>
	        
	        <label for="name">이름:</label>
	        <input type="text" id="username" name="username" value="${memberVO.username }"><br>
	        
	        <label for="email">이메일:</label>
	        <input type="email" id="useremail" name="useremail" value="${memberVO.useremail }"><br>
	        
	        <input type="submit" value="수정하기">
   		</form>
	</fieldset>
	<h3><a href="/members/main">메인페이지로</a></h3>
</body>
</html>