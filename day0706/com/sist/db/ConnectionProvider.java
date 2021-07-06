package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	public static Connection getConnection() {
		// connection�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		Connection conn = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url= "jdbc:oracle:thin:@192.168.123.107:1521:XE";
			String user= "c##madang";
			String pwd= "madang";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return conn;
	}

	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		//connection, statement, resultset�� �����Ű�� �޼ҵ�
		try {
			if(rs != null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
}
