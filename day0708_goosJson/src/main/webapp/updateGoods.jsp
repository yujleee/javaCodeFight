<%@page import="com.goods.vo.GoodsVo"%>
<%@page import="com.goods.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String oper = request.getParameter("oper");
	
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDao dao = new GoodsDao();
	
	GoodsVo g = null;
	
	if(oper.equals("INSERT") || oper.equals("UPDATE")){
		String item = request.getParameter("item");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String fname = request.getParameter("fname");
		
		g = new GoodsVo(no, item, price, qty, fname);
	}
	
	switch(oper){
	case "INSERT": dao.insertGoods(g); break;
	case "UPDATE": dao.updateGoods(g); break;
	case "DELETE": dao.deleteGoods(no); break;
	}

%>