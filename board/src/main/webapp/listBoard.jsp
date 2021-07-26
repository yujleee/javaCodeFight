<%@page import="com.sist.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<table border="1" width="80%">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
		</tr>
		<%
			BoardDao dao = BoardDao.getInstance();
			ArrayList<BoardVo> list = dao.findAll();
			
			for(BoardVo b : list){
				%>
					<tr>
						<td><%= b.getNo() %></td>
						<td width="60%"><a href="detailBoard.jsp?no=<%= b.getNo()%>"><%= b.getTitle() %></a></td>
						<td><%= b.getWriter() %></td>
					</tr>
				<%
			}
		
		%>
	</table>
	<a href="insertBoard.jsp">글쓰기</a>
</body>
</html>