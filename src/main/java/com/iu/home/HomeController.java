package com.iu.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.Pager;
import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;

@Controller
public class HomeController {
	
	//@Value("${my.message.hi}")
	private String message;
	
	@Value("${my.default}")
	private String app;
	
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "MemberRole";
	}
	
	@GetMapping("/")
	public String Home()throws Exception {
		log.info("=======================================");
		log.info("message : {}",message);
		log.info("=======================================");
		log.info("default {}", app);
//		log.error("error message");
//		log.warn("warn message");
//		log.info("info message");
//		log.debug("debug message");
//		log.trace("trace message");
	
		return "index";
	}

}
