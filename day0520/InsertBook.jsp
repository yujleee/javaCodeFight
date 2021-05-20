<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBookOK.jsp" method="post"> <!-- 전송받아 수행하는 프로그램을 action에 적음 /데이터를 전달하는 역할=> method= "post"-->
		도서번호: <input type="text" name="no"><br>
		도서명: <input type="text" name="name"><br>
		출판사: <input type="text" name="publisher"><br>
		가격: <input type="text" name="price"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>
