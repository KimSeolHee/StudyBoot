package com.iu.home.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public int setAdd(MemberVO memberVO)throws Exception{
		return memberMapper.setAdd(memberVO);
	}
	
	//로그인 처리는 Security에서 처리함.
//	public MemberVO getLogin(String username)throws Exception{
//		return memberMapper.getLogin(username);
//	}
	
	public int getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}

	//사용자 정의 검증 메서드
	public boolean getPwCheck(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;
		//check=false : 검증성공(error없음)
		//check=true : 검증실패(error있음)
		
		//1.annotation검증
		check = bindingResult.hasErrors();
				
		//password가 일치하는지 검증
		if(memberVO.getPw().equals(memberVO.getPwCheck())){
			check=true;
			//에러메세지
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//사용자 정의 검증 id가 중복인가??
		if(memberMapper.getIdCheck(memberVO)!=0) {
			check=true;
			bindingResult.rejectValue("id", "member.id.notEqual");
		}
		
		return check;
	}
}
