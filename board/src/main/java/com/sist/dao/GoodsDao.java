package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.GoodsVo;

public class GoodsDao {
	
	private static GoodsDao dao = null;
	
	//생성자를 private 영역에 둠 => 외부에서는 new GoodsDao()를 못함.
	private GoodsDao() {
		
	}
	
	public static GoodsDao getInstance() {
		if(dao == null) {
			dao = new GoodsDao(); //외부에서는 생성하지 못하도록
		}
		
		return dao;
	}
	
	public int delete(int no) {
		int re = -1;
		
		try {
			String sql = "delete from goods where no=?";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
		
	}
	
	public int update(GoodsVo g) {
		int re = -1;
		
		try {
			String sql = "update goods set item=?, qty=?, price=?, fname=? where no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getItem());
			pstmt.setInt(2, g.getQty());
			pstmt.setInt(3, g.getPrice());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
	public GoodsVo findByNo(int no) {
		//상세보기 할 상품 번호 전달받음
		GoodsVo g = null;
		String sql = "select no, item, qty, price, fname from goods where no = ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				g = new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return g;
	}
	
	public ArrayList<GoodsVo> findAll(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select no, item, qty, price, fname from goods";
		
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
	
	
	
	public int insert(GoodsVo g) {
		int re = -1;
		String sql = "insert into goods(no, item, qty, price, fname) values(seq_goods.nextval, ?, ?, ?, ?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getItem());
			pstmt.setInt(2, g.getQty());
			pstmt.setInt(3, g.getPrice());
			pstmt.setString(4, g.getFname());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
		
	}
	
	
}
