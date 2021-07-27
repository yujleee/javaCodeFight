<%@page import="com.sist.vo.BoardVo"%>
<%@page import="com.sist.dao.BoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = BoardDao.getInstance();
		BoardVo b = dao.findByNo(no);
	%>
	<form action="updateBoardOK.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="<%= no %>">
		글제목: <input type="text" name="title" value="<%= b.getTitle() %>"><br>
		작성자: <%= b.getWriter() %><br>
		글암호: <input type="password" name="pwd"><br>
		글내용: <br>
		<textarea rows="10" cols="80" name="content"><%= b.getContent() %></textarea><br>
		첨부파일 : <%= b.getFname() %><br>
		<input type="hidden" name="fname" value="<%= b.getFname() %>"><br>
		<input type="file" name="uploadFile"><br>	
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>