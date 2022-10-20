package com.iu.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
	@GetMapping("/fileDown/{path}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		log.info("Path : {}", path);
		//DB에서 정보 조회
		qnaFileVO.setFileName("d36561f1-a4e1-4766-bb29-17013aa3d9f1_다운로드.jpeg");
		qnaFileVO.setOriName("다운로드.jpeg");
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
	}

}
