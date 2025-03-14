package com.krefer.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;

import com.krefer.blog.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min=3)
	private String name;
	
	@Email(message = "Enter a valid email..")
	private String email;
	@NotEmpty
	@Size(min=5)
	String password;
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
	
}
