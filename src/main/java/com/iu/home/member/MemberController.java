package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public String setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
//		MemberVO memberVO = new MemberVO();
//		model.addAttribute("vo", memberVO);
		return "./member/join";
	}
	
	@PostMapping("join")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		
//		if(bindingResult.hasErrors()) {
//			log.info("===검증에러발생====");
//			//검증에 실패하면 회원가입하는 jsp로 이동 foward
//			mv.setViewName("member/join");
//			return mv;
//		}
		
		boolean check = memberService.getPwCheck(memberVO, bindingResult);

		if(check) {
			mv.setViewName("member/join");
			List<FieldError> errors= bindingResult.getFieldErrors();
			
			for(FieldError fieldError:errors) {
				log.info("fieldError -> {}", fieldError);
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			return mv;
		}
		//int result = memberService.setAdd(memberVO);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		
		return "./member/login";
	}
	
//	@PostMapping("login")
//	public String getLogin(MemberVO memberVO, HttpSession session)throws Exception{
//		memberVO = memberService.getLogin(memberVO);
//		session.setAttribute("member", memberVO);
//		if(memberVO == null) {
//			return "./member/login";
//		}
//		return "redirect:../";
//	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO)throws Exception{
		int result = memberService.getIdCheck(memberVO);
		if(result ==0) {
			throw new Exception("에러 테스트");
		}
		return result;
	}
	@PostMapping("test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String[] ar)throws Exception{
		for(String s : ar) {
			log.info("ar : {}", s);
		}
		return memberVO;
	}
}
