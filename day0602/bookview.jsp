<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 상세 정보</title>
</head>
<body>
<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));     
	String sql = "select * from book where bookid = "+bookid;
%>

<table>

<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
	
		if(rs.next()){
			%>
				<tr><td>도서번호</td><td><%= rs.getInt(1) %></td></tr>
				<tr><td>도서명</td><td><%= rs.getString(2) %></td></tr>
				<tr><td>출판사</td><td><%= rs.getString(3) %></td></tr>
				<tr><td>가격</td><td><%= rs.getInt(4) %></td></tr>			
			<%
		}
	} catch(Exception e){
		System.out.println("예외발생:" + e.getMessage());
	}
%>
</table>
</body>
</html>