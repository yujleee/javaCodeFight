package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.MemberVO;
import com.example.demo.vo.Sist_log;

public class DBManger {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static List<BoardVO> listBoard(HashMap map){
		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.findAll", map);
		session.close();
		return list;
	}
	
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.getNextNo");
		session.close();
		return no;
	}
	
	
	public static int insertBoard(BoardVO b) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("board.insert", b);
		session.close();
		return re;
	}
	
	public static BoardVO getBoard(int no) {
		SqlSession session = factory.openSession();
		BoardVO b = session.selectOne("board.getBoard", no);
		return b;
	}
	
	public static void updateHit(int no) {
		SqlSession session = factory.openSession(true);
		session.update("board.updateHit", no);
		session.close();
	}


	public static void updateStep(int b_ref, int b_step) {
		SqlSession session = factory.openSession();
		HashMap map = new HashMap<>();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		
		session.update("board.updateStep", map);
		session.commit();
		session.close();
	}
	
	public static int updateBoard(BoardVO b) {
		SqlSession session = factory.openSession(true);
		int re = session.update("board.updateBoard", b);
		session.close();
		return re;
	}
	
	public static int deleteBoard (int no, String pwd) {
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		
		int re = session.delete("board.deleteBoard", map);
		session.close();
		return re;
	}
	
	public static int getTotalRecord() {
		SqlSession session = factory.openSession();
		int n = session.selectOne("board.totalRecord");
		session.close();
		return n;
	}
	
	public static void insertLog(Sist_log log) {
		SqlSession session = factory.openSession(true);
		session.insert("board.insertLog", log);
		session.close();
	}
	
	
	public static int insertMember(MemberVO m) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("member.insert", m);
		session.close();
		return re;
	}
}
