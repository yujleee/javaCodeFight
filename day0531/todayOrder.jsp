<%@page import="java.util.Calendar"%>
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
<title>금일 도서 판매 수량 확인</title>
</head>
<body>
	<% 
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int date = now.get(Calendar.DAY_OF_MONTH);
	%>
	<h2><%= year %>년 <%= month %>월 <%= date %>일 도서 판매 수량</h2>
	<table border="1" width="50%">
		<tr>
			<td>도서명</td>
			<td>판매 수량</td>
		</tr>
		<% 
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			String sql = "select * from vw_today_order";
		
			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
				%>
					<tr>
						<td><%= rs.getString(1) %></td>
						<td><%= rs.getInt(2) %></td>
					</tr>
				<%
				}
				
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e){
				System.out.println("예외발생:" + e.getMessage());
			}
			
		%>
	</table>
</body>
</html>
