<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>모든회원정보 조회</title>
</head>
<body>
	<!-- 관리자 전용 메뉴 -->
	<c:if test="${!id.equals('admin') || empty id }">
		<c:redirect url="/members/main"/>
	</c:if>
	<h1>회원정보 조회</h1>
	
	<table border="1">
		<thead>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>회원가입일</td>
			<td>최종수정일</td>
		</thead>
	<c:forEach var="mvl" items="${memberVOList }" >
		<tr>
			<td>${mvl.userid }</td>
			<td>${mvl.userpw }</td>
			<td>${mvl.username }</td>
			<td>${mvl.useremail }</td>
			<td>${mvl.regdate }</td>
			<td>${mvl.updatedate }</td>
		</tr>
	</c:forEach>	
	</table>
	
	<h3><a href="/members/main">메인페이지로</a></h3>
	
</body>
</html>