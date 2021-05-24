<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 정보 검색</title>
</head>
<body>
	<h2>HR 서비스</h2>
	<p>관리자가 관리하는 직원(들)의 정보를 검색합니다.</p>
	<form action="searchAdmin.jsp" method="post">
		관리자 이름:<input type="text" name="adminname">
		<input type="submit" value="검색">
	</form>
</body>
</html>
