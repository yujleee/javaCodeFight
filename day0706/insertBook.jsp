<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BooklistDao"%>
<%@page import="com.sist.vo.BooklistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");

	int bookid = Integer.parseInt(request.getParameter("bookid"));
	String bookname = request.getParameter("bookname");
	String publisher = request.getParameter("publisher");
	int price = Integer.parseInt(request.getParameter("price"));
	
	BooklistVo b = new BooklistVo(bookid, bookname, publisher, price);
	BooklistDao dao = new BooklistDao();
	int re = dao.insertBook(b);
	
	

%>
<%= re %>