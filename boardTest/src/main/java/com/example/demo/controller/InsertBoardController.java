package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVO;


@Controller
@RequestMapping("/insertBoard.do")
public class InsertBoardController {

	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	//답글 작성시에는 부모글의 글번호를 가져옴 
	@RequestMapping(method = RequestMethod.GET)
	public void form(HttpServletRequest request, Model model, @RequestParam(value="no", defaultValue = "0") int no) {
		//int no = Integer.parseInt(request.getParameter("no") 를 실행. 
		//새글 작성시에는 NullPointerException 발생. 매개변수에 기본값 설정!
		System.out.println("no: " + no);
		model.addAttribute("no", no); //글 작성을 위한 번호 상태 유지 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVO b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String path = request.getRealPath("/resources/images");
		System.out.println("path: " + path);
		
		int pno = b.getNo(); //부모글 번호
		
		//새 글일 때의 처리
		int no = dao.getNextNo();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;

		//답글일 때의 처리
		if(pno != 0) {
			BoardVO p = dao.getBoard(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			dao.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		
		b.setIp(request.getRemoteAddr());
		
		//파일 업로드
		String fname = null;
		int fsize = 0;
		MultipartFile uploadFile = b.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		if( fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				fsize= data.length; //파일 크기
				b.setFname(fname);
				b.setFsize(fsize);
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			//업로드할 파일이 없을 경우
			b.setFname("");
			b.setFsize(0);
		}
		
		
		int re = dao.insert(b);
		if(re != 1) {
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
}
