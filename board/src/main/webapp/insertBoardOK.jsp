<%@page import="com.sist.dao.BoardDao"%>
<%@page import="com.sist.vo.BoardVo"%>
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
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("board");
	System.out.println(path);
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());

	String title = multi.getParameter("title");
	String writer = multi.getParameter("writer");
	String pwd = multi.getParameter("pwd");
	String content = multi.getParameter("content");
	
	String ip = request.getRemoteAddr();
	String fname = multi.getFilesystemName("uploadFile");
	
	BoardVo b = new BoardVo();
	b.setTitle(title);
	b.setWriter(writer);
	b.setPwd(pwd);
	b.setContent(content);
	b.setIp(ip);
	b.setFname(fname);
	
	BoardDao dao = BoardDao.getInstance();
	int re = dao.insert(b);
	
	if(re == 1){
		response.sendRedirect("listBoard.jsp");
	} else{
		out.println("게시물 등록 실패");
	}
%>
</body>
</html>