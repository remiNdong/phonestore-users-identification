package com.phonestore.administration.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

	@Column(unique = true)
	private String username;
	
	private String prenom;
	
	private String nom;
	
	private String numeroTel;

	private String password;
	
	//en realite dans la logique metier un utilisateur n'aura qu'un seul role

	  @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
				   inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles;


}
