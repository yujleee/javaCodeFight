<%@page import="com.sist.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	MemberDao dao = new MemberDao();
	if( dao.isMember(id, pwd) ){ //db와 연동
		%> 로그인 성공 <%
	} else{
		%> 로그인 실패 <%
	}

%>


</body>
</html>