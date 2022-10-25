package com.iu.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.home.interceptors.StudyInterceptor;
import com.iu.home.interceptors.TestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired //IOC(inversion of control)
	private TestInterceptor testInterceptor;
	
	@Autowired
	private StudyInterceptor studyInterceptor;
	
	@Override
		public void addInterceptors(InterceptorRegistry registry) {
		//method 체인	
		//적용할 interceptor 등록
		registry.addInterceptor(testInterceptor)
		//interceptor를 적용할 URL등록
				.addPathPatterns("/qna/**")
		//제외할 URL등록
				.excludePathPatterns("/qna/detail")
				.excludePathPatterns("qna/write");
		
		//추가 interceptor등록
		registry.addInterceptor(studyInterceptor)
				.addPathPatterns("/qna/**");
			// TODO Auto-generated method stub
			//WebMvcConfigurer.super.addInterceptors(registry);
		}
	

}
