<%@page import="com.sist.vo.BoardVo"%>
<%@page import="com.sist.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	textarea{
		border: none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = BoardDao.getInstance();
	dao.updateHit(no);
	BoardVo b = dao.findByNo(no);

%>
<h2>게시물 상세</h2>
<hr>
글번호: <%= b.getNo() %><br>
글제목: <%= b.getTitle() %><br>
작성자: <%= b.getWriter() %><br>
글내용: <br>
<textarea rows="10" cols="80" readonly="readonly"><%= b.getContent() %></textarea><br>
조회수: <%= b.getHit() %><br>
작성일: <%= b.getRegdate() %><br>
ip : <%= b.getIp() %><br>
첨부파일 : <%= b.getFname() %><br>
<hr>
<a href="updateBoard.jsp?no=<%= b.getNo()%>">수정</a>
<a href="deleteBoard.jsp?no=<%= b.getNo()%>">삭제</a>
<a href="insertBoard.jsp?no=<%= b.getNo()%>">답글</a> 
<!-- 부모 글번호 전달. no의 존재여부에 따라 새글/답글작성을 다르게 할 수 있음 -->
</body>
</html>