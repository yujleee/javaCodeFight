<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마당서점 도서검색</title>
</head>
<body>
	<h2>도서 검색</h2>
	<p>찾으려는 도서명이나 키워드를 입력해주세요.</p>
	<form action="searchBookOK.jsp" method= "post">
		도서명: <input type="text" name="bookname">
		<input type="submit" value="검색">
	</form>
</body>
</html>
