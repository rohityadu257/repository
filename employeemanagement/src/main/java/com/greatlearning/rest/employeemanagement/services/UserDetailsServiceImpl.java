package com.greatlearning.rest.employeemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.rest.employeemanagement.repository.UserRepo;
import com.greatlearning.rest.employeemanagement.entity.User;
import com.greatlearning.rest.employeemanagement.repository.UserRepo;
import com.greatlearning.rest.employeemanagement.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("could not find user"+username);
		}
		com.greatlearning.rest.employeemanagement.security.MyUserDetails myUserDetails = new MyUserDetails(user);
		return new MyUserDetails(user);
	}
}
