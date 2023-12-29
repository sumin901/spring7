<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>
</head>
<body>
<h1>admin.jsp</h1>
<h2><a href="/sample/all">all</a></h2>
<h2><a href="/sample/member">member</a></h2>
<sec:authorize access="isAnonymous()">
	<h2><a href="/customLogin">로그인</a></h2>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<h2><a href="/logout">로그아웃</a></h2>
</sec:authorize>
<sec:authentication property="principal"/>

</body>
</html>