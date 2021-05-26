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
<title>Insert title here</title>
</head>
<body>
	<h2>도서 추천</h2>
	<form action="bookTest.jsp" method="post">
		고객이름: <input type="text" name="name">
		<input type="submit" value="추천">
	</form>
	
	<% 
	 	String method = request.getMethod(); //요청방식 확인 get/post 중 하나. String으로 반환
	
		if(method.equals("POST")){ //form의 method는 대/소문자 구별이 없지만 값을 가져올때는 대문자로 가져와야함 
			
			request.setCharacterEncoding("euc-kr");
			String name = request.getParameter("name");
			System.out.println("이름:" + name);
		
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			String sql = "SELECT * FROM book WHERE bookid IN (SELECT distinct bookid FROM orders "+
							"WHERE custid IN(SELECT DISTINCT custid FROM orders "+ 
							"WHERE bookid IN(SELECT bookid FROM orders "+
							"WHERE custid = (SELECT custid FROM customer WHERE name = '"+name+"')) "+ 
							"AND custid <> (SELECT custid FROM customer WHERE name = '"+name+"')) "+
							"union SELECT bookid FROM orders GROUP BY bookid HAVING COUNT(*) >= 2 "+
							"minus SELECT bookid FROM orders WHERE custid = (SELECT custid FROM customer WHERE name = '"+name+"'))";
			
			//String sql = "SELECT * FROM book WHERE bookid IN (SELECT distinct bookid FROM orders WHERE custid IN(SELECT DISTINCT custid FROM orders WHERE bookid IN(SELECT bookid FROM orders WHERE custid = (SELECT custid FROM customer WHERE name = '"+name+"')) AND custid <> (SELECT custid FROM customer WHERE name = '"+name+"')) union SELECT bookid FROM orders GROUP BY bookid HAVING COUNT(*) >= 2 minus SELECT bookid FROM orders WHERE custid = (SELECT custid FROM customer WHERE name = '"+name+"'))";
			
			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement(); //sql 실행을 위한 객체 생성
				ResultSet rs = stmt.executeQuery(sql);
				
				%>
				<!-- table의 테두리, 가로크기 지정 -->
				<table border="1" width="80%">
					<tr>
						<td>도서번호</td>
						<td>도서명</td>
						<td>출판사</td>
						<td>가격</td>
					</tr>
					<% 
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
					%>
				</table>
				<%
				
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception e){
				System.out.println("예외발생:" + e.getMessage());
			}
		}
	%>
	
</body>
</html>
