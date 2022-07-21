package com.greatlearning.rest.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.rest.employeemanagement.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
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

		http.httpBasic().and().authorizeRequests().antMatchers("/h2-console/**").permitAll().and().csrf().disable()
				.headers().frameOptions().disable()

				.and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/allemployee/**", "/api/getemployeebyfirstname/**",
						"/Searchemployeeby/{field}/ASC","/Searchemployeeby/{field}/DESC")
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN").antMatchers(HttpMethod.GET, "/api/getuser/**", "/api/getrole/**")
				.hasAnyAuthority("ROLE_ADMIN").antMatchers(HttpMethod.POST, "/api/addnewemployee", "/api/updateemployee/**")
				.hasAnyAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.POST, "/api/addrole", "/api/adduser", "/api/assignrole/{userid}/{roleid}")
				.hasAnyAuthority("ROLE_ADMIN").antMatchers(HttpMethod.DELETE, "/api/deleteemployee/**")
				.hasAnyAuthority("ROLE_ADMIN").anyRequest().authenticated().and().exceptionHandling()
				.accessDeniedPage("/api/403");
	}

}
