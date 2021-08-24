package com.example.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;

@Controller
@RequestMapping("/deleteBoard.do")
public class DeleteBoardController {

	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(HttpServletRequest request, Model model, int no) {
		System.out.println("deleteBoard.do GET 동작");
		model.addAttribute("no", no);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, int no, String pwd) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String path = request.getRealPath("/resources/images");
		String oldFname = dao.getBoard(no).getFname();
		int fsize = dao.getBoard(no).getFsize();
		
		int re = dao.delete(no, pwd);
		
		if(re == 1) {
			if(fsize != 0) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		} else {
			mav.addObject("msg", "게시물 삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}
