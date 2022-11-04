package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccess implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("=================로그인 성공=================");
		log.info("Auth =>{}",authentication);
		log.info("ID : {}", request.getParameter("id"));
		log.info("체크박스 확인 => {}", request.getParameter("rememberId"));
		String checkBox = request.getParameter("rememberId");
		if(checkBox != null && checkBox.equals("on")) {
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			log.info("들어왔나확인");
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60);//초
			cookie.setPath("/");//같은 도메인 내에서 어느 URL에서 사용가능한가?	
			
			response.addCookie(cookie);
			
		}else {
			Cookie [] cookies = request.getCookies();
			
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					log.info("쿠키삭제");
					cookie.setPath("/");//쿠키 삭제 시 쿠키를 만들때의 패스와 동일하여야한다.
					response.addCookie(cookie);
					break;
				}
			}
			
		}
		
		response.sendRedirect("/");
	}

}
