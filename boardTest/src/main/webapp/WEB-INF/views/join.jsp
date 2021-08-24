<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js
"></script>
<script type="text/javascript">
	$(function(){
		$("#btnSend").click(function(){
			var to = $("#phone").val();
			data = {to:to}; //컨트롤러에서의 매개변수 to 
			$.ajax({ url:"sendCode.do", data:data, success:function(data){
				alert(data);
			}});
		});
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
		전화번호: <input type="text" name="phone" id="phone"><br>
		<button id="btnSend">인증번호 전송</button><br>
	<form action="join.do" method="post">
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pwd"><br>
		이름: <input type="text" name="name"><br>
		<input type="submit" value="가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>