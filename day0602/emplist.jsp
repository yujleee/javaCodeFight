<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>�����ȣ</td>
		<td>����̸�</td>
		<td>����</td>
		<td>�����ڹ�ȣ</td>
		<td>�Ի���</td>
		<td>�޿�</td>
		<td>����</td>
		<td>�μ���ȣ</td>
		<td>�̸���</td>
		<td>�ֹι�ȣ</td>
	</tr>
<% 
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	String sql="select * from emp where deptno =" + deptno;

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			%>
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><%=rs.getString(2)%></td>
					<td><%= rs.getString(3) %></td>
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getDate(5) %></td>
					<td><%= rs.getInt(6) %></td>
					<td><%= rs.getInt(7) %></td>
					<td><%= rs.getInt(8) %></td>
					<td><%= rs.getString(9) %></td>
					<td><%= rs.getString(10) %></td>
				</tr>
			<%
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	} catch(Exception e){
		System.out.println("����ó��:" + e.getMessage());
	}
%>

</table>
</body>
</html>