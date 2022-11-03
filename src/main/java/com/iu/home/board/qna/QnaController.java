package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
	public String setAdd(@ModelAttribute QnaVO qnaVO)throws Exception{
		
		return "board/write";
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid QnaVO qnaVO,BindingResult bindingResult, ModelAndView mv, MultipartFile [] files, RedirectAttributes redirectAttributes)throws Exception{
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/write");
		}else {
			mv.setViewName("redirect:./list");
		}
		//int result = qnaService.setAdd(qnaVO);
//		log.info("Insert확인 : {} {}", result, qnaVO);
		
		//redirectAttributes.addAttribute("result", result);
		

		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(QnaVO qnaVO,ModelAndView mv)throws Exception{
		qnaVO = qnaService.getDetail(qnaVO);
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(QnaVO qnaVO)throws Exception{
		int result = qnaService.setUpdate(qnaVO);
		return "redirect: ../../list";
	}
	
	@PostMapping("delete")
	@ResponseBody
	public int setDelete(QnaFileVO qnaFileVO)throws Exception{
		log.info("num : {}", qnaFileVO.getFileNum());
		int result = qnaService.setDelete(qnaFileVO);
		
		return result;
	}

}
