package com.phonestore.catalogue.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.phonestore.administration.domain.Role;

public class UserCreationDTO {

	@Email
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

	@NotNull
	private List<Role> roles;

}
