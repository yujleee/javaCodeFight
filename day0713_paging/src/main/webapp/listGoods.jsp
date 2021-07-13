<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.GoodsDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GoodsDao dao = new GoodsDao();

	ArrayList<GoodsVo> list = dao.findAll();
	Gson gson = new Gson();
	
	String result = gson.toJson(list);
%>
<%= result%>