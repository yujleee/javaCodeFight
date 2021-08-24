package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManger;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDao {
	
	public static int pageSIZE = 10; //화면에 보여줄 페이지 수
	public static int totalRecord = 10; 
	public static int totalPage;
	
	public List<BoardVO> list(HashMap map){
		return DBManger.listBoard(map);
	}
	
	public int getNextNo() {
		return DBManger.getNextNo();
	}
	
	public int insert(BoardVO b) {
		return DBManger.insertBoard(b);
	}
	
	public BoardVO getBoard(int no) {
		return DBManger.getBoard(no);
	}
	
	public void updateHit(int no) {
		DBManger.updateHit(no);
	}

	public void updateStep(int b_ref, int b_step) {
		DBManger.updateStep(b_ref, b_step);
	}
	
	public int update(BoardVO b) {
		return DBManger.updateBoard(b);
	}
	
	public int delete(int no, String pwd) {
		return DBManger.deleteBoard(no, pwd);
	}
	
	
	public int getTotalRecord() {
		return DBManger.getTotalRecord();
	}
	
	
}
