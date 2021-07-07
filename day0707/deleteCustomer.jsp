<%@page import="com.sist.dao.CustomerDAO"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt(request.getParameter("custid"));

	CustomerDAO dao = new CustomerDAO();
	
	int re = dao.deleteCustomer(custid);

%>
{"result":<%= re%>}