package com.phonestore;

import com.phonestore.administration.dto.UserCreationDTO;

public class DefaultContent {
	
	public static UserCreationDTO userCreationDTOEmploye() {
		
		return new UserCreationDTO("employe@hotmail.fr", "John", "Lebosseur", "0611121314", "employe01", "employe01");
	}
	
public static UserCreationDTO userCreationDTOUsager() {
		
		return new UserCreationDTO("client@hotmail.fr", "Jack", "Leclient", "0621222324", "client01", "client01");
	}


}
