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
	
	//id와 pwd를 매개변수로 전달받아 올바른 회원인지 판별하는 메소드 정의
	public boolean isMember(String id, String pwd) {
		boolean re = false;
		String sql = "select * from member where id='"+id+"' and pwd = '"+pwd+"'";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, db_pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) { //rs.next()를 실행할 수 있으면 회원
				re = true;
			}
			
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		
		
		return re;
	}

}
