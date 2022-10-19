package com.iu.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("list")
	public ModelAndView list(Pager pager)throws Exception{
		pager.makeRow();
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd()throws Exception{
		return "board/write";
	}
	
	@PostMapping("add")
	public String setAdd(QnaVO qnaVO, MultipartFile [] files, RedirectAttributes redirectAttributes)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setAdd(qnaVO);
//		log.info("Insert확인 : {} {}", result, qnaVO);
		
		redirectAttributes.addAttribute("result", result);
		return "redirect:./list";
	}

}