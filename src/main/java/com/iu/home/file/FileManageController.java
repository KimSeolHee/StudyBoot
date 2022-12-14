package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/fileDown/{path}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		if(path.equals("qna")) {
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		}
		log.info("Path : {}", path);
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		// BeanNameResolver : 
		// view의 이름과 일치하는 bean의 이름이 있으면 해당 Bean실행
		
		// InternalResourceViewResolver
		// /WEB-INF/views/fileManger.jsp
		
		return mv;
	}

}
