<%@page import="com.sist.dao.CustomerDAO"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt(request.getParameter("custid"));
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	
	CustomerVO c = new CustomerVO(custid, name, address, phone);
	CustomerDAO dao = new CustomerDAO();
	
	int re = dao.updateCustomer(c);

%>
{"result":<%= re%>}