<%@page import="com.sist.order.orderDao"%>
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
<%
	String custid = request.getParameter("custid");	//고객번호
	String []itemno = request.getParameterValues("itemno");	//체크박스 선택한 항목만큼의 배열. 선택한 항목의 번호가 들어감 ex) 색종이의 품번 "1"
	int []qty = new int[itemno.length]; //선택한 제품의 수만큼에 대한 구매수량의 배열 생성 
	int []price = new int[itemno.length]; //선택한 제품의 가격에 대한 배열 
	int []salePrice = new int[itemno.length]; //총 구매가격을 위한 배열
	int total = 0; //총주문금액 누적 변수 

	for(int i=0; i<itemno.length; i++){
		qty[i] = Integer.parseInt(request.getParameter(itemno[i])); //각 제품의 수량을 가져와서 qty 배열에 넣음 ex) "1" 품목 >> 5개 일때 5를 넣음. 
		price[i] = Integer.parseInt(request.getParameter("price" + itemno[i])); //제품에 대한 가격을 배열에 추가 
		salePrice[i] = qty[i] * price[i];
		total += salePrice[i];
	}	
	
	orderDao dao = new orderDao();
	int no = dao.getNextNo(); //메소드를 통해 새로운 주문번호 생성
	
	boolean result = dao.insertOrder(custid, itemno, qty, price, salePrice, total, no);	

	if(result){
		%>주문이 완료되었습니다.<%
	} else{
		%>주문이 실패했습니다.<%
	}	
			
%>
</body>
</html>
