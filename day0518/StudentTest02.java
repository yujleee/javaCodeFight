package exam01;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

class StudentTest02 
{
	public static void main(String[] args) 
	{
		String name;
		int kor,eng,math,tot,avg;

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력==>");
		name = sc.next();
		System.out.print("국어점수 입력==>");
		kor = sc.nextInt();
		System.out.print("영어점수 입력==>");
		eng = sc.nextInt();
		System.out.print("수학점수 입력==>");
		math = sc.nextInt();
		
		tot= kor + eng + math;
		avg = tot/3;

		try{
			//1.jdbc 드라이버를 메모리로 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); //jdbc 종류에 따라 드라이버가 다름 
			// oracle.jdbc.driver. 패키지 OracleDriver 클래스

			//2. DB 서버에 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##scott","tiger"); //유저명,비밀번호
			//DB서버 url 연결 MySQL인 경우 등에 따라 각각 다름 jdbc:oracle:thin:@IP주소:포트번호:서비스명     자기 ip면 @localhost해도됨.
			
			//createStatement() db의 Sql 명령을 내보내는 Statement 객체를 생성하는 메소드
			//3. DB 명령어를 실행할 수 있는 Statement 객체를 생성 
			Statement stmt = conn.createStatement();

			//4. DB 명령 실행
			String sql = "insert into Student values('"+name+"', "+kor+", "+eng+", "+math+", "+tot+", "+avg+")";
			System.out.println(sql); //sql 명령어 생성여부 확인 
			int re = stmt.executeUpdate(sql); //자바에서 연동할 때는 세미콜론 안넣음
			 
			//5. 사용한 자원 닫음
			stmt.close();
			conn.close();

			if (re == 1)
			{
				System.out.println("학생의 정보를 추가했습니다.");
			} else{
				System.out.println("추가에 실패했습니다");
			}
			


		} catch(Exception e){
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}
}
