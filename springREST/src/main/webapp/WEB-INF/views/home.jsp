<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type="button" value="정보 전송" id="send">

<script type="text/javascript">

	$().ready(function() {
		
		// 버튼 클릭 시
		$("#send").click(function (){
			
			var member = {
				"userid" : "admin",
				"userpw" : "1234",
				"username" : "관리자",
				"useremail" : "klop1211@naver.com"
			};
			console.log("버튼 클릭");
			console.log(member);
			
			$.ajax({
				
				url : "/sample/info",
 				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(member),
				success : function(data) {
					alert('/sample/info 비동기 호출');
					$('body').append(data);
				},
				error : function () {
					alert('에러');
					
				},
				
				
			});// ajax
			
		}); // click
		
		
		
		
	});


</script>

</body>
</html>
