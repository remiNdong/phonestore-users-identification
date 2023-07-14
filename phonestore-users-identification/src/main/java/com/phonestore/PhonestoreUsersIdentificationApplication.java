package com.phonestore;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.phonestore.administration.domain.User;
import com.phonestore.administration.service.UserService;

@SpringBootApplication
public class PhonestoreUsersIdentificationApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(PhonestoreUsersIdentificationApplication.class, args);
	}
	
	/*
	 * Methode qui a servi a inserer un User de chaque type a la premiere utilisation en utilisant l'algo de cryptage
	@PostConstruct
	void init_users() {


	//ajouter les users
	userService.saveUser(new User(null, "gerant@hotmail.fr", "Jean", "Legérant", "0601020304", "gerant01", null));
	userService.saveUser(new User(null, "employe@hotmail.fr", "John", "Lebosseur", "0611121314", "employe01", null));
	userService.saveUser(new User(null, "client@hotmail.fr", "Jack", "Leclient", "0621222324", "client01", null));
	
	
	
	//ajouter les rôles aux users
	
	userService.addRoleToUser("gerant@hotmail.fr", "ADMIN");
	userService.addRoleToUser("employe@hotmail.fr", "EMP");
	userService.addRoleToUser("client@hotmail.fr", "USER");
	
	
	}
	*/
	

	
	@Bean
	BCryptPasswordEncoder getBCE() {
		return new BCryptPasswordEncoder();
	}

}
