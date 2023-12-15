<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	
	<h2>스프링 MVC 로그인</h2>
	<fieldset>
	<legend>로그인</legend>
	<form method="post">
    <label for="userid">아이디:</label>
    <input type="text" id="userid" name="userid"><br>

    <label for="userpw">비밀번호:</label>
    <input type="password" id="userpw" name="userpw"><br>

    <input type="submit" value="로그인"><input type="button" value="회원가입" onclick="location.href='/members/join'">
    </fieldset>
</form>
</body>
</html>