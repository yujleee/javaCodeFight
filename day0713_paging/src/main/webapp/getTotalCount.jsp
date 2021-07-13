<%@page import="com.sist.dao.GoodsDao"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GoodsDao dao = new GoodsDao();

%>
<%= dao.getTotalCount() %>