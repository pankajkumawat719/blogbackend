package com.krefer.blog.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAutResponse {

	private String token;
	private UserDto user;

}
