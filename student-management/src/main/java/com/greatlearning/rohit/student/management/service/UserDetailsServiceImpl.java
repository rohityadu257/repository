package com.greatlearning.rohit.student.management.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.rohit.student.management.entity.User;
import com.greatlearning.rohit.student.management.repository.UserRepository;
import com.greatlearning.rohit.student.management.security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {
		
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("could not find user"+username);
		}
		MyUserDetails myUserDetails = new MyUserDetails(user);
		return new MyUserDetails(user);
	}


}
