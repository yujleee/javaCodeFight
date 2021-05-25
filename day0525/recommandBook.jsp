<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 맞춤 도서추천 서비스</h2>
	<p>고객명을 입력해주세요.</p>
	<form action="recommendBookOK.jsp" method="post">
		고객명: <input type="text" name="name">
		<input type="submit" value="검색"> 
	</form>
</body>
</html>
