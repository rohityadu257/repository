package com.greatlearning.rest.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.rest.employeemanagement.services.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}


	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        
	        		.antMatchers("/").permitAll()
	                .antMatchers("/h2-console/**").permitAll();
	                http.csrf().disable().headers().frameOptions().disable();
	        		//.antMatchers("/employee", "/sortedby/{field}", "/getby/{id}")
	      //the above urls are accessible with roles USER and ADMIN
	      				//.hasAnyAuthority("USER", "ADMIN").antMatchers("/delete/{id}", "/addnew","/update/{id}")
	      //the above urls are accessible with role of ADMIN only
	      			//.hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
	      //successful login redirects to /student/list URL
	      			//	.successForwardUrl("/employee").permitAll().and().logout()
	      //logout redirects to /login  URL
	      				//.logoutSuccessUrl("/login").permitAll().and()
	      //unauthorized access attempt redirects to 403 URL
	      				//.exceptionHandling().accessDeniedPage("/403").and().cors().and().csrf().disable().headers().frameOptions().disable();
	      	}
	      
	       
	    }
	

