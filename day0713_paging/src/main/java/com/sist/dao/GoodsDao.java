package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.GoodsVo;

public class GoodsDao {
	
	public int getTotalCount() {
		int cnt = 0;
		
		String sql = "select count(*) from goods";
		//Ʃ���� ������ ī��Ʈ
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cnt = rs.getInt(1); //���� ����� 1���̹Ƿ� �ٷ� cnt�� ���� 
			}
			
			ConnectionProvider.close(conn, stmt);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		
		return cnt;
	}
	
	public ArrayList<GoodsVo> findAll(){
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
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<GoodsVo> getPagingList(int start, int end){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select no,item,qty,price,fname "
				+ "from(select rownum n,no,item,qty,price,fname "
				+ "from (select * from goods order by no)) "
				+ "where n between ? and ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start); //���� ���ڵ� ����
			pstmt.setInt(2, end); //�� ���ڵ� ���� 
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return list;
	}
}
