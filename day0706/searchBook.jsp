<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.BooklistVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BooklistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String keyword = request.getParameter("keyword"); 
	//html에서 받아온 keyword를 받음
	BooklistDao dao = new BooklistDao();
	ArrayList<BooklistVo> list = dao.searchBook(keyword);
	Gson gson = new Gson();
	String json = gson.toJson(list);
%>
<%= json %>