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
<title>검색결과</title>
</head>
<body>
<% 
	request.setCharacterEncoding("euc-kr");
	String bookName = request.getParameter("bookname");
%>
	<h2>"<%= bookName %>" 검색 결과</h2>
	<table>
		<tr style="font-weight:bold;">
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>가격</td>		
		</tr>
		<% 
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			String sql = "SELECT * FROM book WHERE bookname LIKE '%"+bookName+"%'";
		
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getString(3) %></td>
					<td><%= rs.getInt(4) %></td>
				</tr>
			<%	
			}
			
			rs.close();
			stmt.close();
			conn.close();
		%>
	</table>
	<a href="searchBook.jsp">다시 검색하기</a>
</body>
</html>
