package com.krefer.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.krefer.blog.entity.User;
import com.krefer.blog.exception.ResourceNotFoundException;
import com.krefer.blog.repositories.UserRepo;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class CustomUserDetailsSecurity implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("username", "username email: ", 0));
		return user;
	}

}
