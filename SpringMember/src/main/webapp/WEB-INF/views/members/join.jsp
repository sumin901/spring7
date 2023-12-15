<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>스프링 MVC 회원가입</h2>
    <!-- form 태그 안 action 주소가 없으면 자기 자신 호출 -->
    <form method="post">
        <label for="userId">아이디:</label>
        <input type="text" id="userid" name="userid"><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="userpw" name="userpw"><br>
        
        <label for="name">이름:</label>
        <input type="text" id="username" name="username"><br>
        
        <label for="email">이메일:</label>
        <input type="email" id="useremail" name="useremail"><br>
        
        <input type="submit" value="가입하기">
    </form>
</body>
</html>
