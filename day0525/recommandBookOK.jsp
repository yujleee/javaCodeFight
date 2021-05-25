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
<title>추천도서 목록</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		
		String sql= "SELECT b.bookid, bookname, publisher, price FROM book b, (SELECT AVG(price) AS avgp FROM book b, orders o, customer c WHERE name = '"+name+"' AND o.custid = c.custid AND o.bookid = b.bookid) p WHERE b.price < p.avgp MINUS SELECT b.bookid, bookname, publisher, price FROM book b, orders o, customer c WHERE o.custid = c.custid AND o.bookid = b.bookid AND name ='"+name+"'";
	%>
	<h2><%= name %>님의 추천도서 목록</h2>
	<table>
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>가격</td>
		</tr>
		<% 
			try{
				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "c##madang";
				String pwd = "madang";
				
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
				%>
					<tr>
						<td><%= rs.getInt(1)%></td>
						<td><%= rs.getString(2)%></td>
						<td><%= rs.getString(3)%></td>
						<td><%= rs.getInt(4)%></td>
					
					</tr>	
				<%
				}
				
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (Exception e){
				System.out.println("예외발생:" + e.getMessage());
			}
		
		%>
	</table>
</body>
</html>
