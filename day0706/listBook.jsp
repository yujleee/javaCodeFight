<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.BooklistVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BooklistDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BooklistDao dao = new BooklistDao();
	ArrayList<BooklistVo> list = dao.listAll();
	
	Gson gson = new Gson();
	String str = gson.toJson(list);

%>
<%= str %>