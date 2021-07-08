<%@page import="com.google.gson.Gson"%>
<%@page import="com.goods.vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.goods.dao.GoodsDao"%>
<%@ page language="java" contentType="appliation/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GoodsDao dao = new GoodsDao();
	ArrayList<GoodsVo> list = dao.listAll();
	
	Gson gson = new Gson();
	String json = gson.toJson(list);

%>
<%= json %>