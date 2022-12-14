package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.iu.home.member.security.LoginFail;
import com.iu.home.member.security.LoginSuccess;
import com.iu.home.member.security.LogoutCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private LoginSuccess loginSuccess;
	
	@Autowired
	private LoginFail loginFail;
	
	@Autowired
	private LogoutCustom logoutCustom;
	
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;

	//Security에서 무시해야하는 URL패턴 등록
	@Bean
	//public을 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/board/**").hasRole("MEMBER")
					.antMatchers("/board/add").hasRole("ADMIN")
					.anyRequest().permitAll()
					.and()
				.formLogin() //로그인 폼 인증 설정
					.loginPage("/member/login")//내장된 로그인폼을 사용하지 않고 개발자가 만든 폼 요청(URL)
					//.loginProcessingUrl(null) //로그인을 진행 요청할 form태그에 action의 주소지정
					.passwordParameter("pw")//패스워드 파라미터는 password이지만 개발자가 다른 파라미터 이름을 사용할 때 
					.usernameParameter("id")//아이디 파라미터는 username이지만 개발자가 다른 파라미터 이름을 사용할 때
					//.defaultSuccessUrl("/")//인증에 성공할 경우 요청할 url
					.successHandler(loginSuccess)
					//.failureUrl("/member/login?error=true&message=LoginFail")//인증에 실패 했을 경우 요청할 URL
					.failureHandler(loginFail)
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/member/logout")
					//.logoutSuccessUrl("/")
					.logoutSuccessHandler(logoutSuccessHandler)//로그아웃 성공 후 해야할 일을 구성
					.addLogoutHandler(logoutCustom)//로그아웃시 해야할 일을 구성
					.invalidateHttpSession(true)//세션 폐기 (세션 만료시키기)
					.deleteCookies("JSESSIONID")
					.permitAll();
		
		return httpSecurity.build();
	}
	
	//평문(Clear Text)을 암호화 시켜주는 객체생성
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
