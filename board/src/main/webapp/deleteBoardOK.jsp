<%@page import="com.sist.dao.BoardDao"%>
<%@page import="java.io.File"%>
<%@page import="com.sist.vo.BoardVo"%>
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
	String pwd = request.getParameter("pwd");
	String path = request.getRealPath("board");
	
	BoardDao dao = BoardDao.getInstance();
	String fname = dao.findByNo(no).getFname(); //첨부파일명 
	int re = dao.delete(no, pwd);

	if (re == 1){
		File file = new File(path + "/" + fname); //파일 경로 지정
		file.delete(); //해당 파일 삭제
		response.sendRedirect("listBoard.jsp");
	} else{
		out.println("삭제에 실패했습니다.<br>");
		out.print("<a href='listBoard.jsp'>목록</a>");
	}
%>

</body>
</html>