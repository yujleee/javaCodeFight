<%@page import="java.io.File"%>
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
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, 
			"utf-8", new DefaultFileRenamePolicy()); 
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String title = multi.getParameter("title");
	String pwd = multi.getParameter("pwd");
	String content = multi.getParameter("content");
	String OldFname = multi.getParameter("fname");
	//원래 파일이름
	
	BoardVo b = new BoardVo();
	b.setNo(no);
	b.setTitle(title);
	b.setPwd(pwd);
	b.setContent(content);
	b.setFname(OldFname);
	
	String fname = null;  
	fname = multi.getFilesystemName("uploadFile"); //업로드한 파일명 fname으로 저장
	
	if(fname != null && !fname.equals("")){
		//새로운 파일로 업로드하는 경우 
		b.setFname(fname);
	}
	
	BoardDao dao = BoardDao.getInstance();
	int re = dao.update(b);
	
	if( re == 1 ){
		if(fname != null && !fname.equals("")){
			File file = new File(path + "/" + OldFname);
			file.delete();
		}
		response.sendRedirect("listBoard.jsp");
	} else{
		out.println("게시물 수정에 실패하였습니다. <br>");
		out.print("<a href='listBoard.jsp'>목록</a>");
	}
	
%>
</body>
</html>