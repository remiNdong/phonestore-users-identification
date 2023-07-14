package com.phonestore.catalogue.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
	
	@Email
	private String username;
	
	
	
	@NotBlank
	private String password;

}
