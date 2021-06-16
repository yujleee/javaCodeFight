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
<title>영화 예매 확인</title>
</head>
<body>
	<h2>영화 예매 확인</h2>
	<form action="movieReservation.jsp" method="post">
		고객이름: <input type="text" name="cname">
		<input type="submit" value="확인">
	</form>

	<% 
	 	String method = request.getMethod(); 
	
		if(method.equals("POST")){ 
			
			request.setCharacterEncoding("euc-kr");
			String name = request.getParameter("cname");
		
			String driver = "oracle.jdbc.driver.OracleDriver"; //DB와의 연동
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			String sql = "select cname, title, rsvdate, address, r.scrno ,seatno "+ 
					"from reservation r, tcustomer c, screen s "+
					"where r.cno = c.cno and s.tno = r.tno and s.scrno = r.scrno and cname = '"+name+"'";
					//고객 이름에 해당하는 예매내역을 선택하는 쿼리문 
			
			try{
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement(); //sql 실행을 위한 객체 생성
				ResultSet rs = stmt.executeQuery(sql);
				
				%>
				<h2>예약 정보</h2>
				<table border="1" width="80%">
					<tr>
						<td>고객명</td>
						<td>영화제목</td>
						<td>예약날짜</td>
						<td>극장위치</td>
						<td>상영관</td>
						<td>좌석번호</td>
					</tr>
					<% 
						if(rs.next()){
							%>
							<tr>
								<td><%= rs.getString(1) %></td>
								<td><%= rs.getString(2) %></td>
								<td><%= rs.getDate(3) %></td>
								<td><%= rs.getString(4) %></td>
								<td><%= rs.getInt(5) %></td>
								<td><%= rs.getInt(6) %></td>
							</tr>
							<%
						} else{
							%><tr><td>예매내역이 존재하지 않습니다.</td></tr><%
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
