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
<title>���� ���</title>
</head>
<body>
<table>
	<tr>
		<td>������ȣ</td>
		<td>������</td>
	</tr>
<% 
	String sql = "select * from book order by bookid";
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><a href="bookview.jsp?bookid=<%=rs.getInt(1)%>"><%= rs.getString(2) %></a></td>
				</tr>
			<%	
			//��Ŀ�� ���� ���� ����. �ּ�?������=�� ��ĭ����x <a href="bookview.jsp?������1=��1&������2=��2">
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	} catch(Exception e){
		System.out.println("���ܹ߻�:" + e.getMessage());
	}

%>
</table>
</body>
</html>