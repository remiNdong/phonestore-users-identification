package com.phonestore.administration.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonestore.administration.dao.UserRepository;
import com.phonestore.administration.domain.User;
import com.phonestore.administration.service.UserService;

/*
 * Classe cree juste pour tester la restriction de l'url dans POSTMAN
 * tests non intégrés à Junit car les token sont limités dans le temps
 * ne sera pas utilisée dans les uses cases
 */

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	
	@Autowired
	UserService userService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	
	@RequestMapping(value = "one/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String getSimpleUser() {
		return "Autorisé à un User connecté";
	}
	
	@RequestMapping(value = "everybody", method = RequestMethod.GET)
	public String getEverybody() {
		return "Autorisé à un tout le monde";
	}
}
