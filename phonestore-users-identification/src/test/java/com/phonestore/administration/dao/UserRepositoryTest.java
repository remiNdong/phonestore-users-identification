package com.phonestore.administration.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.phonestore.TestDBConfig;
import com.phonestore.administration.domain.Role;
import com.phonestore.administration.domain.User;

@DataJpaTest
@ActiveProfiles("test") // active application-test.properties en PLUS de application.properties
@Import({ TestDBConfig.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // use mysql, not an embedded DB
public class UserRepositoryTest {
	
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	 @Autowired
	    EntityManager entityManager; // to clear cache during tests...
	 
		/**
		 * tests if findAll returns all the users
		 * 
		 * @throws Exception
		 */
		@Test
		@Sql("/testsql/loadUser.sql")
		public void findAllRole() throws Exception {
			List<User> list = userRepository.findAll();

			assertEquals(3,list.size());
		}
		
		/**
		 * tests if findByUserName returns the good User
		 * 
		 * @throws Exception
		 */
		@Test
		@Sql("/testsql/loadUser.sql")
		public void findByUsername() throws Exception {
			
			
			User admin = userRepository.findByUsername("gerant@hotmail.fr");
			assertEquals("Jean",admin.getPrenom());
			Role roleAdmin=roleRepository.findById(1L).get();
			List<Role> roles=admin.getRoles();
			assertEquals(roles.size(),1);
			assertTrue(roles.contains(roleAdmin));
			

			User emp = userRepository.findByUsername("employe@hotmail.fr");
			assertEquals("John",emp.getPrenom());
			Role roleEmp=roleRepository.findById(2L).get();
			 roles=emp.getRoles();
			assertEquals(roles.size(),1);
			assertTrue(roles.contains(roleEmp));
			
			

			User user = userRepository.findByUsername("client@hotmail.fr");
			assertEquals("Jack",user.getPrenom());
			Role roleUser=roleRepository.findById(3L).get();
			 roles=user.getRoles();
			assertEquals(roles.size(),1);
			assertTrue(roles.contains(roleUser));
			
		}
		

}
