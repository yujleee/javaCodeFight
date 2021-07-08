package com.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.goods.db.ConnectionProvider;
import com.goods.vo.GoodsVo;

public class GoodsDao {
	
	public ArrayList<GoodsVo> listAll(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		
		String sql = "select * from goods order by no";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return list;
	}
	
	public int insertGoods(GoodsVo g) {
		int re = -1;
		String sql = "insert into goods values(?, ?, ?, ?, ?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getItem());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			
			pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}

	public int updateGoods(GoodsVo g) {
		int re = -1;
		String sql = "update goods set item = ?, price = ?, qty = ?, fname = ? where no = ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getItem());
			pstmt.setInt(2, g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			
			pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete from goods where no = ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
}
