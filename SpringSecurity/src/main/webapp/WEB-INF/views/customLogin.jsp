<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customLogin</title>
</head>
<body>
	
	<h2>customLogin.jsp</h2>
	<fieldset>
	<legend>로그인</legend>
	<form method="post" action="/login">
    <label for="userid">아이디:</label>
    <input type="text" id="userid" name="username"><br>

    <label for="userpw">비밀번호:</label>
    <input type="password" id="userpw" name="password"><br>
    <input type="hidden" value="${_csrf.token }" name="${_csrf.parameterName }">

    <input type="submit" value="로그인">
    </fieldset>
</form>
</body>
</html>