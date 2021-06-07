package com.sist.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class orderDao {
	
	public int getNextNo() {
		int no = 0; //새로운 주문번호
		
		try {
			String sql = "select nvl(max(주문번호),0)+1 from 주문";
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				no = rs.getInt(1);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return no;
	}
	
	public void insertOrder(String custid, String []itemno, int []qty, int []price, int []salePrice, int total, int no) {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "c##madang";
			String pwd = "madang";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
		
			String sql = "insert into 주문 values("+no+", sysdate, "+total+", 'N', "+custid+")";
			int re1 = stmt.executeUpdate(sql);
			System.out.println(re1);
	
			int re2 = 0; 	
			Statement stmt2 = conn.createStatement();
			if(re1 > 0){ 
				//주문상세테이블에 레코드 추가 insert
				for(int i=0; i<itemno.length; i++){
					String sql2 = "insert into 주문상세(주문번호, 제품번호, 주문수량, 주문금액) values("+no+","+itemno[i]+","+qty[i]+","+salePrice[i]+")";
					re2 += stmt2.executeUpdate(sql2); // insert 결과 누적  
				}
			}
			
			if (re1 == 1 && re2 == itemno.length){ //주문한 수만큼 insert가 되었는가?
				conn.commit();	
				System.out.println("주문완료");
			}else{
				conn.rollback(); 
				System.out.println("주문실패 ");
			}
			
		} catch (Exception e){
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}
	
}
