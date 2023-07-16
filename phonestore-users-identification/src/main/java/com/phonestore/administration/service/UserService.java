package com.phonestore.administration.service;

import java.util.List;

import com.phonestore.administration.domain.Role;
import com.phonestore.administration.domain.User;
import com.phonestore.administration.dto.UserCreationDTO;
import com.phonestore.administration.dto.UserDTO;

public interface UserService {

	User saveUser(User user);
	
	UserDTO saveUsager(UserCreationDTO user);
	
	UserDTO saveEmploye(UserCreationDTO user);

	User findUserByUsername(String username);
	
	UserDTO findUserDTOByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
	
	List<User> findAllUsers();
	
	User findById(Long id);
	
	
}
