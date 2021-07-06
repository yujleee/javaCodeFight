package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BooklistVo;

public class BooklistDao {
	public ArrayList<BooklistVo> listAll() {
		ArrayList<BooklistVo> list = new ArrayList<BooklistVo>();
		
		String sql = "select * from book order by bookid";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BooklistVo b = new BooklistVo();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
				list.add(b);
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		} finally {
			ConnectionProvider.close(conn, stmt, rs);
			
		}
		
		return list;
	
		
	}
	
	// �˻�� �ش��ϴ� ��������� json���� �����ϱ� ���� �޼ҵ�
	public ArrayList<BooklistVo> searchBook(String keyword){
		ArrayList<BooklistVo> list = new ArrayList<BooklistVo>();
		
		String sql = "select * from book where bookname like '%"+keyword+"%' order by bookid";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BooklistVo b = new BooklistVo();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
				list.add(b);
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		} finally {
			ConnectionProvider.close(conn, stmt, rs);
		}
		
		return list;
	} 
	
	//���ο� ������ ����ϴ� �żҵ� 
		public int insertBook(BooklistVo b) {
	
			int re = -1;
			String sql = "insert into book values("+b.getBookid()+", '"+b.getBookname()+"', '"+b.getPublisher()+"', "+b.getPrice()+")";
			Connection conn = null;
			Statement stmt = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				stmt = conn.createStatement();
				re = stmt.executeUpdate(sql);
				
			} catch (Exception e) {
				System.out.println("���ܹ߻�:" + e.getMessage());
			} finally {
				ConnectionProvider.close(conn, stmt);
			}
			
			return re;
		} 

}
