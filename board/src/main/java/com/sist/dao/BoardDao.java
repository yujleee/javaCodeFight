package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVo;

public class BoardDao {
	
	//�̱��� ��ü�� dao ���� 
	private static BoardDao dao = null;
	
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	
	// ���ο� �۹�ȣ�� ��ȯ�ϴ� �޼ҵ�
	public int getNextNo() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from board";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return no;
	}
	
	//�̹� �ִ� �޷��ִ� ��۵��� b_step�� 1�� ������Ű�� ���� �޼ҵ�
	public void updateStep(int b_ref, int b_step) {
		String sql = "update board set b_step = b_step+1 where b_ref=? and b_step>?";
		//�θ���� b_ref, b_step�� ���޹޾� step�� 1�� ������Ų��. b_ref�� �θ�۰� �����ϰ� �θ�ۺ��� step�� ū �۵�(��۵鿡 ����)
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			int re = pstmt.executeUpdate();
			System.out.println("re" + re);
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
	
	
	public static int pageSIZE = 10; //�� ȭ�鿡 ������ ���ڵ��� �� 
	
	public static int totalRecord; //��ü ���ڵ� ��(�Խù� ����)
	public static int totalPage; //��ü ������ ��
	
	public int getTotalCount() {
		int n = 0;
		
		try {
			String sql = "select count(*) from board";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				n = rs.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return n;
		
	}
	
	
	public int delete(int no, String pwd) {
		int re = -1;
		String sql = "delete from board where no=? and pwd=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return re;
	}
	
	public int update(BoardVo b) {
		int re = -1;
		
		try {
			String sql = "update board set title=?, content=?, fname=? where no=? and pwd=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFname());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return re;
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
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
	
	public BoardVo findByNo(int no) {
		BoardVo b = new BoardVo();
		try {
			String sql = "select no,title,writer,pwd,content,hit,regdate,fname,ip,b_ref,b_level,b_step from board where no=?";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new BoardVo(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getDate(7),
						rs.getString(8), 
						rs.getString(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getInt(12));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return b;
	}
	
	
	public ArrayList<BoardVo> findAll(int pageNUM) {
		
		//��ü ���ڵ� �� 
		totalRecord = getTotalCount();
		//��ü ������ �� 
		totalPage = (int)Math.ceil(totalRecord / (double)pageSIZE); 
		//�ڹٿ����� ����/���� = �����̱⶧���� ������ double�� ĳ�����Ͽ� �ø� ����!
		//�ø������ double�̱� ������ int�� ����ȯ 
		System.out.println("totalRecord:" + totalRecord);
		System.out.println("totalPage:" + totalPage);
		
		//���� ���ڵ�, ������ ���ڵ�
		int start = (pageNUM -1) * pageSIZE + 1;
		int end = start + pageSIZE;
		
		if(end > totalRecord) {
			end = totalRecord;
		}
		
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "select no, title, writer, pwd, content, hit, regdate, fname, ip, b_ref, b_level, b_step from( "
				+ "select rownum n, no, title, writer, pwd, content, hit, regdate, fname, ip, b_ref, b_level, b_step from( "
				+ "select no, title, writer, pwd, content, hit, regdate, fname, ip, b_ref, b_level, b_step from board order by b_ref, b_step)) where n between ? and ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		
		return list;
	} 
	
	public int insert(BoardVo b) {
		int re = -1;
		
		try {
			String sql="insert into board(no,title,writer,pwd,content,hit,regdate,fname,ip,b_ref,b_level,b_step) values(?, ?, ?, ?, ?, 0, sysdate, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setString(7, b.getIp());
			pstmt.setInt(8, b.getB_ref());
			pstmt.setInt(9, b.getB_level());
			pstmt.setInt(10, b.getB_step());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		
		return re;
	}
	
	
}
