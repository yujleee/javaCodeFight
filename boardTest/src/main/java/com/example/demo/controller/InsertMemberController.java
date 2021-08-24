package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class InsertMemberController {

	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/sendCode.do")
	@ResponseBody //뷰가 아닌 AJAX으로 데이터 전달을 위한 어노테이션 (code 응답_
	public String sendCode(String to) {
		String code = "";
		String from = "01025598279";
		
		//인증을 위한 난수 발생. AJAX으로 연결함. 
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		code = a+ ""+ b+ ""+c +""+d;
		BitSms sms = new BitSms();
		sms.sendMsg(from, to, code);
		
		return code;
	}
	

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String submit(MemberVO m) {
		int re = dao.insert(m);
		String msg = "회원가입에 성공했습니다.";
		
		if(re != 1) {
			msg = "회원가입에 실패했습니다.";
		}
		
		return msg;
	}
}
