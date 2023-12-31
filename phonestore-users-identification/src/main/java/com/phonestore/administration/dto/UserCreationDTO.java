package com.phonestore.administration.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.phonestore.administration.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {

	@NotBlank
	private String username;

	@NotBlank
	private String prenom;

	@NotBlank
	private String nom;

	@NotBlank
	private String numeroTel;

	@NotBlank
	private String password1;

	@NotBlank
	private String password2;

	

}
