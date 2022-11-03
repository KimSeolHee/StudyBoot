package com.iu.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	
	@NotBlank(message = "ID는 꼭 넣어줘~!")
	private String id;
	@NotBlank
//	@Size(min = 4, max = 10)
	private String pw;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private Boolean enabled;
	private String pwCheck;
	
	@Range(max = 150, min = 0)
	private int age;
	@Past
	private Date birth;
	
	private List<RoleVO> roleVOs;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// <? super T>
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));	
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// PW 반환
		return this.getPw();
	}

	@Override
	public String getUsername() {
		// ID 반환
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정의 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정의 잠김 여부
		// true : 잠기지 않음
		// false : 계정이 잠김. 로그인 불가
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		// true : 만료 안됨
		// false : 만료됨, 로그인 안됨
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정사용여부(임시 회원-인증이 덜됬거나 추가적인 작업이 아직 끝나지 않은...)
		// true : 계정이 활성화되어 사용가능
		//false : 계정 비활성화, 계정사용 불가능
		return true;
	}
	
	
}
