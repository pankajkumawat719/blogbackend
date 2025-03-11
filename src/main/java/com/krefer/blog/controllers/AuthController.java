package com.krefer.blog.controllers;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krefer.blog.entity.User;
import com.krefer.blog.exception.ApiException;
import com.krefer.blog.payloads.JwtAutResponse;
import com.krefer.blog.payloads.JwtAuthRequest;
import com.krefer.blog.payloads.UserDto;
import com.krefer.blog.repositories.UserRepo;
import com.krefer.blog.security.JwtTokenHelper;
import com.krefer.blog.services.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAutResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
	
		this.authenticat(request.getUsername(), request.getPassword());
		
	UserDetails userDetails = 	this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
	JwtAutResponse response =  new JwtAutResponse();
	response.setToken(token);
	response.setUser(this.modelMapper.map((User) userDetails,UserDto.class));
	return new ResponseEntity<JwtAutResponse>(response, HttpStatus.OK);
	}
	
	private void authenticat(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		try {
			authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			System.out.println("invalid detials");
			throw new ApiException("invalid username and password");
		}
	}
	
	// register new user api 
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto )
	{
		UserDto registeredUser = this.userService.registerNewUser(userDto);
		
		return  new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
	}
	
	//get login user data
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ResponseEntity<UserDto>getUser(Principal principal){
		User user = this.userRepo.findByEmail(principal.getName()).get();
		
		return new ResponseEntity<UserDto>(this.modelMapper.map(user, UserDto.class),HttpStatus.OK);
	}
	
	
	
}
