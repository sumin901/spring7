<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all</title>
</head>
<body>
<h1>all.jsp</h1>
<h2><a href="/sample/admin">admin</a></h2>
<h2><a href="/sample/member">member</a></h2>
<sec:authorize access="isAnonymous()">
	<h2><a href="/customLogin">로그인</a></h2>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<h2><a href="/logout">로그아웃</a></h2>
</sec:authorize>
</body>
</html>