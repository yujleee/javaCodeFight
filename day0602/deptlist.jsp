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
<title>부서 목록</title>
</head>
<body>
	<table>
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>위치</td>
		</tr>
	<% 
		String sql = "select * from dept";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><a href="emplist.jsp?deptno=<%=rs.getInt(1)%>"><%=rs.getString(2)%></a></td>
					<td><%= rs.getString(3) %></td>
				</tr>
			<%
		}
		
		rs.close();
		stmt.close();
		conn.close();
	%>
	
	
	</table>


</body>
</html>