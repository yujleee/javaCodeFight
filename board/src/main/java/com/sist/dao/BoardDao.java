package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVo;
import com.sist.vo.GoodsVo;

public class BoardDao {
	
	//싱글톤 객체로 dao 생성 
	private static BoardDao dao = null;
	
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}

	public void updateHit(int no) {
		String sql = "update board set hit=hit+1 where no=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	
	public BoardVo findByNo(int no) {
		BoardVo b = null;
		
		String sql = "select * from board where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				b = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return b;
	}
	
	
	public ArrayList<BoardVo> findAll() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "select * from board order by no";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		
		return list;
	} 
	
	public int insert(BoardVo b) {
		int re = -1;
		
		try {
			String sql="insert into board(no,title,writer,pwd,content,hit,regdate,fname,ip) values(seq_board.nextval, ?, ?, ?, ?, 0, sysdate, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getPwd());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getFname());
			pstmt.setString(6, b.getIp());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		
		return re;
	}
	
	
}
