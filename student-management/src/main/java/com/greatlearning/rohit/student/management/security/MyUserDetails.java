package com.greatlearning.rohit.student.management.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.rohit.student.management.entity.Role;
import com.greatlearning.rohit.student.management.entity.User;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {

	private User user;
	
	public MyUserDetails(User user) {
		super();
		this.user = user;
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()))	;	
			}
		return grantedAuthorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
