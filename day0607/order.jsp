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
<title>문구 주문 시스템</title>
</head>
<body>
<%
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String user = "c##madang";
String pwd = "madang";	

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//고객 쿼리문을 실행하기 위한 객체 생성 (쿼리문마다 객체 생성해야함!)
	Connection conn2 = DriverManager.getConnection(url,user,pwd);
	Statement stmt2 = conn2.createStatement();
	String sql2= "select * from 고객";
	ResultSet rs2 = stmt2.executeQuery(sql2);
%>
<form action="orderOK.jsp" method="post">
	고객번호: <select name="custid">
	<% 
		while(rs2.next()){
			%>
				<option value="<%= rs2.getInt(1)%>"><%= rs2.getString(2) %></option>
			<%
		}
		rs2.close();
		stmt2.close();
		conn2.close();
	%>
	</select>
	<br>
	<table>
<%	//고객번호 입력을 DB연동하여 콤보박스로 표현 
	String sql = "select * from 제품";
	Connection conn = DriverManager.getConnection(url,user,pwd);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next()){
		int itemno = rs.getInt(1);
		String itemname = rs.getString(2);
		int price = rs.getInt(3);
		String img = rs.getString(4);
			
			//루프를 돌며 DB의 제품목록들을 체크박스로 생성 보이는 것은 상품이름, 값은 상품번호.
			%>
			<tr>
				<td><input type="checkbox" name="itemno" value="<%= itemno %>"><%= itemname %></td>
				<td>
					<input type="text" name="<%= itemno %>" size="5">
					<input type="hidden" name="price<%=itemno%>" value="<%= price %>"> <!-- price1 이런식으로 이름 붙음. --> 
					<img src="<%= img %>.jpg" width = 100>		
				</td> <!-- 각각 받아오기 위해 input 이름을 상품번호와 똑같이 줌 / type="hidden" 보이지는 않지만 값을 전달-->		
			</tr>
			<%
		}
		rs.close();
		stmt.close();
		conn.close();
		
	}catch (Exception e){
		System.out.println("예외발생:" + e.getMessage());
	}
%>
	</table>

	<input type="submit" value="주문">
</form>
</body>
</html>
