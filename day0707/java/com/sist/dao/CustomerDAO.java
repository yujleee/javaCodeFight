package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.CustomerVO;

public class CustomerDAO {
	
	public int insertCustomer(CustomerVO c) {
		int re = -1;
		String sql = "insert into customer values(?, ?, ?, ?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getCustid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getAddress());
			pstmt.setString(4, c.getPhone());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
	public int updateCustomer(CustomerVO c) {
		int re = -1;
		String sql = "update customer set name=?, address=?, phone =? where custid = ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			pstmt.setInt(4, c.getCustid());
			//현재 물음표 기준 
			
			pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
	public int deleteCustomer(int custid) {
		int re = -1;
		String sql = "delete from customer where custid=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, custid);
			
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return re;
	}
	
	public ArrayList<CustomerVO> listAll(){
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		
		String sql= "select * from customer order by custid";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				/*CustomerVO c = new CustomerVO();
				c.setCustid(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setPhone(rs.getString(4));
				list.add(c);*/
				
				list.add(new CustomerVO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		
		
		return list;
	}

}
