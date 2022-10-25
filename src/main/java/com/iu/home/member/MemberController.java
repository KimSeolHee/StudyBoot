package com.iu.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public String setAdd()throws Exception{

		return "./member/join";
	}
	
	@PostMapping("join")
	public String setAdd(MemberVO memberVO)throws Exception{
		int result = memberService.setAdd(memberVO);
		if(result == 1) {
			return "redirect:/";
		}else {
			return "./member/join";
		}
	}
	
	@GetMapping("login")
	public String getLogin()throws Exception{
		
		return "./member/login";
	}
	
	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session)throws Exception{
		memberVO = memberService.getLogin(memberVO);
		session.setAttribute("member", memberVO);
		if(memberVO == null) {
			return "./member/login";
		}
		return "redirect:../";
	}
}
