package com.phonestore.administration.service;

import com.phonestore.administration.domain.Role;
import com.phonestore.administration.domain.User;
import com.phonestore.catalogue.dto.UserCreationDTO;
import com.phonestore.catalogue.dto.UserDTO;

public interface UserService {


	UserDTO saveUser(UserCreationDTO user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
	
	
	
	
}
