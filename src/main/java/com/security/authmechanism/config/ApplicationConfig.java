package com.security.authmechanism.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.authmechanism.dao.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	@Autowired
	private final UserRepository repository;

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

}