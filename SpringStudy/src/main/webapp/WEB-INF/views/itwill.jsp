<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itwill</title>
</head>
<body>
	
	<h1>itwill</h1>
	<h2>EL -> 메시지 : ${param.msg }</h2>
	<h2>Spring - EL -> 메시지 : ${msg }</h2>
	<h2>Spring - EL -> 메시지 : ${requestScope.msg }</h2>
</body>
</html>