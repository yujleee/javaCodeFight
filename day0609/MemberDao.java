package com.sist.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.123.105:1521:XE";
	String user = "c##madang";
	String db_pwd = "madang";
	
	//id�� pwd�� �Ű������� ���޹޾� �ùٸ� ȸ������ �Ǻ��ϴ� �޼ҵ� ����
	public boolean isMember(String id, String pwd) {
		boolean re = false;
		String sql = "select * from member where id='"+id+"' and pwd = '"+pwd+"'";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, db_pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) { //rs.next()�� ������ �� ������ ȸ��
				re = true;
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		
		
		return re;
	}

}
