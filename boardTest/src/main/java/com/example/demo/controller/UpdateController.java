package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVO;

@Controller
@RequestMapping("/updateBoard.do")
public class UpdateController {

	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(HttpServletRequest request,   Model model, int no) {
		//System.out.println(4/0); //일부러 예외발생
		model.addAttribute("b", dao.getBoard(no));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVO b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String path = request.getRealPath("/resources/images");
		System.out.println(path);
		
		String oldFname = b.getFname();
		int oldFsize = b.getFsize();
		
		String fname= null;
		int fsize = 0;
		
		MultipartFile uploadFile = b.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				fsize = data.length;
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				
				b.setFname(fname);
				b.setFsize(fsize);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		int re = dao.update(b);
		if(re != 1) {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		} else {
			//수정 성공
			if(fsize != 0) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		
		
		return mav;
	}
}
