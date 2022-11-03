package com.iu.home.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberServiceTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("manager1");
		//passwordEncoder.encode("admin1"); -> admin1이라는 비번을 인코딩 시키겠다.(암호화)
		memberVO.setPw(passwordEncoder.encode("manager1"));
		memberVO.setEmail("manager1@gmail.com");
		int result = memberMapper.setAdd(memberVO);
		assertEquals(1, result);
	}

}
