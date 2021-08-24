<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<a href="insertBoard.do">등록</a>
	<a href="join.do">회원가입</a>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th width="50">게시물번호</th>
			<th>글제목</th>
			<th width="100">작성자</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>
					<c:if test="${b.b_level > 0 }">
						<c:forEach var="i" begin="1" end="${b.b_level }">
							&nbsp;&nbsp;
						</c:forEach>
						<img src="resources/re.png">
					</c:if>
					<a href="detailBoard.do?no=${b.no }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${totalPage }">
		<!-- 상태유지한 TotalPage까지 페이지번호 출력-->
		<a href="listBoard.do?pageNUM=${i }">${i }</a>&nbsp;
	</c:forEach>
</body>
</html>