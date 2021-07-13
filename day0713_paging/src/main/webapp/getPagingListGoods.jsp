<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int nowPage = Integer.parseInt(request.getParameter("nowPage"));
	int perPage = Integer.parseInt(request.getParameter("perPage"));
	
	int start = (nowPage - 1)*perPage + 1; 
	//시작 레코드
	
	int end = start + perPage - 1;
	
	GoodsDao dao = new GoodsDao();
	ArrayList<GoodsVo> list = dao.getPagingList(start, end);
	Gson gson = new Gson();
	
	String re = gson.toJson(list);

%>
<%= re %>