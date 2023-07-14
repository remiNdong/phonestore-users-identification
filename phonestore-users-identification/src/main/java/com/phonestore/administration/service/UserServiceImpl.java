package com.phonestore.administration.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.phonestore.administration.dao.RoleRepository;
import com.phonestore.administration.dao.UserRepository;
import com.phonestore.administration.domain.Role;
import com.phonestore.administration.domain.User;
import com.phonestore.administration.dto.UserCreationDTO;
import com.phonestore.administration.dto.UserDTO;
import com.phonestore.administration.exception.PasswordDoesntMatchException;
import com.phonestore.administration.exception.UserDejaExistantException;

@Transactional
@Validated
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserDTO saveUsager(UserCreationDTO userCreationDTO) {
		
		if(userRepository.findByUsername(userCreationDTO.getUsername())!=null)
			throw new UserDejaExistantException();
			
		
		if(!userCreationDTO.getPassword1().equals(userCreationDTO.getPassword2()))
			throw new PasswordDoesntMatchException();
		
		//le role N°3 sera celui d'Usager
		Role roleUsager=roleRepository.findById(3L).get();
		List <Role> roles=new ArrayList<Role>();
		roles.add(roleUsager);
		
		User usager=UserDTOMapper.UserCreationDTOtoUsager(userCreationDTO);
		usager.setRoles(roles);
		usager.setPassword(bCryptPasswordEncoder.encode(userCreationDTO.getPassword1()));
		userRepository.save(usager);
		
		
		return UserDTOMapper.UsertoUserDTO(usager);
	}
	
	@Override
	public UserDTO saveEmploye(UserCreationDTO userCreationDTO) {
		if(userRepository.findByUsername(userCreationDTO.getUsername())!=null)
			throw new UserDejaExistantException();
			
		
		if(!userCreationDTO.getPassword1().equals(userCreationDTO.getPassword2()))
			throw new PasswordDoesntMatchException();
		
		//le role N°2 sera celui d'employe
		Role roleEmploye=roleRepository.findById(2L).get();
		List <Role> roles=new ArrayList<Role>();
		roles.add(roleEmploye);
		
		User employe=UserDTOMapper.UserCreationDTOtoUsager(userCreationDTO);
		employe.setRoles(roles);
		employe.setPassword(bCryptPasswordEncoder.encode(userCreationDTO.getPassword1()));
		userRepository.save(employe);
		
		
		return UserDTOMapper.UsertoUserDTO(employe);
	}

	@Override
	public User findUserByUsername(String username) {

		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDTO findUserDTOByUsername(String username) {
		
		
		return UserDTOMapper.UsertoUserDTO(userRepository.findByUsername(username));
	}


	/*
	 * A ete utilisee qu'au premier lancement pour creer les premiers User
	 */
	@Override
	public Role addRole(Role role) {

		return roleRepository.save(role);
	}

	/*
	 * A ete utilisee qu'au premier lancement pour creer les premiers User
	 */
	@Override
	public User addRoleToUser(String username, String rolename) {

		User usr = userRepository.findByUsername(username);
		Role r = roleRepository.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}


	

}
