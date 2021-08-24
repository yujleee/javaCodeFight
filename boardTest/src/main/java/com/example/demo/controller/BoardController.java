package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;

@Controller
public class BoardController {

	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		return mav;
	}
	
	@RequestMapping("/listBoard.do")
	public void list(HttpServletRequest request, @RequestParam(value = "pageNUM", defaultValue ="1") int pageNUM, Model model){
		System.out.println("pageNUM:" + pageNUM );
		BoardDao.totalRecord = dao.getTotalRecord();
		BoardDao.totalPage = (int)Math.ceil( (double)BoardDao.totalRecord / BoardDao.pageSIZE );
		
		int start = (pageNUM-1)* BoardDao.pageSIZE +1 ;
		int end = start+ BoardDao.pageSIZE -1;
		
		
		if(end > BoardDao.totalRecord) {
			end = BoardDao.totalRecord;
		}
		
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//정수로 캐스팅. ceil은 올림수이기 때문에 double형이어야 함. 정수/정수=>정수이기 때문에 둘 중 하나를 double로 캐스팅 
		model.addAttribute("list", dao.list(map));
		model.addAttribute("totalPage", BoardDao.totalPage);
	}
	
	@RequestMapping("/detailBoard.do")
	public void detail(HttpServletRequest request, Model model, int no) {
		dao.updateHit(no);
		model.addAttribute("b", dao.getBoard(no));
	}
	
	
	
}
