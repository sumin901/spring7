<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commons.jsp</title>
</head>
<body>
	<h1>commons.jsp</h1>
	<h2>예외발생!</h2>
	<hr>
	${e.getMessage() }
	<hr>
	${e }
	
	<%
		response.addHeader("refresh", "3; url='/board/listAll'");
	%>
	
</body>
</html>