package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManger;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDao {
	public int insert(MemberVO m) {
		return DBManger.insertMember(m);
	}
}
