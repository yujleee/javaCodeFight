<%@page import="java.sql.DriverManager"%>
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
<%
	request.setCharacterEncoding("euc-kr"); //한글깨짐 방지 

	//request
	int no = Integer.parseInt(request.getParameter("no"));
	String name = request.getParameter("name");
	String publisher = request.getParameter("publisher");
	int price = Integer.parseInt(request.getParameter("price"));
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url= "jdbc:oracle:thin:@192.168.123.107:1521:XE";
	String user= "c##scott";
	String pwd= "tiger";
	
	String sql = "insert into book values ("+no+", '"+name+"', '"+publisher+"', "+price+")";
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, user, pwd);
	Statement stmt = conn.createStatement();
	
	int re = stmt.executeUpdate(sql);
	
	if (re == 1){
		%> <p>등록 성공</p><% 
	} else {
		%> <p>등록 실패</p><% 
	}

	stmt.close();
	conn.close();
	
%>
<%= no %><br>
<%= name %><br>
<%= publisher %><br>
<%= price %>
</body>
</html>
