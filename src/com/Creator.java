package com;

import java.util.ArrayList;

public class Creator extends User {
	
	private ArrayList<BookClub> createdBookClubs;
	
	public Creator(String name, String surname, String cpf, String email, String password) {
		
		super(name, surname, cpf, email, password);
		
		this.createdBookClubs = new ArrayList<BookClub>();
		
	}
	
	public ArrayList<BookClub> getCreatedBookClubs() {
		
		return this.createdBookClubs;
		
	}

}