<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	<h2>logout.jsp</h2>
	
	<form action="/logout" method="post">
		<input type="hidden" value="${_csrf.token }" name="${_csrf.parameterName }">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>