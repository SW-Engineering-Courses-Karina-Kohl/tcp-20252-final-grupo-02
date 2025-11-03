package main;

import java.util.ArrayList;

public class Creator extends User {
	
	private ArrayList<BookClub> createdBookClubs;
	
	public Creator(String name, String surname, String email, String password) {
		
		super(name, surname, email, password);
		
		this.createdBookClubs = new ArrayList<BookClub>();
		
	}
	
	public ArrayList<BookClub> getCreatedBookClubs() {
		
		return this.createdBookClubs;
		
	}

}
