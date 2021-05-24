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
	String adminName = request.getParameter("adminname");
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="c##madang";
	String pwd="madang";
	String sql="SELECT e.empno, e.ename, dname, location, nvl(e.sal, 0) FROM emp e left outer join emp m on(e.mgr = m.empno) left outer join dept on(e.deptno = dept.deptno) WHERE m.ename = '"+adminName+"'";
%>
	<h2>'<%= adminName %>' 의 검색 결과</h2>
	<p>해당 관리자가 관리하는 직원(들)은 다음과 같습니다.</p>

	<table>
		<tr style="font-weight:bold; font-color:#111;">
			<td>사원번호</td>
			<td>사원명</td>
			<td>부서명</td>
			<td>부서위치</td>
			<td>급여</td>
		</tr>
		<% 
		try{
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
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getInt(5) %></td>
				</tr>
			<% 		
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(Exception e){
			System.out.println("예외발생:" + e.getMessage());
		}
		%>
	</table>
	<br>
	<button type="button" onclick="location.href='employee.jsp'">다시 검색하기</button>

</body>
</html>
